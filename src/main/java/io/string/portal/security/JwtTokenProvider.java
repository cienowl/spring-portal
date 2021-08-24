package io.string.portal.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.string.portal.exception.InvalidAccessTokenException;
import io.string.portal.util.CollectionUtil;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
@NoArgsConstructor
public class JwtTokenProvider { // JWT 토큰을 생성 및 검증 모듈
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.access.name}")
    public String ACCESS_TOKEN;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // Request의 Header에서 token 가져오기
    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!CollectionUtil.isEmpty(bearer)) return bearer.replace("Bearer ", "");
        else return null;
    }

    // Jwt 토큰으로 인증 정보 반환
    public Authentication getAuthentication(String token) {
        String userId = this.getSubject(token);
        List<String> roles = this.getRoles(token);
        UserDetails userDetails = new SecurityUser(userId, roles);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // subject 추출 (userId)
    public String getSubject(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // role 추출 (권한 리스트)
    public List<String> getRoles(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("roles", ArrayList.class);
    }

    // Access token 유효성 체크
    public void validateAccessToken(String token) throws Exception {
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        if(!claims.getBody().get("type", String.class).equals(ACCESS_TOKEN)) {
            throw new InvalidAccessTokenException("Access Token이 아닙니다.");
        }
    }
}
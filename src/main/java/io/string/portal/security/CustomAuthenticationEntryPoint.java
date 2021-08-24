package io.string.portal.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.string.portal.web.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        try (OutputStream os = response.getOutputStream()) {
            String message = ex.getClass().getName();
            String data = ex.getMessage();
            if(request.getAttribute("exception")!=null) {
                Exception e = (Exception) request.getAttribute("exception");
                message = e.getClass().getName();
                data = e.getMessage();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(os, ResponseDTO.builder()
                    .result(false)
                    .status(HttpStatus.UNAUTHORIZED.value())
                    .message(message)
                    .data(data)
                    .build());
            os.flush();
        }
    }
}
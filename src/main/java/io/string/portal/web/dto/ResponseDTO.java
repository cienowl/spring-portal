package io.string.portal.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseDTO {
    @Schema(title = "성공여부", example = "true")
    private Boolean result;

    @Schema(title = "상태 : HTTP STATUS", example="200")
    private Integer status;

    @Schema(title = "메시지", example="Success")
    private String message;

    @Schema(title = "데이터", example="data")
    private Object data;
}
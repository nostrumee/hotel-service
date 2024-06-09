package by.edu.hotelservice.dto.response.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.Map;

@Builder
@Schema(description = "Error response")
public record MultiErrorResponse(

        @Schema(name = "status", example = "404")
        int status,

        @Schema(name = "message", example = "Hotel not found")
        String message,

        @Schema(name = "errors")
        Map<String, String> errors
) {
}

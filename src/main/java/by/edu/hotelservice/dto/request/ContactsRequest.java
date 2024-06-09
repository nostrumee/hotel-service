package by.edu.hotelservice.dto.request;

import by.edu.hotelservice.validation.annotation.ValidEmail;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Schema(description = "Contacts request")
@Builder
public record ContactsRequest(

        @Schema(name = "phone", example = "+375 17 309-80-00")
        @NotBlank(message = "{phone.notblank")
        String phone,

        @Schema(name = "email", example = "doubletreeminsk.info@hilton.com")
        @ValidEmail
        String email
) {
}

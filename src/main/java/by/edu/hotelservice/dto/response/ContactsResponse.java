package by.edu.hotelservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "Contacts response")
@Builder
public record ContactsResponse(

        @Schema(name = "phone", example = "+375 17 309-80-00")
        String phone,

        @Schema(name = "email", example = "doubletreeminsk.info@hilton.com")
        String email
) {
}

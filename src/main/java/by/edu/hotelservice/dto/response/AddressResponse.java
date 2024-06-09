package by.edu.hotelservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "Address response")
@Builder
public record AddressResponse(

        @Schema(name = "house number", example = "9")
        int houseNumber,

        @Schema(name = "street", example = "Pobediteley Avenue")
        String street,

        @Schema(name = "city", example = "Minsk")
        String city,

        @Schema(name = "country", example = "Belarus")
        String country,

        @Schema(name = "post code", example = "220004")
        String postCode
) {
}

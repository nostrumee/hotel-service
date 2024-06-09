package by.edu.hotelservice.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;

@Schema(description = "Address request")
@Builder
public record AddressRequest(

        @Schema(name = "house number", example = "9")
        @Range(min = 1, message= "{housenumber.valid}")
        int houseNumber,

        @Schema(name = "street", example = "Pobediteley Avenue")
        @NotBlank(message = "{street.notblank}")
        String street,

        @Schema(name = "city", example = "Minsk")
        @NotBlank(message = "{city.notblank}")
        String city,

        @Schema(name = "country", example = "Belarus")
        @NotBlank(message = "{country.notblank}")
        String country,

        @Schema(name = "post code", example = "220004")
        @NotBlank(message = "{postcode.notblank")
        String postCode
) {
}

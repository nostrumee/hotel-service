package by.edu.hotelservice.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Schema(description = "Hotel create request")
@Builder
public record HotelCreateRequest(

        @Schema(name = "name", example = "DoubleTree by Hilton Minsk")
        @NotBlank(message = "{name.notblank}")
        String name,

        @Schema(name = "description", example = "DoubleTree by Hilton Minsk")
        String description,

        @Schema(name = "brand", example = "Hilton")
        @NotBlank(message = "{brand.notblank}")
        String brand,

        @Schema(name = "address")
        @Valid
        AddressRequest address,

        @Schema(name = "contacts")
        @Valid
        ContactsRequest contacts,

        @Schema(name = "arrival time")
        @Valid
        ArrivalTimeRequest arrivalTime
) {
}

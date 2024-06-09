package by.edu.hotelservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Hotel response")
@Builder
public record HotelResponse(

        @Schema(name = "id", example = "1")
        long id,

        @Schema(name = "name", example = "DoubleTree by Hilton Minsk")
        String name,

        @Schema(name = "brand", example = "Hilton")
        String brand,

        @Schema(name = "address")
        AddressResponse address,

        @Schema(name = "contacts")
        ContactsResponse contacts,

        @Schema(name = "arrival time")
        ArrivalTimeResponse arrivalTime,

        @Schema(name = "amenities", example = "[\"Free WiFi\", \"Room service\", \"Free parking\"]")
        List<String> amenities
) {
}

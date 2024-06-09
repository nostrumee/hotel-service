package by.edu.hotelservice.dto.filter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Schema(description = "Filter params")
@Builder
public record HotelFilter(

        @Schema(name = "name", example = "DoubleTree by Hilton Minsk")
        String name,

        @Schema(name = "brand", example = "Hilton")
        String brand,

        @Schema(name = "city", example = "Minsk")
        String city,

        @Schema(name = "country", example = "Belarus")
        String country,

        @Schema(name = "amenities", example = "[\"Free WiFi\", \"Room service\", \"Free parking\"]")
        List<String> amenities
) {
}

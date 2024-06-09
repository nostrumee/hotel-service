package by.edu.hotelservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "Hotel short response")
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record HotelShortResponse(

        @Schema(name = "id", example = "1")
        long id,

        @Schema(name = "name", example = "DoubleTree by Hilton Minsk")
        String name,

        @Schema(name = "description", example = "DoubleTree by Hilton Minsk")
        String description,

        @Schema(name = "address", example = "9 Pobediteley Avenue, Minsk, 220004, Belarus")
        String address,

        @Schema(name = "phone", example = "+375 17 309-80-00")
        String phone
) {
}

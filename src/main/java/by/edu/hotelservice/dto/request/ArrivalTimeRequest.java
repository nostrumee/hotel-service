package by.edu.hotelservice.dto.request;

import by.edu.hotelservice.validation.annotation.ValidCheckIn;
import by.edu.hotelservice.validation.annotation.ValidCheckOut;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "Arrival time request")
@Builder
public record ArrivalTimeRequest(

        @Schema(name = "check in time", example = "14:00")
        @ValidCheckIn
        String checkIn,

        @Schema(name = "check out time", example = "12:00")
        @ValidCheckOut
        String checkOut
) {
}

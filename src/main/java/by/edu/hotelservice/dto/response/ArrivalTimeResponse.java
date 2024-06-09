package by.edu.hotelservice.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "Arrival time response")
@Builder
public record ArrivalTimeResponse(

        @JsonFormat(pattern = "HH:mm")
        @Schema(name = "check in time", example = "14:00")
        String checkIn,

        @JsonFormat(pattern = "HH:mm")
        @Schema(name = "check out time", example = "12:00")
        String checkOut
) {
}

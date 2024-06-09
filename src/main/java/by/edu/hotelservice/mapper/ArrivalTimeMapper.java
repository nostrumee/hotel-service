package by.edu.hotelservice.mapper;

import by.edu.hotelservice.dto.request.ArrivalTimeRequest;
import by.edu.hotelservice.dto.response.ArrivalTimeResponse;
import by.edu.hotelservice.persistence.embeddable.ArrivalTime;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true)
)
public interface ArrivalTimeMapper {

    ArrivalTimeResponse fromEntityToResponse(ArrivalTime arrivalTime);

    ArrivalTime fromRequestToEntity(ArrivalTimeRequest request);

    default LocalTime fromStringToLocalTime(String time) {
        return time == null
                ? null
                : LocalTime.parse(time);
    }

    default String fromLocalTimeToString(LocalTime time) {
        if (time == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }
}

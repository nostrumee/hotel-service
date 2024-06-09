package by.edu.hotelservice.mapper;

import by.edu.hotelservice.dto.request.HotelCreateRequest;
import by.edu.hotelservice.dto.response.HotelResponse;
import by.edu.hotelservice.dto.response.HotelShortResponse;
import by.edu.hotelservice.persistence.entity.Hotel;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                AmenityMapper.class,
                AddressMapper.class,
                ArrivalTimeMapper.class,
                ContactsMapper.class
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface HotelMapper {

    HotelResponse fromEntityToResponse(Hotel hotel);

    @Mapping(source = "contacts.phone", target = "phone")
    HotelShortResponse fromEntityToShortResponse(Hotel hotel);

    Hotel fromCreateRequestToEntity(HotelCreateRequest createRequest);
}

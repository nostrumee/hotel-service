package by.edu.hotelservice.mapper;

import by.edu.hotelservice.persistence.entity.Amenity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true)
)
public interface AmenityMapper {

    default String fromEntityToString(Amenity amenity) {
        return amenity == null
                ? null
                : amenity.getName();
    }
}

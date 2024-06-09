package by.edu.hotelservice.mapper;

import by.edu.hotelservice.dto.request.AddressRequest;
import by.edu.hotelservice.dto.response.AddressResponse;
import by.edu.hotelservice.persistence.embeddable.Address;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true)
)
public interface AddressMapper {

    AddressResponse fromEntityToResponse(Address address);

    Address fromRequestToEntity(AddressRequest request);

    default String fromEntityToString(Address address) {
        return address == null
                ? null
                : address.toString();
    }
}

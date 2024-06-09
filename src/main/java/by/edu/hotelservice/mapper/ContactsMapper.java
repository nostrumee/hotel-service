package by.edu.hotelservice.mapper;

import by.edu.hotelservice.dto.request.ContactsRequest;
import by.edu.hotelservice.dto.response.ContactsResponse;
import by.edu.hotelservice.persistence.embeddable.Contacts;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true)
)
public interface ContactsMapper {

    ContactsResponse fromEntityToResponse(Contacts contacts);

    Contacts fromRequestToEntity(ContactsRequest request);
}

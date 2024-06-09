package by.edu.hotelservice.persistence.embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static by.edu.hotelservice.util.StringTemplates.SHORT_ADDRESS_TEMPLATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder
public class Address {

    private Integer houseNumber;

    private String street;

    private String city;

    private String country;

    private String postCode;

    @Override
    public String toString() {
        return String.format(
                SHORT_ADDRESS_TEMPLATE,
                houseNumber, street, city, postCode, country
        );
    }
}

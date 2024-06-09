package by.edu.hotelservice.persistence.util;

import by.edu.hotelservice.persistence.embeddable.Address_;
import by.edu.hotelservice.persistence.entity.Amenity;
import by.edu.hotelservice.persistence.entity.Amenity_;
import by.edu.hotelservice.persistence.entity.Hotel;
import by.edu.hotelservice.persistence.entity.Hotel_;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HotelSpecifications {

    public static Specification<Hotel> byBrand(String brand) {
        return brand == null
                ? Specification.where(null)
                : (root, query, builder) ->
                builder.equal(builder.lower(root.get(Hotel_.brand)), brand.toLowerCase());
    }

    public static Specification<Hotel> byCity(String city) {
        return city == null
                ? Specification.where(null)
                : (root, query, builder) ->
                builder.equal(builder.lower(root.get(Hotel_.address).get(Address_.city)), city.toLowerCase());
    }

    public static Specification<Hotel> byCountry(String country) {
        return country == null
                ? Specification.where(null)
                : (root, query, builder) ->
                builder.equal(builder.lower(root.get(Hotel_.address).get(Address_.country)), country.toLowerCase());
    }

    public static Specification<Hotel> byAmenities(List<String> amenities) {
        return amenities == null
                ? Specification.where(null)
                : (root, query, builder) -> amenities.stream()
                .map(amenity -> root.join(Hotel_.amenities).get(Amenity_.name).in(amenity))
                .reduce(builder::and)
                .orElse(null);
    }
}

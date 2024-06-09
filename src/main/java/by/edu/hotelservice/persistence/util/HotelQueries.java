package by.edu.hotelservice.persistence.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HotelQueries {

    public static final String COUNT_GROUP_BY_BRAND_QUERY = """
            select
                h.brand as group, count(h) as count
            from
                Hotel h
            group by
                group
            """;

    public static final String COUNT_GROUP_BY_CITY_QUERY = """
            select
                h.address.city as group, count(h) as count
            from
                Hotel h
            group by
                group
            """;

    public static final String COUNT_GROUP_BY_COUNTRY_QUERY = """
            select
                h.address.country as group, count(h) as count
            from
                Hotel h
            group by
                group
            """;

    public static final String COUNT_GROUP_BY_AMENITIES_QUERY = """
            select
                a.name as group, count(a) as count
            from
                Amenity a
            group by
                group
            """;
}

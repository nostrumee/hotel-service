package by.edu.hotelservice.persistence.repository;

import by.edu.hotelservice.persistence.entity.Hotel;
import by.edu.hotelservice.persistence.projection.HistogramInfo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static by.edu.hotelservice.persistence.util.HotelQueries.*;

@Repository
public interface HotelRepository
        extends JpaRepository<Hotel, Long>,
                JpaSpecificationExecutor<Hotel> {

    @Query(COUNT_GROUP_BY_BRAND_QUERY)
    List<HistogramInfo> countGroupByBrand();

    @Query(COUNT_GROUP_BY_CITY_QUERY)
    List<HistogramInfo> countGroupByCity();

    @Query(COUNT_GROUP_BY_COUNTRY_QUERY)
    List<HistogramInfo> countGroupByCountry();

    @Query(COUNT_GROUP_BY_AMENITIES_QUERY)
    List<HistogramInfo> countGroupByAmenities();
}

package by.edu.hotelservice.strategy.factory;

import by.edu.hotelservice.exception.GroupingParamNotSupportedException;
import by.edu.hotelservice.persistence.repository.HotelRepository;
import by.edu.hotelservice.strategy.CountGroupByStrategy;
import by.edu.hotelservice.strategy.impl.CountGroupByAmenitiesStrategy;
import by.edu.hotelservice.strategy.impl.CountGroupByBrandStrategy;
import by.edu.hotelservice.strategy.impl.CountGroupByCityStrategy;
import by.edu.hotelservice.strategy.impl.CountGroupByCountryStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CountGroupByStrategyFactory {

    private final Map<String, CountGroupByStrategy> strategies;

    public CountGroupByStrategyFactory(HotelRepository hotelRepository) {
        strategies = Map.of(
                "brand", new CountGroupByBrandStrategy(hotelRepository),
                "city", new CountGroupByCityStrategy(hotelRepository),
                "country", new CountGroupByCountryStrategy(hotelRepository),
                "amenities", new CountGroupByAmenitiesStrategy(hotelRepository)
        );
    }

    public CountGroupByStrategy getStrategy(String groupingParam) {
        if (strategies.containsKey(groupingParam)) {
            return strategies.get(groupingParam);
        } else {
            throw new GroupingParamNotSupportedException(groupingParam);
        }
    }
}

package by.edu.hotelservice.strategy.factory;

import by.edu.hotelservice.exception.GroupingParamNotSupportedException;
import by.edu.hotelservice.persistence.repository.HotelRepository;
import by.edu.hotelservice.strategy.CountGroupByStrategy;
import by.edu.hotelservice.strategy.impl.CountGroupByAmenitiesStrategy;
import by.edu.hotelservice.strategy.impl.CountGroupByBrandStrategy;
import by.edu.hotelservice.strategy.impl.CountGroupByCityStrategy;
import by.edu.hotelservice.strategy.impl.CountGroupByCountryStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class CountGroupByStrategyFactory {

    private final Map<String, CountGroupByStrategy> strategies;

    public CountGroupByStrategy getStrategy(String groupingParam) {
        var strategy = strategies.get(groupingParam);

        if (strategy == null) {
            throw new GroupingParamNotSupportedException(groupingParam);
        }

        return strategy;
    }
}

package by.edu.hotelservice.strategy.impl;

import by.edu.hotelservice.persistence.projection.HistogramInfo;
import by.edu.hotelservice.persistence.repository.HotelRepository;
import by.edu.hotelservice.strategy.CountGroupByStrategy;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CountGroupByAmenitiesStrategy implements CountGroupByStrategy {

    private final HotelRepository hotelRepository;

    @Override
    public Map<String, Long> getHistogramInfo() {
        return hotelRepository.countGroupByAmenities().stream()
                .collect(Collectors.toMap(
                        HistogramInfo::getGroup, HistogramInfo::getCount
                ));
    }
}
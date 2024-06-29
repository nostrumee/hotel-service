package by.edu.hotelservice.service.impl;

import by.edu.hotelservice.dto.filter.HotelFilter;
import by.edu.hotelservice.dto.request.HotelCreateRequest;
import by.edu.hotelservice.dto.response.HotelResponse;
import by.edu.hotelservice.dto.response.HotelShortResponse;
import by.edu.hotelservice.exception.HotelNotFoundException;
import by.edu.hotelservice.mapper.HotelMapper;
import by.edu.hotelservice.persistence.entity.Amenity;
import by.edu.hotelservice.persistence.entity.Hotel;
import by.edu.hotelservice.persistence.repository.HotelRepository;
import by.edu.hotelservice.service.HotelService;
import by.edu.hotelservice.strategy.CountGroupByStrategy;
import by.edu.hotelservice.strategy.factory.CountGroupByStrategyFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static by.edu.hotelservice.persistence.util.HotelSpecifications.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;
    private final CountGroupByStrategyFactory strategyFactory;

    @Override
    @Transactional(readOnly = true)
    public HotelResponse getHotelById(long id) {
        Hotel hotel = findById(id);
        return hotelMapper.fromEntityToResponse(hotel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HotelShortResponse> getAllHotels() {
        log.info("Fetching all hotels");

        return hotelRepository.findAll().stream()
                .map(hotelMapper::fromEntityToShortResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public HotelShortResponse createHotel(HotelCreateRequest createRequest) {
        log.info("Creating a hotel from request {}", createRequest);

        Hotel hotelToSave = hotelMapper.fromCreateRequestToEntity(createRequest);
        Hotel savedHotel = hotelRepository.save(hotelToSave);

        return hotelMapper.fromEntityToShortResponse(savedHotel);
    }

    @Override
    @Transactional
    public void addAmenitiesToHotel(long hotelId, List<String> amenities) {
        log.info("Adding the following amenities to the hotel with id {}: {}", hotelId, amenities);

        Hotel hotel = findById(hotelId);

        Set<Amenity> amenitySet = amenities.stream()
                .map(name -> buildAmenity(name, hotel))
                .collect(Collectors.toSet());
        hotel.getAmenities().addAll(amenitySet);

        hotelRepository.save(hotel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HotelShortResponse> searchHotels(HotelFilter filter) {
        log.info("Searching hotels according to the filter: {}", filter);

        Specification<Hotel> spec = byName(filter.name())
                .and(byBrand(filter.brand()))
                .and(byCity(filter.city()))
                .and(byCountry(filter.country()))
                .and(byAmenities(filter.amenities()));

        return hotelRepository.findAll(spec).stream()
                .map(hotelMapper::fromEntityToShortResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Long> getHistogramInfo(String groupingParam) {
        log.info("Fetching histogram info by param: {}", groupingParam);

        var strategy = strategyFactory.getStrategy(groupingParam);

        return strategy.getHistogramInfo();
    }

    private Hotel findById(long id) {
        log.info("Fetching hotel by id {}", id);

        return hotelRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Hotel with id {} was not found", id);
                    return new HotelNotFoundException(id);
                });
    }

    private Amenity buildAmenity(String name, Hotel hotel) {
        return Amenity.builder()
                .name(name)
                .hotel(hotel)
                .build();
    }
}

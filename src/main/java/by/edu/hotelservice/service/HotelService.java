package by.edu.hotelservice.service;

import by.edu.hotelservice.dto.filter.HotelFilter;
import by.edu.hotelservice.dto.request.HotelCreateRequest;
import by.edu.hotelservice.dto.response.HotelResponse;
import by.edu.hotelservice.dto.response.HotelShortResponse;

import java.util.List;
import java.util.Map;

public interface HotelService {

    HotelResponse getHotelById(long id);

    List<HotelShortResponse> getAllHotels();

    HotelResponse createHotel(HotelCreateRequest createRequest);

    void addAmenitiesToHotel(long hotelId, List<String> amenities);

    List<HotelShortResponse> searchHotels(HotelFilter filter);

    Map<String, Long> getHistogramInfo(String groupingParam);
}

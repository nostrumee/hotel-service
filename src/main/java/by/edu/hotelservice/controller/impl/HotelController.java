package by.edu.hotelservice.controller.impl;

import by.edu.hotelservice.controller.DocumentedHotelController;
import by.edu.hotelservice.dto.filter.HotelFilter;
import by.edu.hotelservice.dto.request.HotelCreateRequest;
import by.edu.hotelservice.dto.response.HotelResponse;
import by.edu.hotelservice.dto.response.HotelShortResponse;
import by.edu.hotelservice.service.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/property-view")
@RequiredArgsConstructor
public class HotelController implements DocumentedHotelController {

    private final HotelService hotelService;

    @GetMapping("/hotels/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HotelResponse getHotelById(@PathVariable long id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping("/hotels")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelShortResponse> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping("/hotels")
    public ResponseEntity<HotelShortResponse> createHotel(
            @RequestBody @Valid HotelCreateRequest createRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        HotelShortResponse response = hotelService.createHotel(createRequest);
        long hotelId = response.id();

        URI location = uriComponentsBuilder
                .path("/property-view/hotels/{id}")
                .build(Map.of("id", hotelId));

        return ResponseEntity
                .created(location)
                .body(response);
    }

    @PostMapping("/hotels/{id}/amenities")
    @ResponseStatus(HttpStatus.OK)
    public void addAmenitiesToHotel(
            @PathVariable long id,
            @RequestBody List<String> amenities
    ) {
        hotelService.addAmenitiesToHotel(id, amenities);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelShortResponse> searchHotels(HotelFilter filter) {
        return hotelService.searchHotels(filter);
    }

    @GetMapping("/histogram/{param}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> getHistogram(@PathVariable String param) {
        return hotelService.getHistogramInfo(param);
    }
}

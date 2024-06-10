package by.edu.hotelservice.service.impl;

import by.edu.hotelservice.exception.HotelNotFoundException;
import by.edu.hotelservice.mapper.HotelMapper;
import by.edu.hotelservice.persistence.repository.HotelRepository;
import by.edu.hotelservice.strategy.factory.CountGroupByStrategyFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static by.edu.hotelservice.util.HotelTestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HotelServiceImplTest {

    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private HotelMapper hotelMapper;

    @Mock
    private CountGroupByStrategyFactory strategyFactory;

    @InjectMocks
    private HotelServiceImpl hotelService;

    @Test
    void getHotelById_shouldReturnHotelResponse_whenHotelExists() {
        // arrange
        var expected = getDefaultHotelResponse();
        var retrievedHotel = getHotel(DEFAULT_ID, DEFAULT_BRAND);
        addAmenities(retrievedHotel);

        doReturn(Optional.of(retrievedHotel))
                .when(hotelRepository)
                .findById(DEFAULT_ID);
        doReturn(expected)
                .when(hotelMapper)
                .fromEntityToResponse(retrievedHotel);

        // act
        var actual = hotelService.getHotelById(DEFAULT_ID);

        // assert
        assertThat(actual).isEqualTo(expected);
        verify(hotelRepository).findById(DEFAULT_ID);
        verify(hotelMapper).fromEntityToResponse(retrievedHotel);
    }

    @Test
    void getById_shouldThrowHotelNotFoundException_whenHotelNotExist() {
        // arrange
        doReturn(Optional.empty())
                .when(hotelRepository)
                .findById(DEFAULT_ID);

        // act and assert
        assertThrows(
                HotelNotFoundException.class,
                () -> hotelService.getHotelById(DEFAULT_ID)
        );
        verify(hotelRepository).findById(DEFAULT_ID);
    }

    @Test
    void getAllHotels_shouldReturnListOfHotelShortResponses() {
        // arrange
        var retrievedHotels = List.of(getHotel(DEFAULT_ID, DEFAULT_BRAND));

        doReturn(retrievedHotels)
                .when(hotelRepository)
                .findAll();
        doReturn(getHotelShortResponse(DEFAULT_ID))
                .when(hotelMapper)
                .fromEntityToShortResponse(getHotel(DEFAULT_ID, DEFAULT_BRAND));

        // act
        var actual = hotelService.getAllHotels();

        // assert
        assertThat(actual).isNotEmpty();
        verify(hotelRepository).findAll();
    }

    @Test
    void createHotel_shouldReturnHotelShortResponse() {
        // arrange
        var expected = getHotelShortResponse(DEFAULT_ID);
        var hotel = getHotel(DEFAULT_ID, DEFAULT_BRAND);
        var createRequest = getHotelCreateRequest();

        doReturn(hotel)
                .when(hotelMapper)
                .fromCreateRequestToEntity(createRequest);
        doReturn(hotel)
                .when(hotelRepository)
                .save(hotel);
        doReturn(expected)
                .when(hotelMapper)
                .fromEntityToShortResponse(hotel);

        // act
        var actual = hotelService.createHotel(createRequest);

        // assert
        assertThat(actual).isEqualTo(expected);

        verify(hotelRepository).save(hotel);

        verify(hotelMapper).fromCreateRequestToEntity(createRequest);
        verify(hotelMapper).fromEntityToShortResponse(hotel);
    }

    @Test
    void addAmenitiesToHotel_shouldAddAmenitiesToHotel_whenHotelExists() {
        //arrange
        var hotel = getHotel(DEFAULT_ID, DEFAULT_BRAND);
        doReturn(Optional.of(hotel))
                .when(hotelRepository)
                .findById(DEFAULT_ID);

        // act
        hotelService.addAmenitiesToHotel(DEFAULT_ID, getDefaultAmenitiesStringList());

        // assert
        assertThat(hotel.getAmenities()).isNotEmpty();
        verify(hotelRepository).findById(DEFAULT_ID);
        verify(hotelRepository).save(hotel);
    }

    @Test
    void addAmenitiesToHotel_shouldThrowHotelNotFoundException_whenHotelNotExist() {
        // arrange
        doReturn(Optional.empty())
                .when(hotelRepository)
                .findById(DEFAULT_ID);

        // act and assert
        assertThrows(
                HotelNotFoundException.class,
                () -> hotelService.addAmenitiesToHotel(DEFAULT_ID, getDefaultAmenitiesStringList())
        );
        verify(hotelRepository).findById(DEFAULT_ID);
    }
}

package by.edu.hotelservice.util;

import by.edu.hotelservice.dto.request.AddressRequest;
import by.edu.hotelservice.dto.request.ArrivalTimeRequest;
import by.edu.hotelservice.dto.request.ContactsRequest;
import by.edu.hotelservice.dto.request.HotelCreateRequest;
import by.edu.hotelservice.dto.response.*;
import by.edu.hotelservice.persistence.embeddable.Address;
import by.edu.hotelservice.persistence.embeddable.ArrivalTime;
import by.edu.hotelservice.persistence.embeddable.Contacts;
import by.edu.hotelservice.persistence.entity.Amenity;
import by.edu.hotelservice.persistence.entity.Hotel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HotelTestData {

    public static final long DEFAULT_ID = 1L;
    public static final String DEFAULT_NAME = "DoubleTree by Hilton Minsk";
    public static final String DEFAULT_DESCRIPTION = "DoubleTree by Hilton Minsk";
    public static final String DEFAULT_BRAND = "Hilton";
    public static final String DEFAULT_ADDRESS_STRING = "9 Pobediteley Avenue, Minsk, 220004, Belarus";
    public static final int DEFAULT_HOUSE_NUMBER = 9;
    public static final String DEFAULT_STREET = "Pobediteley Avenue";
    public static final String DEFAULT_CITY = "Minsk";
    public static final String DEFAULT_COUNTRY = "Belarus";
    public static final String DEFAULT_POSTCODE = "220004";
    public static final String DEFAULT_CHECKIN = "14:00";
    public static final String DEFAULT_CHECKOUT = "12:00";
    public static final String DEFAULT_PHONE = "+375 17 309-80-00";
    public static final String DEFAULT_EMAIL = "doubletreeminsk.info@hilton.com";
    public static final LocalTime DEFAULT_CHECKIN_TIME = LocalTime.of(14, 0);
    public static final LocalTime DEFAULT_CHECKOUT_TIME = LocalTime.of(12, 0);

    public static HotelResponse getDefaultHotelResponse() {
        return HotelResponse.builder()
                .id(DEFAULT_ID)
                .name(DEFAULT_NAME)
                .brand(DEFAULT_BRAND)
                .address(getDefaultAddressResponse())
                .arrivalTime(getDefaultArrivalTimeResponse())
                .contacts(getDefaultContactsResponse())
                .amenities(getDefaultAmenitiesStringList())
                .build();
    }

    public static AddressResponse getDefaultAddressResponse() {
        return AddressResponse.builder()
                .houseNumber(DEFAULT_HOUSE_NUMBER)
                .street(DEFAULT_STREET)
                .city(DEFAULT_CITY)
                .country(DEFAULT_COUNTRY)
                .postCode(DEFAULT_POSTCODE)
                .build();
    }

    public static ArrivalTimeResponse getDefaultArrivalTimeResponse() {
        return ArrivalTimeResponse.builder()
                .checkIn(DEFAULT_CHECKIN)
                .checkOut(DEFAULT_CHECKOUT)
                .build();
    }

    public static ContactsResponse getDefaultContactsResponse() {
        return ContactsResponse.builder()
                .phone(DEFAULT_PHONE)
                .email(DEFAULT_EMAIL)
                .build();
    }

    public static List<String> getDefaultAmenitiesStringList() {
        return List.of(
                "Free parking",
                "Free WiFi",
                "Non-smoking rooms",
                "Concierge",
                "On-site restaurant"
        );
    }

    public static Hotel getHotel(long id, String brand) {
        return Hotel.builder()
                .id(id)
                .brand(brand)
                .name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION)
                .address(getDefaultAddress())
                .contacts(getDefaultContacts())
                .arrivalTime(getDefaultArrivalTime())
                .build();
    }

    public static void addAmenities(Hotel hotel) {
        var amenitySet = getDefaultAmenitiesStringList().stream()
                .map(name -> buildAmenity(name, hotel))
                .collect(Collectors.toSet());
        hotel.getAmenities().addAll(amenitySet);
    }

    public static Address getDefaultAddress() {
        return Address.builder()
                .houseNumber(DEFAULT_HOUSE_NUMBER)
                .street(DEFAULT_STREET)
                .city(DEFAULT_CITY)
                .country(DEFAULT_COUNTRY)
                .postCode(DEFAULT_POSTCODE)
                .build();
    }

    public static ArrivalTime getDefaultArrivalTime() {
        return ArrivalTime.builder()
                .checkIn(DEFAULT_CHECKIN_TIME)
                .checkOut(DEFAULT_CHECKOUT_TIME)
                .build();
    }

    public static HotelShortResponse getHotelShortResponse(long id) {
        return HotelShortResponse.builder()
                .id(id)
                .name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION)
                .address(DEFAULT_ADDRESS_STRING)
                .phone(DEFAULT_PHONE)
                .build();
    }

    public static HotelCreateRequest getHotelCreateRequest() {
        return HotelCreateRequest.builder()
                .name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION)
                .brand(DEFAULT_BRAND)
                .address(getAddressRequest())
                .contacts(getContactsRequest())
                .arrivalTime(getArrivalTimeRequest())
                .build();
    }

    public static AddressRequest getAddressRequest() {
        return AddressRequest.builder()
                .houseNumber(DEFAULT_HOUSE_NUMBER)
                .street(DEFAULT_STREET)
                .city(DEFAULT_CITY)
                .country(DEFAULT_COUNTRY)
                .postCode(DEFAULT_POSTCODE)
                .build();
    }

    public static ContactsRequest getContactsRequest() {
        return ContactsRequest.builder()
                .phone(DEFAULT_PHONE)
                .email(DEFAULT_EMAIL)
                .build();
    }

    public static ArrivalTimeRequest getArrivalTimeRequest() {
        return ArrivalTimeRequest.builder()
                .checkIn(DEFAULT_CHECKIN)
                .checkOut(DEFAULT_CHECKOUT)
                .build();
    }

    public static Contacts getDefaultContacts() {
        return Contacts.builder()
                .phone(DEFAULT_PHONE)
                .email(DEFAULT_EMAIL)
                .build();
    }

    private static Amenity buildAmenity(String name, Hotel hotel) {
        return Amenity.builder()
                .name(name)
                .hotel(hotel)
                .build();
    }
}

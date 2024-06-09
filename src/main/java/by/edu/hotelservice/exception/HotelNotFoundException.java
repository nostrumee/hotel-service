package by.edu.hotelservice.exception;

import static by.edu.hotelservice.util.ErrorMessages.HOTEL_NOT_FOUND_MESSAGE;

public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException(long id) {
        super(String.format(HOTEL_NOT_FOUND_MESSAGE, id));
    }
}

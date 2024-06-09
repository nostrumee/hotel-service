package by.edu.hotelservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessages {

    public static final String HOTEL_NOT_FOUND_MESSAGE = "Hotel with id %d was not found";

    public static final String GROUPING_PARAMETER_NOT_SUPPORTED_MESSAGE
            = "Parameter %s not supported for grouping by";

    public static final String VALIDATION_FAILED_MESSAGE = "Validation failed";

    public static final String HTTP_MESSAGE_NOT_READABLE_MESSAGE = "Request body is missing or could not be read";
}

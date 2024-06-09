package by.edu.hotelservice.exception;

import static by.edu.hotelservice.util.ErrorMessages.GROUPING_PARAMETER_NOT_SUPPORTED_MESSAGE;

public class GroupingParamNotSupportedException extends RuntimeException {

    public GroupingParamNotSupportedException(String groupingParam) {
        super(
                String.format(GROUPING_PARAMETER_NOT_SUPPORTED_MESSAGE, groupingParam)
        );
    }
}

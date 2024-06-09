package by.edu.hotelservice.validation.validator;

import by.edu.hotelservice.validation.annotation.ValidCheckIn;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.DateTimeException;
import java.time.LocalTime;

public class CheckInValidator implements ConstraintValidator<ValidCheckIn, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().length() == 0) {
            return false;
        }

        try {
            LocalTime.parse(value);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
}

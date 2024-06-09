package by.edu.hotelservice.validation.validator;

import by.edu.hotelservice.validation.annotation.ValidCheckOut;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.DateTimeException;
import java.time.LocalTime;

public class CheckOutValidator implements ConstraintValidator<ValidCheckOut, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().length() == 0) {
            return true;
        }

        try {
            LocalTime.parse(value);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
}

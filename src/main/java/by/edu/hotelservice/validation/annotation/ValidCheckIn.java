package by.edu.hotelservice.validation.annotation;

import by.edu.hotelservice.validation.validator.CheckInValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CheckInValidator.class)
public @interface ValidCheckIn {

    String message() default "{checkin.valid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

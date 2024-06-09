package by.edu.hotelservice.validation.annotation;

import by.edu.hotelservice.validation.validator.CheckOutValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CheckOutValidator.class)
public @interface ValidCheckOut {

    String message() default "{checkout.valid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

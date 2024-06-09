package by.edu.hotelservice.validation.annotation;

import by.edu.hotelservice.validation.validator.EmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidEmail {

    String message() default "{email.valid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

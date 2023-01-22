package com.example.task.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Constraint(validatedBy = NameValidator.class)
@Target( { FIELD })
@Retention(RUNTIME)
@Documented
public @interface NameConstraint {
    String message() default "{не допустимые символы}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

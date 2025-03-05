package sideproject.coffeechat.global.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StartEndTimeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStartEndTime {

    String message() default "StartTime must be before EndTime";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

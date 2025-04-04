package sideproject.coffeechat.global.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniquePriorityValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePriority {

    String message() default "Priorities must be unique.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

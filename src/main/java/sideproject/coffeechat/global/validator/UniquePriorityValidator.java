package sideproject.coffeechat.global.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;

public class UniquePriorityValidator implements ConstraintValidator<UniquePriority, List<? extends HasPriority>> {

    @Override
    public boolean isValid(List<? extends HasPriority> items, ConstraintValidatorContext context) {
        if (items == null || items.isEmpty()) {
            return true;
        }
        return items.stream()
                .collect(Collectors.groupingBy(HasPriority::getPriority, Collectors.counting()))
                .values()
                .stream()
                .noneMatch(count -> count > 1);
    }
}

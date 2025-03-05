package sideproject.coffeechat.global.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartEndTimeValidator implements ConstraintValidator<ValidStartEndTime, TimeRangeProvider> {

    @Override
    public boolean isValid(TimeRangeProvider timeRange, ConstraintValidatorContext context) {
        if (timeRange == null || timeRange.getStartTime() == null || timeRange.getEndTime() == null) {
            return true;
        }

        return timeRange.getStartTime().isBefore(timeRange.getEndTime());
    }

}

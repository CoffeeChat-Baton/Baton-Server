package sideproject.coffeechat.global.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import sideproject.coffeechat.domain.member.entity.MemberType;

public class WorkerTypeValidator implements ConstraintValidator<WorkerOnly, MemberType> {

    @Override
    public boolean isValid(MemberType memberType, ConstraintValidatorContext context) {
        return memberType == MemberType.WORKER;
    }

}

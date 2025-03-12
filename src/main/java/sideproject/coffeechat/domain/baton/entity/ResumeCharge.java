package sideproject.coffeechat.domain.baton.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResumeCharge {

    BASIC(14900)
    ;

    private final int fee;

}

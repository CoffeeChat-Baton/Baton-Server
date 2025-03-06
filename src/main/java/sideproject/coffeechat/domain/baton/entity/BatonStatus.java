package sideproject.coffeechat.domain.baton.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BatonStatus {

    REQUESTED("requestedCount"),
    ACCEPTED("acceptedCount"),
    REJECTED("rejectedCount"),
    COMPLETED("completedCount"),
    ;

    private final String countKey;

}

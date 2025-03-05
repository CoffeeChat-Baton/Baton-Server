package sideproject.coffeechat.domain.baton.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Charge {

    TWENTY_MINUTES(20, 14900),
    THIRTY_MINUTES(30, 19900),
    FORTY_MINUTES(50, 39900),
    ;

    private final int duration; // 사용 시간 (분)
    private final int fee; // 요금 (원)

}

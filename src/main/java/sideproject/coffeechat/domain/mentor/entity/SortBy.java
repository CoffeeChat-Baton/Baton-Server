package sideproject.coffeechat.domain.mentor.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SortBy {

    // TODO : 후기 많은 순, 추천순 예정
    LATEST("latest"),
    POPULAR("popular"),
    ;

    private final String value;

}

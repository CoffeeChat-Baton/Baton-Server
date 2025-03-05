package sideproject.coffeechat.global.validator;

import java.time.LocalTime;

public interface TimeRangeProvider {

    LocalTime getStartTime();
    LocalTime getEndTime();

}

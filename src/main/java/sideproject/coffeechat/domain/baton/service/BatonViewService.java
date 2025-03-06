package sideproject.coffeechat.domain.baton.service;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.coffeechat.domain.baton.repository.BatonMapper;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BatonViewService {

    private final BatonMapper batonMapper;

    public Map<String, Long> getBatonStatusCounts(Long mentorId) {
        return batonMapper.getBatonStatusCounts(mentorId);
    }

}

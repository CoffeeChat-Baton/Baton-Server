package sideproject.coffeechat.domain.member.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sideproject.coffeechat.domain.member.entity.SocialType;

@Service
public class SocialServiceManager {

    private final Map<SocialType, SocialService> socialServiceMap;

    @Autowired
    public SocialServiceManager(List<SocialService> services) {
        this.socialServiceMap = services.stream()
                .filter(service -> SocialType.fromService(service) != null)
                .collect(Collectors.toMap(
                        SocialType::fromService,
                   service -> service
                ));
    }

    public String login(SocialType socialType, String token) {
        return getService(socialType).login(token);
    }

    private SocialService getService(SocialType socialType) {
        SocialService service = socialServiceMap.get(socialType);
        if (service == null) {
            throw new IllegalArgumentException("Invalid social type: " + socialType);
        }
        return service;
    }

}

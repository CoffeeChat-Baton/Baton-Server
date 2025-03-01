package sideproject.coffeechat.domain.member.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("GENERAL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneralMember extends Member {

    public GeneralMember(SocialType socialType, String username, Set<Role> roles) {
        super(socialType, username, roles);
    }

}

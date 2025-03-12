package sideproject.coffeechat.domain.baton.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@DiscriminatorValue("CHAT")
public class ChatBaton extends Baton {

    @Enumerated(EnumType.STRING)
    private ChatCharge charge;

    @OneToMany(mappedBy = "baton", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<ChatTimeSlot> availableSchedules = new ArrayList<>();

    private String preQuestion;

    public void updateAvailableSchedules(List<ChatTimeSlot> availableSchedules) {
        this.availableSchedules = availableSchedules;
    }

}

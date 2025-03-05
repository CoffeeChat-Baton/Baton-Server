package sideproject.coffeechat.domain.mentor.entity;

import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sideproject.coffeechat.domain.member.entity.Worker;
import sideproject.coffeechat.global.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Builder
public class Mentor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    private String shortDescription;

    private String detailedDescription;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<MentorTimeSlot> availableSchedules = new ArrayList<>();

    public void updateShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void updateDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public void updateAvailableSchedules(List<MentorTimeSlot> availableSchedules) {
        this.availableSchedules.clear();
        this.availableSchedules.addAll(availableSchedules);
    }

}

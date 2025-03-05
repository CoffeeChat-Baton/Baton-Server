package sideproject.coffeechat.domain.mentor.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MentorTimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Mentor mentor;

    @ElementCollection
    @CollectionTable(name = "mentor_time_slot_days", joinColumns = @JoinColumn(name = "mentor_time_slot_id"))
    @Column(name = "day_of_week")
    @Enumerated(EnumType.STRING)
    private List<DayOfWeek> availableDays;

    private LocalTime startTime;

    private LocalTime endTime;

    private int priority;

}

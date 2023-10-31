package com.pedro.demo.domain.schedule;

import com.pedro.demo.domain.medic.Medic;
import com.pedro.demo.domain.patients.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "schedules")
@Entity(name = "Schedule")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medic_id")
    private Medic medic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "cancel_motive")
    @Enumerated(EnumType.STRING)
    private ScheduleCancelMotive cancelMotive;

    private LocalDateTime date;

    public void cancelar(ScheduleCancelMotive cancelMotive){
        this.cancelMotive = cancelMotive;
    }
}

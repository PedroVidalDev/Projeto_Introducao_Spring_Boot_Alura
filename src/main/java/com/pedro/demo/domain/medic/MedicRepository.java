package com.pedro.demo.domain.medic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicRepository extends JpaRepository<Medic, Long> {
    Page<Medic> findAllByLativoTrue(Pageable paginacao);

    @Query("""
            select m from Medic m
            where m.lativo = true
            and m.especialidade = :especialidade
            and m.id not in(
                select s.medic.id from Schedule s
                where
                s.date = :date
            )
            order by rand()
            limit 1
            """)
    Medic choiceRandomMedic(Especialidade especialidade, LocalDateTime date);
}

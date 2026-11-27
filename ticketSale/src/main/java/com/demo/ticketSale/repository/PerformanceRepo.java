package com.demo.ticketSale.repository;

import com.demo.ticketSale.entity.Performance;
import com.demo.ticketSale.entity.enums.PerformanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PerformanceRepo extends JpaRepository<Performance, Long> {

    Optional<Performance> findByIdAndShowTheatreId(Long id, Long theatreId);

    boolean existsByHallId(Long hallId);

// per area admin, performacne per teatro ordinate per data decr
    @Query("""
            select p from Performance p
              join fetch p.show s
              join fetch p.hall
            where s.theatre.id = :theatreId
            order by p.startsAt desc
            """)
    List<Performance> findByTheatreId(Long theatreId);
// performance per certo show, dato perimetro temporale (from, to), prima il piu' recente,
    @Query("""
            select p from Performance p
              join fetch p.hall
            where p.show.id in :showIds
              and p.status = :status
              and p.startsAt between :from and :to
            order by p.startsAt
            """)
    List<Performance> findByShowIds(Collection<Long> showIds, PerformanceStatus status,
                                    Instant from, Instant to);
}

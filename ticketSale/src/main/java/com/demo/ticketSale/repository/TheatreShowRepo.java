package com.demo.ticketSale.repository;

import com.demo.ticketSale.entity.TheatreShow;
import com.demo.ticketSale.entity.enums.PerformanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface TheatreShowRepo extends JpaRepository<TheatreShow, Long> {
    List<TheatreShow> findByTheatreIdOrderByTitle(Long theatreId);

    Optional<TheatreShow> findByIdAndTheatreId(Long id, Long theatreId);

    Optional<TheatreShow> findByIdAndActiveTrue(Long id);

    // catalogo 'pubblico' di un teatro: show attivi con almeno una performance
    // con filtro temporale da (from) a (to)
    @Query("""
            select s from TheatreShow s
            where s.theatre.id = :theatreId
              and s.active = true
              and (:genre is null or s.genre = :genre)
              and exists (select 1 from Performance p
                          where p.show = s
                            and p.status = :status
                            and p.startsAt between :from and :to)
            order by s.title
            """)
    List<TheatreShow> findCatalogue(Long theatreId, String genre,
                                    PerformanceStatus status, Instant from, Instant to);
}

package com.demo.ticketSale.repository;

import com.demo.ticketSale.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HallRepo extends JpaRepository<Hall, Long> {
    List<Hall> findByTheatreIdOrderByName(Long theatreId);

    Optional<Hall> findByIdAndTheatreId(Long id, Long theatreId);

    boolean existsByTheatreIdAndName(Long theatreId, String name);
}

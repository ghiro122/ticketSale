package com.demo.ticketSale.repository;

import com.demo.ticketSale.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface SeatRepo extends JpaRepository<Seat, Long> {

    List<Seat> findByHallIdOrderByRowLabelAscSeatNumberAsc(Long hallId);

    List<Seat> findByIdInAndHallId(Collection<Long> ids, Long hallId);

    boolean existsByHallId(Long hallId);
}

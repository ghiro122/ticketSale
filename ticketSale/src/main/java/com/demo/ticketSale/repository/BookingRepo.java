package com.demo.ticketSale.repository;

import com.demo.ticketSale.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking, Long> {

    Optional<Booking> findByUserIdAndIdempotencyKey(Long userId, String idempotencyKey);

    List<Booking> findByUserIdOrderByCreatedAtDesc(Long userId);
}

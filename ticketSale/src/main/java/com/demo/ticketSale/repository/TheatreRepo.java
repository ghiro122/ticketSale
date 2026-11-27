package com.demo.ticketSale.repository;

import com.demo.ticketSale.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TheatreRepo extends JpaRepository<Theatre, Long> {
    List<Theatre> findByActiveTrueOrderByName();

    Optional<Theatre> findBySlugAndActiveTrue(String slug);

    boolean existsBySlug(String slug);

    boolean existsBySlugAndIdNot(String slug, Long id);
}

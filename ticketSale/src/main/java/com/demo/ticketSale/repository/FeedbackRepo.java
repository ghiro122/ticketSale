package com.demo.ticketSale.repository;

import com.demo.ticketSale.dto.ShowRatingDTO;
import com.demo.ticketSale.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {

    boolean existsByUserIdAndShowId(Long userId, Long showId);

    @Query("""
            select f from Feedback f
              join fetch f.user
            where f.show.id = :showId
            order by f.createdAt desc
            """)
    List<Feedback> findByShowIdWithUser(Long showId);

    // rating per showId
    @Query("select avg(f.rating) from Feedback f where f.show.id = :showId")
    Optional<Double> findAverageRatingByShowId(Long showId);

    // DTO per la dashboard
    @Query("""
            select new it.stagepass.ticketing.dto.ShowRatingDto(
                       s.id, s.title, avg(f.rating), count(f.id))
            from TheatreShow s
              left join Feedback f on f.show = s
            where s.theatre.id = :theatreId
            group by s.id, s.title
            order by s.title
            """)
    List<ShowRatingDTO> findRatingsByTheatre(Long theatreId);
}

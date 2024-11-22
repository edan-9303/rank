package com.example.airlinerating.repository;

import com.example.airlinerating.Entity.Game;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Game g SET g.lostRating = :lostRating WHERE g.entryId = :entryId")
    void updateLostRatingByEntryId(@Param("lostRating") double lostRating, @Param("entryId") long entryId);

    @Modifying
    @Transactional
    @Query("UPDATE Game g SET g.earnedRating = :earnedRating WHERE g.entryId = :entryId")
    void updateEarnedRatingByEntryId(@Param("earnedRating") double earnedRating, @Param("entryId") long entryId);

}

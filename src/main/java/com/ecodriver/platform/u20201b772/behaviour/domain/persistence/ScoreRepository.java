package com.ecodriver.platform.u20201b772.behaviour.domain.persistence;

import com.ecodriver.platform.u20201b772.behaviour.domain.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Long> {

    Score findFirstByDriverIdOrderByValueDesc(Long driverId);

    @Query("SELECT AVG(s.value) FROM Score s WHERE s.driverId=:driverId")
    Float findAverage(Long driverId);

    List<Score> findByDriverId(Long driverId);
}
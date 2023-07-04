package com.ecodriver.platform.u20201b772.behaviour.service;

import com.ecodriver.platform.u20201b772.behaviour.domain.model.Score;
import com.ecodriver.platform.u20201b772.behaviour.domain.persistence.ScoreRepository;
import com.ecodriver.platform.u20201b772.behaviour.domain.service.ScoreService;
import com.ecodriver.platform.u20201b772.shared.exception.ResourceNotFoundException;
import com.ecodriver.platform.u20201b772.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;

@Service
public class ScoreServiceImpl implements ScoreService {

    private static final String ENTITY = "Score";

    private final ScoreRepository scoreRepository;

    private final Validator validator;

    public ScoreServiceImpl(ScoreRepository scoreRepository, Validator validator) {
        this.scoreRepository = scoreRepository;
        this.validator = validator;
    }

    @Override
    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    @Override
    public Page<Score> getAll(Pageable pageable) {
        return scoreRepository.findAll(pageable);
    }

    @Override
    public Score getById(Long scoreId) {
        return scoreRepository.findById(scoreId).
                orElseThrow(() -> new ResourceNotFoundException(ENTITY,scoreId));
    }

    @Override
    public List<Score> getByDriverId(Long driverId) {
        return scoreRepository.findByDriverId(driverId);
    }

    @Override
    public Score create(Score score) {
        Set<ConstraintViolation<Score>> violations = validator.validate(score);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return scoreRepository.save(score);
    }

    @Override
    public Score create(Score score, Long driverId) {
        score.setDriverId(driverId);
        Set<ConstraintViolation<Score>> violations = validator.validate(score);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return scoreRepository.save(score);
    }

    @Override
    public Score getAverage(Long driverId) {
        Score newScore = new Score();
        newScore.setValue(scoreRepository.findAverage(driverId));
        return newScore;
    }

    @Override
    public Score getMax(Long driverId) {
        return scoreRepository.findFirstByDriverIdOrderByValueDesc(driverId);
    }
}
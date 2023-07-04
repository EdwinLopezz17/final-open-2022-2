package com.ecodriver.platform.u20201b772.behaviour.api.rest;

import com.ecodriver.platform.u20201b772.behaviour.domain.service.ScoreService;
import com.ecodriver.platform.u20201b772.behaviour.mapping.ScoreMapper;
import com.ecodriver.platform.u20201b772.behaviour.resource.CreateScoreResource;
import com.ecodriver.platform.u20201b772.behaviour.resource.ScoreResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/drivers/{driverId}/scores", produces = "application/json")
public class ScoreController {

    private final ScoreService scoreService;

    private final ScoreMapper mapper;

    public ScoreController(ScoreService scoreService, ScoreMapper mapper) {
        this.scoreService = scoreService;
        this.mapper = mapper;
    }

    @GetMapping
    public ScoreResource OperationScope(@PathVariable Long driverId, @RequestParam Long scope, Pageable pageable){
        if(scope == 1) {
            return mapper.toResource(scoreService.getMax(driverId));
        } else {
            if(scope == 0){
                return mapper.toResource(scoreService.getAverage(driverId));
            } else {
                return null;
            }
        }

    }

    @PostMapping
    public ScoreResource addScore(@PathVariable Long driverId,
                                  @RequestBody CreateScoreResource resource) {

        return mapper.toResource(scoreService.create(mapper.toModel(resource), driverId));
    }

}
package com.ecodriver.platform.u20201b772.behaviour.mapping;

import com.ecodriver.platform.u20201b772.behaviour.domain.model.Score;
import com.ecodriver.platform.u20201b772.behaviour.resource.CreateScoreResource;
import com.ecodriver.platform.u20201b772.behaviour.resource.ScoreResource;
import com.ecodriver.platform.u20201b772.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ScoreMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ScoreResource toResource(Score model) {
        return mapper.map(model, ScoreResource.class);
    }

    public Page<ScoreResource> modelListPage(List<Score> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ScoreResource.class), pageable, modelList.size());
    }

    public Score toModel(CreateScoreResource resource) {
        return mapper.map(resource, Score.class);
    }
}
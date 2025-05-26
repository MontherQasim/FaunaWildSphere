package dev.springhandson.faunawildsphere.service.entityProjection;

import dev.springhandson.faunawildsphere.projection.entityProjection.LionDto;

import java.util.List;

public interface LionService {
    List<LionDto> getAllLions();
    LionDto getLionById(Long id);
    LionDto createLion(LionDto lionDto);
    LionDto updateLion(Long id, LionDto lionDto);
    void deleteLion(Long id);
}

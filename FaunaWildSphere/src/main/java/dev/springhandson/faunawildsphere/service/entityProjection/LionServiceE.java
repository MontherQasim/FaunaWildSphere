package dev.springhandson.faunawildsphere.service.entityProjection;

import dev.springhandson.faunawildsphere.projection.entityProjection.LionDto;
import dev.springhandson.faunawildsphere.projection.entityProjection.LionMapper;
import dev.springhandson.faunawildsphere.repository.entityProjection.LionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LionServiceE implements LionService {

    private final LionRepository lionRepository;

    @Override
    public List<LionDto> getAllLions() {
        return lionRepository.findAll().stream()
                .map(LionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LionDto getLionById(Long id) {
        dev.springhandson.faunawildsphere.entity.database.Lion lion = lionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lion not found with id: " + id));
        return LionMapper.toDTO(lion);
    }

    @Override
    public LionDto createLion(LionDto lionDTO) {
        dev.springhandson.faunawildsphere.entity.database.Lion lion = LionMapper.toEntity(lionDTO);
        return LionMapper.toDTO(lionRepository.save(lion));
    }

    @Override
    public LionDto updateLion(Long id, LionDto lionDto) {
        if (!lionRepository.existsById(id)) {
            throw new EntityNotFoundException("Lion not found with id: " + id);
        }
        dev.springhandson.faunawildsphere.entity.database.Lion updated = LionMapper.toEntity(lionDto);
        updated.setId(id);
        return LionMapper.toDTO(lionRepository.save(updated));
    }

    @Override
    public void deleteLion(Long id) {
        dev.springhandson.faunawildsphere.entity.database.Lion lion = lionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lion not found with id: " + id));
        lionRepository.delete(lion);
    }
}

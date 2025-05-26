package dev.springhandson.faunawildsphere.service.InterfaceProjection;

import dev.springhandson.faunawildsphere.projection.interfaceProjection.LionView;
import dev.springhandson.faunawildsphere.repository.interfaceProjection.LionRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LionServiceEI implements LionServiceE {
    private final LionRepository2 lionRepository;

    @Override
    public Page<LionView> getLionByName(String name, Pageable pageable) {
        return lionRepository.findByName(name, pageable, LionView.class);
    }

}
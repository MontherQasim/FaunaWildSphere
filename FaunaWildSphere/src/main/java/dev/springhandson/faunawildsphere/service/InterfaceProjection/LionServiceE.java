package dev.springhandson.faunawildsphere.service.InterfaceProjection;

import dev.springhandson.faunawildsphere.projection.interfaceProjection.LionView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LionServiceE {

    Page<LionView> getLionByName(String name, Pageable pageable);
}
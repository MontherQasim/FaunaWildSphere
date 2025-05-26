package dev.springhandson.faunawildsphere.projection.entityProjection;

public class LionMapper {

    public static LionDto toDTO(dev.springhandson.faunawildsphere.entity.database.Lion lion) {
        return LionDto.builder()
                .id(lion.getId())
                .name(lion.getName())
                .species(lion.getSpecies())
                .bod(lion.getBod())
                .status(lion.getStatus())
                .healthStatus(lion.getHealthStatus())
                .biography(lion.getBiography())
                .numberOfCubs(lion.getNumberOfCubs())
                .alpha(lion.isAlpha())
                .build();
    }

    public static dev.springhandson.faunawildsphere.entity.database.Lion toEntity(LionDto dto) {
        return dev.springhandson.faunawildsphere.entity.database.Lion.builder()
                .id(dto.getId())
                .name(dto.getName())
                .species(dto.getSpecies())
                .bod(dto.getBod())
                .status(dto.getStatus())
                .healthStatus(dto.getHealthStatus())
                .biography(dto.getBiography())
                .numberOfCubs(dto.getNumberOfCubs())
                .alpha(dto.isAlpha())
                .build();
    }
}

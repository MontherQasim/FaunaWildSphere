package dev.springhandson.faunawildsphere.controller;

import dev.springhandson.faunawildsphere.projection.entityProjection.LionDto;
import dev.springhandson.faunawildsphere.projection.interfaceProjection.LionView;
import dev.springhandson.faunawildsphere.service.InterfaceProjection.LionServiceEI;
import dev.springhandson.faunawildsphere.service.entityProjection.LionServiceE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/lions")
public class LionController {

    private final LionServiceE lionServiceE;
    private final LionServiceEI lionServiceI;

    @GetMapping
    public List<LionDto> getAllLions() {
        return lionServiceE.getAllLions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LionDto> getLionById(@PathVariable Long id) {
        return ResponseEntity.ok(lionServiceE.getLionById(id));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Page<LionView>> getLionByName(
            @PathVariable String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<LionView> result = lionServiceI.getLionByName(name, pageable);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<LionDto> createLion(@RequestBody LionDto lionDto) {
        return ResponseEntity.ok(lionServiceE.createLion(lionDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LionDto> updateLion(@PathVariable Long id, @RequestBody LionDto lionDto) {
        return ResponseEntity.ok(lionServiceE.updateLion(id, lionDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLion(@PathVariable Long id) {
        lionServiceE.deleteLion(id);
        return ResponseEntity.noContent().build();
    }
}
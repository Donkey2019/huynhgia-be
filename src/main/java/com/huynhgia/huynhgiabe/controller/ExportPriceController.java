package com.huynhgia.huynhgiabe.controller;

import com.huynhgia.huynhgiabe.model.ExportPrice;
import com.huynhgia.huynhgiabe.repository.ExportPriceRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/export-prices")
public class ExportPriceController {
    private final ExportPriceRepository exportPriceRepository;

    public ExportPriceController(ExportPriceRepository exportPriceRepository) {
        this.exportPriceRepository = exportPriceRepository;
    }

    @GetMapping
    public List<ExportPrice> getAll() {
        return exportPriceRepository.findAll();
    }

    @PostMapping
    public ExportPrice create(@RequestBody ExportPrice exportPrice) {
        return exportPriceRepository.save(exportPrice);
    }

    @GetMapping("/{id}")
    public ExportPrice getById(@PathVariable Integer id) {
        return exportPriceRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ExportPrice update(@PathVariable Integer id, @RequestBody ExportPrice exportPrice) {
        ExportPrice existingExportPrice = exportPriceRepository.findById(id).orElse(null);
        if (existingExportPrice != null) {
            existingExportPrice.setType(exportPrice.getType());
            existingExportPrice.setName(exportPrice.getName());
            existingExportPrice.setExportPrice(exportPrice.getExportPrice());
            existingExportPrice.setUnitOfMeasure(exportPrice.getUnitOfMeasure());
            existingExportPrice.setNote(exportPrice.getNote());
            return exportPriceRepository.save(existingExportPrice);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        exportPriceRepository.deleteById(id);
    }

    @GetMapping("/search/type")
    public List<ExportPrice> searchByType(@RequestParam String type) {
        return exportPriceRepository.findByTypeContainingIgnoreCase(type);
    }

    @GetMapping("/search/name")
    public List<ExportPrice> searchByName(@RequestParam String name) {
        return exportPriceRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/types")
    public List<String> getAllTypes() {
        return exportPriceRepository.findDistinctTypes();
    }

    @GetMapping("/names")
    public List<String> getAllNames() {
        return exportPriceRepository.findDistinctNames();
    }

    @GetMapping("/search/multi")
    public List<ExportPrice> multiCriteriaSearch(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String name) {
        
        List<ExportPrice> allExportPrices = exportPriceRepository.findAll();
        
        return allExportPrices.stream()
                .filter(ep -> type == null || ep.getType().toLowerCase().contains(type.toLowerCase()))
                .filter(ep -> name == null || ep.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
} 
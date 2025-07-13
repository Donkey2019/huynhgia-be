package com.huynhgia.huynhgiabe.controller;

import com.huynhgia.huynhgiabe.model.Export;
import com.huynhgia.huynhgiabe.repository.ExportRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exports")
public class ExportController {
    private final ExportRepository exportRepository;

    public ExportController(ExportRepository exportRepository) {
        this.exportRepository = exportRepository;
    }

    @GetMapping
    public List<Export> getAll() {
        return exportRepository.findAll();
    }

    @PostMapping
    public Export create(@RequestBody Export exp) {
        return exportRepository.save(exp);
    }

    @GetMapping("/{id}")
    public Export getById(@PathVariable Integer id) {
        return exportRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Export update(@PathVariable Integer id, @RequestBody Export exp) {
        Export existingExport = exportRepository.findById(id).orElse(null);
        if (existingExport != null) {
            existingExport.setType(exp.getType());
            existingExport.setSubtype(exp.getSubtype());
            existingExport.setName(exp.getName());
            existingExport.setExportPrice(exp.getExportPrice());
            existingExport.setQuantity(exp.getQuantity());
            existingExport.setDate(exp.getDate());
            existingExport.setShopper(exp.getShopper());
            existingExport.setInOrder(exp.getInOrder());
            existingExport.setTotal(exp.getTotal());
            existingExport.setNote(exp.getNote());
            existingExport.setExporter(exp.getExporter());
            return exportRepository.save(existingExport);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        exportRepository.deleteById(id);
    }

    @GetMapping("/search/exporter")
    public List<Export> searchByExporter(@RequestParam String exporter) {
        return exportRepository.findByExporterContainingIgnoreCase(exporter);
    }

    @GetMapping("/exporters")
    public List<String> getAllExporters() {
        return exportRepository.findDistinctExporters();
    }

    @GetMapping("/search/multi")
    public List<Export> multiCriteriaSearch(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String exporter,
            @RequestParam(required = false) Integer shopper) {
        
        List<Export> allExports = exportRepository.findAll();
        
        return allExports.stream()
                .filter(exp -> type == null || exp.getType().toLowerCase().contains(type.toLowerCase()))
                .filter(exp -> name == null || exp.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(exp -> exporter == null || (exp.getExporter() != null && exp.getExporter().toLowerCase().contains(exporter.toLowerCase())))
                .filter(exp -> shopper == null || exp.getShopper().equals(shopper))
                .toList();
    }
} 
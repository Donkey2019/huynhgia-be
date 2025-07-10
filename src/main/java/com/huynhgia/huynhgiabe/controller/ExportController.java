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
        exp.setId(id);
        return exportRepository.save(exp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        exportRepository.deleteById(id);
    }
} 
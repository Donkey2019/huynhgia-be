package com.huynhgia.huynhgiabe.controller;

import com.huynhgia.huynhgiabe.model.ImportPrice;
import com.huynhgia.huynhgiabe.repository.ImportPriceRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/import-prices")
public class ImportPriceController {
    private final ImportPriceRepository importPriceRepository;

    public ImportPriceController(ImportPriceRepository importPriceRepository) {
        this.importPriceRepository = importPriceRepository;
    }

    @GetMapping
    public List<ImportPrice> getAll() {
        return importPriceRepository.findAll();
    }

    @PostMapping
    public ImportPrice create(@RequestBody ImportPrice importPrice) {
        return importPriceRepository.save(importPrice);
    }

    @GetMapping("/{id}")
    public ImportPrice getById(@PathVariable Integer id) {
        return importPriceRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ImportPrice update(@PathVariable Integer id, @RequestBody ImportPrice importPrice) {
        importPrice.setId(id);
        return importPriceRepository.save(importPrice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        importPriceRepository.deleteById(id);
    }
} 
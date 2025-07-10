package com.huynhgia.huynhgiabe.controller;

import com.huynhgia.huynhgiabe.model.Import;
import com.huynhgia.huynhgiabe.repository.ImportRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/imports")
public class ImportController {
    private final ImportRepository importRepository;

    public ImportController(ImportRepository importRepository) {
        this.importRepository = importRepository;
    }

    @GetMapping
    public List<Import> getAll() {
        return importRepository.findAll();
    }

    @PostMapping
    public Import create(@RequestBody Import imp) {
        return importRepository.save(imp);
    }

    @GetMapping("/{id}")
    public Import getById(@PathVariable Integer id) {
        return importRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Import update(@PathVariable Integer id, @RequestBody Import imp) {
        imp.setId(id);
        return importRepository.save(imp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        importRepository.deleteById(id);
    }
} 
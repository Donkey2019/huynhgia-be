package com.huynhgia.huynhgiabe.controller;

import com.huynhgia.huynhgiabe.model.Import;
import com.huynhgia.huynhgiabe.repository.ImportRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/by-importer")
    public List<Import> getByImporter(@RequestParam String importer) {
        return importRepository.findByImporterContainingIgnoreCase(importer);
    }

    @GetMapping("/importers")
    public List<String> getAllImporters() {
        return importRepository.findAll().stream()
                .map(Import::getImporter)
                .filter(importer -> importer != null && !importer.trim().isEmpty())
                .distinct()
                .toList();
    }

    @GetMapping("/search")
    public List<Import> search(@RequestParam(required = false) String type,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String importer) {
        return importRepository.findAll().stream()
                .filter(item -> type == null || item.getType().toLowerCase().contains(type.toLowerCase()))
                .filter(item -> name == null || item.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(item -> importer == null || (item.getImporter() != null && 
                        item.getImporter().toLowerCase().contains(importer.toLowerCase())))
                .toList();
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
        Optional<Import> existing = importRepository.findById(id);
        if (existing.isPresent()) {
            Import existingImport = existing.get();
            existingImport.setType(imp.getType());
            existingImport.setSubtype(imp.getSubtype());
            existingImport.setName(imp.getName());
            existingImport.setImportPrice(imp.getImportPrice());
            existingImport.setQuantity(imp.getQuantity());
            existingImport.setDate(imp.getDate());
            existingImport.setSupplier(imp.getSupplier());
            existingImport.setImporter(imp.getImporter());
            existingImport.setTotal(imp.getTotal());
            existingImport.setNote(imp.getNote());
            return importRepository.save(existingImport);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        importRepository.deleteById(id);
    }
} 
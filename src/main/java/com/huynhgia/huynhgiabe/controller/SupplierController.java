package com.huynhgia.huynhgiabe.controller;

import com.huynhgia.huynhgiabe.model.Supplier;
import com.huynhgia.huynhgiabe.repository.SupplierRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @GetMapping
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable Integer id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Supplier update(@PathVariable Integer id, @RequestBody Supplier supplier) {
        supplier.setId(id);
        return supplierRepository.save(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        supplierRepository.deleteById(id);
    }
} 
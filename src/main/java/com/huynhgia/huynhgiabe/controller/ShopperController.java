package com.huynhgia.huynhgiabe.controller;

import com.huynhgia.huynhgiabe.model.Shopper;
import com.huynhgia.huynhgiabe.repository.ShopperRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shoppers")
public class ShopperController {
    private final ShopperRepository shopperRepository;

    public ShopperController(ShopperRepository shopperRepository) {
        this.shopperRepository = shopperRepository;
    }

    @GetMapping
    public List<Shopper> getAll() {
        return shopperRepository.findAll();
    }

    @PostMapping
    public Shopper create(@RequestBody Shopper shopper) {
        return shopperRepository.save(shopper);
    }

    @GetMapping("/{id}")
    public Shopper getById(@PathVariable Integer id) {
        return shopperRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Shopper update(@PathVariable Integer id, @RequestBody Shopper shopper) {
        shopper.setId(id);
        return shopperRepository.save(shopper);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        shopperRepository.deleteById(id);
    }
} 
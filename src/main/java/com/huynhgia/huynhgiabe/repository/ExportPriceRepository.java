package com.huynhgia.huynhgiabe.repository;

import com.huynhgia.huynhgiabe.model.ExportPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExportPriceRepository extends JpaRepository<ExportPrice, Integer> {
    
    List<ExportPrice> findByTypeContainingIgnoreCase(String type);
    
    List<ExportPrice> findByNameContainingIgnoreCase(String name);
    
    @Query("SELECT DISTINCT ep.type FROM ExportPrice ep WHERE ep.type IS NOT NULL AND ep.type != ''")
    List<String> findDistinctTypes();
    
    @Query("SELECT DISTINCT ep.name FROM ExportPrice ep WHERE ep.name IS NOT NULL AND ep.name != ''")
    List<String> findDistinctNames();
} 
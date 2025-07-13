package com.huynhgia.huynhgiabe.repository;

import com.huynhgia.huynhgiabe.model.Export;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExportRepository extends JpaRepository<Export, Integer> {
    
    List<Export> findByExporterContainingIgnoreCase(String exporter);
    
    @Query("SELECT DISTINCT e.exporter FROM Export e WHERE e.exporter IS NOT NULL AND e.exporter != ''")
    List<String> findDistinctExporters();
} 
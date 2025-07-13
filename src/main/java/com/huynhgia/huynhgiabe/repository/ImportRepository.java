package com.huynhgia.huynhgiabe.repository;

import com.huynhgia.huynhgiabe.model.Import;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ImportRepository extends JpaRepository<Import, Integer> {
    List<Import> findByImporterContainingIgnoreCase(String importer);
} 
package com.huynhgia.huynhgiabe.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Export {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String type;

    @Column(length = 100)
    private String subtype;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal exportPrice;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private LocalDate date;
    
    @Column(nullable = false)
    private Integer shopper;

    @Column(length = 100)
    private String inOrder;

    @Column(precision = 14, scale = 2)
    private BigDecimal total;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column(length = 100)
    private String exporter;
} 
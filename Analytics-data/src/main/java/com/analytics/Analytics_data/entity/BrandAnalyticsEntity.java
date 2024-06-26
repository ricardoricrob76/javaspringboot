package com.analytics.Analytics_data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brand_analytics")
@Data
@NoArgsConstructor
public class BrandAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand; // Tipos de Marcas: 200 Ford, 100 Toyota, 100 Fiat, 100 outras.

    private Long posts; //  500 Posts relacionados a publicações de vendas dos carros..


}

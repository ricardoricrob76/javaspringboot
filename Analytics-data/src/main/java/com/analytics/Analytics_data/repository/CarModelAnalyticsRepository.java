package com.analytics.Analytics_data.repository;

import com.analytics.Analytics_data.entity.BrandAnalyticsEntity;
import com.analytics.Analytics_data.entity.CarModelAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CarModelAnalyticsRepository extends JpaRepository<CarModelAnalyticsEntity, Long> {
    Optional<CarModelAnalyticsEntity> findByModel(String brand);
}
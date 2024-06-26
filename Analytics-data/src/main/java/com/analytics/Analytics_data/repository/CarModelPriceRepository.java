package com.analytics.Analytics_data.repository;


import com.analytics.Analytics_data.entity.CarModelAnalyticsEntity;
import com.analytics.Analytics_data.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelPriceRepository extends JpaRepository<CarModelPriceEntity, Long> {
    Optional<CarModelPriceEntity> findByModel(String brand);
}

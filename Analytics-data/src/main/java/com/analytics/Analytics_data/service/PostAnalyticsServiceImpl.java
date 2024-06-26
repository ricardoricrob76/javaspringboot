package com.analytics.Analytics_data.service;


import com.analytics.Analytics_data.dto.CarPostDTO;
import com.analytics.Analytics_data.entity.BrandAnalyticsEntity;
import com.analytics.Analytics_data.entity.CarModelAnalyticsEntity;
import com.analytics.Analytics_data.entity.CarModelPriceEntity;
import com.analytics.Analytics_data.repository.BrandAnalyticsRepository;
import com.analytics.Analytics_data.repository.CarModelAnalyticsRepository;
import com.analytics.Analytics_data.repository.CarModelPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.font.ShapeGraphicAttribute;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService {

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarModelPriceRepository carModelPriceRepository;



    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO){

        // Implementar o método para gravar os outros métodos para realizar as operações.
        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
        saveCarModelPriceAnalytics(carPostDTO.getModel(), carPostDTO.getPrice());

    }

    private void saveBrandAnalytics(String brand){

        BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();

        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item->{
            item.setPosts(item.getPosts()+1);
            brandAnalyticsRepository.save(item);
        }, ()-> {
            brandAnalyticsEntity.setBrand(brand);
            brandAnalyticsEntity.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalyticsEntity);
        });

    }

    private void saveCarModelAnalytics(String carModel){

        CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();

        carModelAnalyticsRepository.findByModel(carModel).ifPresentOrElse(item->{
            item.setPosts(item.getPosts()+1);
            carModelAnalyticsRepository.save(item);
        }, ()-> {
            carModelAnalyticsEntity.setModel(carModel);
            carModelAnalyticsEntity.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalyticsEntity);
        });



    }

    private void saveCarModelPriceAnalytics(String carModel, Double price){

        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(carModel);
        carModelPriceEntity.setPrice(price);
        carModelPriceRepository.save(carModelPriceEntity);

    }








}

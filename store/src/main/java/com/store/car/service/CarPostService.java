package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import org.apache.commons.digester.annotations.rules.BeanPropertySetter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void newPostDetails(CarPostDTO carPostDTO);

    List<CarPostDTO> getCarSales();

    void changeCarSale(CarPostDTO carPostDTO, Long postId);

    void removeCarSale(Long postId);


}

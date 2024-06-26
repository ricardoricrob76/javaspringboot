package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService {

    // Criando a injeção de dependência..
    @Autowired
    private CarPostRepository carPostRepository;  // SELECT * FROM CAR_STORE

    @Autowired
    private OwnerPostRepository ownerPostRepository;
    // Finalizando a injeção de dependência..

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {

        // Depois de criado as classes de Message do Kafka vamos implementar a sua inclusão aqui..
        CarPostEntity carPostEntity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
        // Fim da operação..

    }

    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item -> {
            listCarsSales.add(mapCarEntityToDTO(item));
        });
        return listCarsSales;
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long postID) {

        carPostRepository.findById(postID).ifPresentOrElse(item -> {
            item.setDescription(carPostDTO.getDescription());
            item.setContact(carPostDTO.getContact());
            item.setPrice(carPostDTO.getPrice());
            item.setBrand(carPostDTO.getBrand());
            item.setEngineVersion(carPostDTO.getEngineVersion());
            item.setModel(carPostDTO.getModel());

            carPostRepository.save(item);

        }, () -> {
            throw new NoSuchElementException();

        });

    }

    @Override
    public void removeCarSale(Long postId) {

        carPostRepository.deleteById(postId);

    }
// Criar segundo método de Mapeamento..

    private CarPostEntity mapCarDtoToEntity(CarPostDTO carPostDTO) {

        CarPostEntity carPostEntity = new CarPostEntity();

        ownerPostRepository.findById(carPostDTO.getOwnerID()).ifPresentOrElse(item -> {
                    carPostEntity.setOwnerPost(item);
                    carPostEntity.setContact(item.getContactNumber());

                }, ()-> {
                    throw new RuntimeException();

          //  return carPostEntity;
        });

        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setCity(carPostEntity.getCity());
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));

        return carPostEntity;

    }

// Método de Mapeamento..

    private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity){

        return CarPostDTO.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createdDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerPost().getName())
                .price(carPostEntity.getPrice()).build();
    }
}

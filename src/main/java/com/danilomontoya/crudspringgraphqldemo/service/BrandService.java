package com.danilomontoya.crudspringgraphqldemo.service;

import com.danilomontoya.crudspringgraphqldemo.dto.BrandDTO;
import com.danilomontoya.crudspringgraphqldemo.entity.Brand;
import com.danilomontoya.crudspringgraphqldemo.enums.Country;
import com.danilomontoya.crudspringgraphqldemo.repository.BrandRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>crud-spring-graphql-demo</b> 23/02/2024, 2:52 PM
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    public Brand findOneBrands(int id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not exist Id"));
    }

    public Brand saveBrand(BrandDTO dto) {
        var brand = Brand.builder()
                .name(dto.getName())
                .country(dto.getCountry())
                .build();
        return brandRepository.save(brand);
    }

    public Brand updtaBrand(int id, BrandDTO dto) {

        var brand = brandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not exist Id"));

        brand.setName(dto.getName());
        brand.setCountry(dto.getCountry());
        return brandRepository.save(brand);
    }

    public Brand deleteBrand(int id) {
        var brand = brandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not exist Id"));

        brandRepository.delete(brand);
        return brand;
    }

    @PostConstruct
    private void loadData() {
        saveBrand(new BrandDTO("Mercedes", Country.GER));
        saveBrand(new BrandDTO("BMW", Country.GER));
        saveBrand(new BrandDTO("JAGUAR", Country.ENG));
    }
}

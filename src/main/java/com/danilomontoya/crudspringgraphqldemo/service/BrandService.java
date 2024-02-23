package com.danilomontoya.crudspringgraphqldemo.service;

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

    public Brand saveBrand(String name, Country country) {
        var brand = Brand.builder()
                .name(name)
                .country(country)
                .build();
        return brandRepository.save(brand);
    }

    public Brand updtaBrand(int id, String name, Country country) {

        var brand = brandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not exist Id"));

        brand.setName(name);
        brand.setCountry(country);
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
        saveBrand("Mercedes", Country.GER);
        saveBrand("BMW", Country.GER);
        saveBrand("JAGUAR", Country.ENG);
    }
}

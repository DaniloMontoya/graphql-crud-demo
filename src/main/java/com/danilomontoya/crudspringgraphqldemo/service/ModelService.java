package com.danilomontoya.crudspringgraphqldemo.service;

import com.danilomontoya.crudspringgraphqldemo.entity.Model;
import com.danilomontoya.crudspringgraphqldemo.repository.BrandRepository;
import com.danilomontoya.crudspringgraphqldemo.repository.ModelRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>crud-spring-graphql-demo</b> 23/02/2024, 3:46 PM
 **/
@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public List<Model> findAllModels() {
        return modelRepository.findAll();
    }

    public Model findOneModel(int id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not exist Id"));
    }

    public Model saveModel(int brandId, String name) {
        var brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new IllegalArgumentException("Not exist Id"));

        var model = Model.builder()
                .name(name)
                .brand(brand)
                .build();
        return modelRepository.save(model);
    }

    public Model updtaModel(int id, String name) {

        var model = modelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not exist Id"));
        model.setName(name);
        return modelRepository.save(model);
    }

    public Model deleteModel(int id) {
        var model = modelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not exist Id"));
        modelRepository.delete(model);
        return model;
    }

    @Lazy
    @PostConstruct
    private void loadData() {
        saveModel(1, "Clase s");
        saveModel(2, "Serie 5");
        saveModel(3, "F pace");
    }
}

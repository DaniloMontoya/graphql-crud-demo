package com.danilomontoya.crudspringgraphqldemo.controller;

import com.danilomontoya.crudspringgraphqldemo.entity.Brand;
import com.danilomontoya.crudspringgraphqldemo.entity.Model;
import com.danilomontoya.crudspringgraphqldemo.enums.Country;
import com.danilomontoya.crudspringgraphqldemo.service.BrandService;
import com.danilomontoya.crudspringgraphqldemo.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>crud-spring-graphql-demo</b> 23/02/2024, 3:02 PM
 **/
@RequiredArgsConstructor
@Controller
public class BrandController {

    private final BrandService brandService;
    private final ModelService modelService;

    @QueryMapping
    public List<Brand> findAllBrands() {
        return brandService.findAllBrands();
    }

    @QueryMapping
    public Brand findOneBrand(@Argument int id) {
        return brandService.findOneBrands(id);
    }

    @MutationMapping
    public Brand saveBrand(@Argument String name, @Argument Country country) {
        return brandService.saveBrand(name, country);
    }

    @MutationMapping
    public Brand updateBrand(@Argument int id, @Argument String name, @Argument Country country) {
        return brandService.updtaBrand(id, name, country);
    }

    @MutationMapping
    public Brand deleteBrand(@Argument int id) {
        return brandService.deleteBrand(id);
    }

    //MODEL
    @QueryMapping
    public List<Model> findAllModels() {
        return modelService.findAllModels();
    }

    @QueryMapping
    public Model findOneModel(@Argument int id) {
        return modelService.findOneModel(id);
    }

    @MutationMapping
    public Model saveModel(@Argument int brandId, @Argument String name) {
        return modelService.saveModel(brandId, name);
    }

    @MutationMapping
    public Model updateModel(@Argument int id, @Argument String name) {
        return modelService.updtaModel(id, name);
    }

    @MutationMapping
    public Model deleteModel(@Argument int id) {
        return modelService.deleteModel(id);
    }

}

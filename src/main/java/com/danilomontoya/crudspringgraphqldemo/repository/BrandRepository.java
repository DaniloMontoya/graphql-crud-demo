package com.danilomontoya.crudspringgraphqldemo.repository;

import com.danilomontoya.crudspringgraphqldemo.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>crud-spring-graphql-demo</b> 23/02/2024, 2:51 PM
 **/
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}

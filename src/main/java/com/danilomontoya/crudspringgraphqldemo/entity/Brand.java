package com.danilomontoya.crudspringgraphqldemo.entity;

import com.danilomontoya.crudspringgraphqldemo.enums.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>crud-spring-graphql-demo</b> 23/02/2024, 2:44 PM
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Country country;
    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}

package com.danilomontoya.crudspringgraphqldemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>crud-spring-graphql-demo</b> 23/02/2024, 2:47 PM
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Brand brand;
}

package com.danilomontoya.crudspringgraphqldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>crud-spring-graphql-demo</b> 23/02/2024, 4:52 PM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelDTO {
    private int brandId;
    private String name;
}

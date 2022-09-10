package com.fac.facgg.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Param {
    @Field(value = "Index")
    private String index;
    @Field(value = "Name")
    private String name;
    @Field(value = "Node")
    private Integer node;
    @Field(value = "Satellite")
    private Integer satellite;
    @Field(value = "Table")
    private Integer table;
}

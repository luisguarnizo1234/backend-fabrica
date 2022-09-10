package com.fac.facgg.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;
import java.util.Date;

@Document("maquinas")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Satellite {

    @Id
    private String id;
    @Field(value = "Param")
    private Param param;
    //private Long Ts;
    @Field(value = "Ts")
    private Long ts;
    private Double Val;

    @Override
    public String toString() {
        return "Satellite{" +
                "id='" + id + '\'' +
                ", param=" + param +
                ", ts=" + ts +
                ", Val=" + Val +
                '}';
    }
}

package com.myq.forecast.seir.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasicDTO implements Serializable {

    private Double s;
    private Double e;
    private Double i;
    private String time;
}

package com.myq.epidemic_sys.common.model.dto;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author 毛一钦
 * @Date 2022/3/18 13:19
 **/
@Data
@Accessors(chain = true)
public class ParamDTO {
    /**
     * odeProperties.json
     **/
    private Double gamma;
    private Double sigma;
    private Double beta;
    private Double nu;
    private Double mu;

    /**
     * properties.json
     **/
    private Double n;
    private Double s;
    private Double e;
    private Double i;
    private Integer t0;
    private Integer tMax;
}

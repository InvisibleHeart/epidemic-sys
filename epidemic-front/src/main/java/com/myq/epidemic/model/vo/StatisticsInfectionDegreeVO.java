package com.myq.epidemic.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author 毛一钦
 * @Date 2022/3/1 20:08
 **/
@Data
@Accessors(chain = true)
public class StatisticsInfectionDegreeVO {
    private List dateList;
    private List statisticsList;

}

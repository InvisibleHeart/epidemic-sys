package com.myq.epidemic.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author 毛一钦
 * @Date 2022/3/8 15:32
 **/
@Data
@Accessors(chain = true)
public class RegionIndexVO{

    private List regionList;
    private List regionItemList;
}

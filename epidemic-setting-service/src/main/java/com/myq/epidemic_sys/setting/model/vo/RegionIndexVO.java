package com.myq.epidemic_sys.setting.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 毛一钦
 * @Date 2022/3/8 15:32
 **/
@Data
public class RegionIndexVO implements Serializable {

    private List regionList;
    private List regionItemList;
}

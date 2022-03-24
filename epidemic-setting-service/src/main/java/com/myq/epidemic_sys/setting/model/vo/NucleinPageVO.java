package com.myq.epidemic_sys.setting.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 毛一钦
 * @Date 2022/2/28 21:09
 **/
@Data
@Accessors(chain = true)
public class NucleinPageVO implements Serializable {

    private long current;
    private long size;
    private long total;
    private long page;
    private List records;
    /**
     * 核酸日期
     */
    private String nucleinDate;
    /**
     * 结果【0-阴，1-阳】
     */
    private Integer result;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 患者ID
     */
    private Integer patientId;
}

package com.myq.epidemic.setting.model.dto;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 毛一钦
 * @date 2022/5/4 15:56
 * @Description
 **/
@Data
@Accessors(chain = true)
public class ReportingDTO {

    private String userName;

    private String identityCard;

    private Boolean sex;

    private Boolean travelCode;

    private String healthCode;

    private String physicalCondition;

    private String city;

    private String address;

    private String riskLevel;

    private String vaccines;

    private String nucleicTime;

    private String nucleicResults;

    private String cellphone;
}

package com.myq.epidemic_sys.setting.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("reporting")
public class Reporting implements Serializable {

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

package com.code.entity.freemarker;

import lombok.Data;


@Data
public class CompanyDetailVO {

    private String companyPkId;

    private String companyName;

    private String orgCode;

    private String region;

    private String address;

    private String industryPkId;

    private String legalPerson;

    private String legalPersonPhone;

    private String carbonLeader;

    private String carbonLeaderPosition;

    private String carbonLeaderPhone;

    private String year;

    private String dateRange;
}

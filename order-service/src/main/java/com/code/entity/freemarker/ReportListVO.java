package com.code.entity.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @name: ReportListVO
 * @author: mubai.
 * @date: 2022/5/9
 * @version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "ReportListVO", description = "碳排放报告列表数据")
public class ReportListVO {
    @ApiModelProperty("企业名称")
    private String companyName;
    @ApiModelProperty("组织机构代码")
    private String orgCode;
    @ApiModelProperty("是否已做碳排放核算,如果为否则不允许点击查看报告")
    private Boolean isCalc;
    @ApiModelProperty("碳排放核算时间，年度报告时为空")
    private String calcTime;
    @ApiModelProperty("监测计划版本，年度报告时为空")
    private String versionName;
    @ApiModelProperty("年度")
    private String year;
    @ApiModelProperty("月份，年度报告时为空")
    private String month;
    @ApiModelProperty("报告id，月报时非空")
    private String reportPkId;
    @ApiModelProperty("计划id，月报时非空")
    private String planPkId;
}

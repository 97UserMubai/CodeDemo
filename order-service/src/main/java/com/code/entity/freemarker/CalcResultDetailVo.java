package com.code.entity.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 核算结果详情Vo
 * </p>
 *
 * @author gzk
 * @since 2022/4/21
 */
@Data
@ApiModel(value = "CalcResultDetailVo", description = "核算结果详情Vo")
public class CalcResultDetailVo {

    @ApiModelProperty(value = "因子类型，by 数据字典 typePkId = 202")
    private String factorType;

    @ApiModelProperty(value = "因子分类：1-活动水平，2-排放因子")
    private String valueType;

    @ApiModelProperty(value = "因子类型Value")
    private String factorTypeValue;

    @ApiModelProperty(value = "因子值")
    private String factorValue;

    @ApiModelProperty(value = "因子单位")
    private Integer factorUnit;

    @ApiModelProperty(value = "因子单位Value")
    private String factorUnitValue;

    @ApiModelProperty(value = "因子数据来源，by 数据字典 typePkId = 207")
    private Integer dataSource;

    @ApiModelProperty(value = "因子数据来源，by 数据字典 typePkId = 207")
    private String dataSourceName;

}

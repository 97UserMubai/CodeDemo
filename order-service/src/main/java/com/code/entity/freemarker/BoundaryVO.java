package com.code.entity.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @name: CalcBoundaryVO
 * @author: mubai.
 * @date: 2022/5/6
 * @version: 1.0
 * @description: 碳排放报告核算因子数据
 */
@Data
@ApiModel(value = "BoundaryVO", description = "报告核算边界vo对象")
public class BoundaryVO {

    @ApiModelProperty(value = "核算单位总数")
    private Integer unitNum;

    @ApiModelProperty(value = "核算单位拼接名称")
    private String unitFullName;

    @ApiModelProperty("排放类型拼接名称")
    private String emissionFullName;

    @ApiModelProperty("直接排放源拼接名称")
    private String directSourceFullName;

    @ApiModelProperty("间接排放源拼接名称")
    private String indirectSourceFullName;

    @ApiModelProperty("边界节点集合")
    private List<ReportNodeVO> nodeVOS;

}

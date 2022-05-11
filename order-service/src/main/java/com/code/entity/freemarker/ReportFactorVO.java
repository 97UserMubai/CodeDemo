package com.code.entity.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @name: ReportFactorVO
 * @author: mubai.
 * @date: 2022/5/7
 * @version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "ReportFactorVO", description = "报告活动水平及因子对象")
public class ReportFactorVO {
    @ApiModelProperty("活动水平节点集合")
    private List<ReportFactorNodeVO> activityNodes;

    @ApiModelProperty("排放因子节点集合")
    private List<ReportFactorNodeVO> factorNodes;
}

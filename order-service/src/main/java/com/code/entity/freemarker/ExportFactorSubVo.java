package com.code.entity.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Classname ExportFactorSubVo
 * @Description TODO
 * @Date 2022-5-15 22:05
 * @Created by mubai
 */
@Data
@ApiModel(value = "ExportFactorNodeVo", description = "核算因子数据导出")
public class ExportFactorSubVo {
    @ApiModelProperty("单元格名称")
    private String name;

    @ApiModelProperty("是否需要合并,1-合并，第一层，restart，2-合并，非第一层，continue，3-不需要合并")
    private String mergeType;

    @ApiModelProperty("合并到指定列，例如排放活动类型层需要合并(有多个核算节点)，则level=3，往前推：排放类型为2，排放单元和核算行业为1")
    private String mergeLevel;
}

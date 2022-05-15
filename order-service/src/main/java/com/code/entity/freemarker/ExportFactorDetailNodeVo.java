package com.code.entity.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Classname ExportFactorDetailNodeVo
 * @Description TODO
 * @Date 2022-5-15 22:02
 * @Created by mubai
 */
@Data
@ApiModel(value = "ExportFactorDetailNodeVo", description = "核算因子明细对象")
public class ExportFactorDetailNodeVo {
    @ApiModelProperty(value = "排放活动类型名称")
    private String activityTypeName;

    @ApiModelProperty(value = "横向遍历数据")
    private List<Map<String, ExportFactorSubVo>> subVos;
}

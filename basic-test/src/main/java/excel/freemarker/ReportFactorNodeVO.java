package excel.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @name: ReportFactorNodeVO
 * @author: mubai.
 * @date: 2022/5/7
 * @version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "ReportFactorNodeVO", description = "报告排放因子对象")
public class ReportFactorNodeVO {
    @ApiModelProperty(value = "排放单位Id")
    private String unitId;
    @ApiModelProperty(value = "排放单位名称")
    private String unitName;
    @ApiModelProperty(value = "核算行业名称")
    private String industryName;
    @ApiModelProperty(value = "排放类型名称")
    private String emissionTypeName;
    @ApiModelProperty(value = "排放活动类型Id")
    private String activityTypeId;
    @ApiModelProperty(value = "排放活动名称")
    private String activityTypeName;

    @ApiModelProperty("核算边界节点数据")
    private List<ReportFactorSubNodeVO> subNodeVOS;
}

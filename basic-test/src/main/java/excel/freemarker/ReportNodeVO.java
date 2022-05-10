package excel.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @name: CalcReportItemVO
 * @author: mubai.
 * @date: 2022/5/7
 * @version: 1.0
 * @description: 核算节点vo对象
 */
@Data
@ApiModel(value = "CalcReportNodeVO", description = "报告核算边界节点vo对象")
public class ReportNodeVO {

    @ApiModelProperty("节点Id")
    private String nodePkId;
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
    @ApiModelProperty(value = "排放源Id")
    private String sourceId;
    @ApiModelProperty(value = "排放源名称")
    private String sourceName;
    @ApiModelProperty(value = "排放单元名称")
    private String cellName;
    @ApiModelProperty(value = "排放设备名称")
    private String deviceName;

    @ApiModelProperty("能耗消耗量")
    private String calcValue;

    @ApiModelProperty(value = "二氧化碳排放量")
    private String carbonUseTotal;

    @ApiModelProperty("计算因子数据")
    private List<CalcResultDetailVo> factorDetails;

}

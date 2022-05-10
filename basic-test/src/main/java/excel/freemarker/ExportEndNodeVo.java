package excel.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @name: ExportEndNodeVo
 * @author: mubai.
 * @date: 2022/5/10
 * @version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "ExportEndNodeVo", description = "核算叶子节点数据")
public class ExportEndNodeVo {
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

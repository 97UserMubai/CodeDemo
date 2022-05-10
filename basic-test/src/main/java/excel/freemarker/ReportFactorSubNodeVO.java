package excel.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @name: ReportFactorSubNodeVO
 * @author: mubai.
 * @date: 2022/5/7
 * @version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "ReportFactorSubNodeVO", description = "报告排放因子子对象")
public class ReportFactorSubNodeVO {
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

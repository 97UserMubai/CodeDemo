package excel.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @name: ReportCarbonVO
 * @author: mubai.
 * @date: 2022/5/7
 * @version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "ReportCarbonVO", description = "温室气体排放数据")
public class ReportCarbonVO {
    @ApiModelProperty("核算月份：月度报告时为yyyy年xx月，年度报告时为yyyy年")
    private String calcMonth;

    @ApiModelProperty("总值")
    private String total;

    @ApiModelProperty("二氧化碳排放总额")
    private String carbonTotal;

    @ApiModelProperty("二氧化碳排放百分比")
    private String carbonPercent;

    @ApiModelProperty("二氧化碳直接排放总量")
    private String directCarbonTotal;

    @ApiModelProperty("二氧化碳直接排放百分比")
    private String directCarbonPercent;

    @ApiModelProperty("二氧化碳间接排放总量")
    private String indirectCarbonTotal;

    @ApiModelProperty("二氧化碳间接排放百分比")
    private String indirectCarbonPercent;

    @ApiModelProperty("二氧化碳年度排放额度")
    private String carbonQuota;

    @ApiModelProperty("年度剩余排放额度")
    private String remainingCarbonQuota;

    @ApiModelProperty("边界节点集合")
    private List<ReportNodeVO> nodeVOS;

}

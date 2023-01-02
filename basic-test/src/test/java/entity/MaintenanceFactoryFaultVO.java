package entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Classname MaintenanceFactoryFaultVO
 * @Description TODO
 * @Date 2023-1-2 11:15
 * @Created by mubai
 */
@Data
@ApiModel(value = "MaintenanceFactoryFaultVO", description = "运维日报表厂务报修数据")
public class MaintenanceFactoryFaultVO {
    @ApiModelProperty(value = "电气科完成数量(当日)")
    private Integer dqDayCompleteCount;
    @ApiModelProperty(value = "电气科月度总数量")
    private Integer dqMonthCount;
    @ApiModelProperty(value = "化学科完成数量(当日)")
    private Integer hxDayCompleteCount;
    @ApiModelProperty(value = "化学科月度总数量")
    private Integer hxMonthCount;
    @ApiModelProperty(value = "机械科完成数量(当日)")
    private Integer jxDayCompleteCount;
    @ApiModelProperty(value = "机械科月度总数量")
    private Integer jxMonthCount;
    @ApiModelProperty(value = "厂务报修明细数据")
    private List<MaintenanceFaultDetailVO> reportDetailVOList;

}

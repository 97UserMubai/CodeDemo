package entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Classname MaintenancePhoneFaultVO
 * @Description TODO
 * @Date 2023-1-2 10:38
 * @Created by mubai
 */
@Data
public class MaintenancePhoneFaultVO {

    @ApiModelProperty(value = "电气科月报统计数量")
    private Integer dqFaultCount;
    @ApiModelProperty(value = "机械科月报统计数量")
    private Integer jxFaultCount;
    @ApiModelProperty(value = "化学月报统计数量")
    private Integer hxFaultCount;
    @ApiModelProperty(value = "电话报修明细数据")
    private List<MaintenanceFaultDetailVO> faultDetailVOList;
}

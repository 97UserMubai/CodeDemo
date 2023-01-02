package entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Classname MaintenanceItemDataVO
 * @Description TODO
 * @Date 2023-1-2 11:48
 * @Created by mubai
 */
@Data
@ApiModel(value = "MaintenanceItemDataVO", description = "运维日报表-重要运行参数数据")
public class MaintenanceItemDataVO {
    @ApiModelProperty(value = "检查项目id")
    private String itemPkId;
    @ApiModelProperty(value = "点类型id")
    private String ptTypeId;
    @ApiModelProperty(value = "检查项名称")
    private String itemName;
    @ApiModelProperty(value = "单位")
    private String unit;
    @ApiModelProperty(value = "正常范围")
    private String range;
    @ApiModelProperty(value = "具体值集合，前端按照顺序回显数值即可，固定为13列")
    private List<String> values;
}


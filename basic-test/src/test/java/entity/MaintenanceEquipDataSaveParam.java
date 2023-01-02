package entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Classname MaintenanceEquipDataSaveParam
 * @Description TODO
 * @Date 2023-1-2 11:47
 * @Created by mubai
 */
@Data
@ApiModel(value = "MaintenanceEquipDataSaveParam", description = "查询重要运行参数")
public class MaintenanceEquipDataSaveParam {
    @ApiModelProperty(value = "系统id")
    private String equipmentTypePkId;
    @ApiModelProperty(value = "系统名称")
    private String equipmentTypeName;
    @ApiModelProperty(value = "设备id")
    private String equipmentPkId;
    @ApiModelProperty(value = "设备名称")
    private String equipmentName;
    @ApiModelProperty(value = "监控设备id")
    private String devId;
    @ApiModelProperty(value = "负责人")
    private String manager;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "重要运行参数列表")
    private List<MaintenanceItemDataVO> itemDataVOS;
}
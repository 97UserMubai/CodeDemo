package entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Classname MaintenanceFaultDetailVO
 * @Description TODO
 * @Date 2023-1-2 10:39
 * @Created by mubai
 */
@Data
@ApiModel(value = "MaintenanceFaultDetailVO", description = "运维日报表故障明细信息")
public class MaintenanceFaultDetailVO {
    //通用部分
    @ApiModelProperty(value = "电话报修-事件/异常故障追踪中的异常/故障，实际上就是一个排序的编号")
    private Integer index;
    @ApiModelProperty(value = "科室id")
    private String stockDepId;
    @ApiModelProperty(value = "科室名称")
    private String stockDepName;
    @ApiModelProperty(value = "故障描述", example = "故障描述")
    private String faultDesc;
    @ApiModelProperty(value = "上报时间", example = "上报时间")
    private String reportDate;
    @ApiModelProperty(value = "预计完成时间")
    private String completeTime;
    //电话报修
    @ApiModelProperty(value = "故障区域")
    private String areaName;
    @ApiModelProperty(value = "报修单位")
    private String reportUnit;
    @ApiModelProperty(value = "报修人")
    private String reportUser;
    @ApiModelProperty(value = "报修人电话")
    private String reportUserPhone;
    @ApiModelProperty(value = "接话人")
    private String receiver;
    //处理部分
    @ApiModelProperty(value = "故障状态,0-未处理，1-处理中，2-已处理(已完结)，0,1两个状态表示未完结")
    private Integer faultStatus;
    @ApiModelProperty(value = "处理情况")
    private String faultSolution;
    @ApiModelProperty(value = "处理人")
    private String handler;
    @ApiModelProperty(value = "处理时间")
    private String handleTime;

}

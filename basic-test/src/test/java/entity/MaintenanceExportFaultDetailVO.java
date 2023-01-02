package entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Classname MaintenanceExportFaultDetailVO
 * @Description TODO
 * @Date 2023-1-2 15:55
 * @Created by mubai
 */
@Data
public class MaintenanceExportFaultDetailVO {
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
    private String endStatus;
    private String noEndStatus;
    @ApiModelProperty(value = "处理情况")
    private String faultSolution;
    @ApiModelProperty(value = "处理人")
    private String handler;
    @ApiModelProperty(value = "处理时间")
    private String handleTime;

    //下面是导出的表头部分
    private String indexTitle = "事件：";
    private String stockDepIdTitle;
    private String stockDepNameTitle = "";
    private String faultDescTitle = "故障描述";
    private String reportDateTitle = "日期/时间";
    private String completeTimeTitle = "预计完成时间";
    //电话报修
    private String areaNameTitle = "报修区域";
    private String reportUnitTitle = "报修单位";
    private String reportUserTitle = "报修人";
    private String reportUserPhoneTitle = "联系电话";
    private String receiverTitle = "接话人";

    //处理部分
    private Integer faultStatusTitle;
    private String endStatusTitle = "完结";
    private String noEndStatusTitle = "未完结";
    private String faultSolutionTitle = "处理情况";
    private String handlerTitle = "处理人";
    private String handleTimeTitle = "实际完成时间";

}

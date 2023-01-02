package entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @name: MaintenanceDayReportDetailVO
 * @author: Mubai.Wang
 * @date: 2022/12/21
 * @version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "MaintenanceDayReportDetailVO", description = "运维日报表值班情况明细信息")
public class MaintenanceDayReportDetailVO {
    @ApiModelProperty(value = "科室id，对应数据字典140，目前固定电气，机械，化学三个科室")
    @NotBlank(message = "科室id不允许为空")
    private String stockDepId;

    @ApiModelProperty(value = "当班人员/交接情况")
    private String stockDepName;

    @ApiModelProperty(value = "组长")
    private String leader;

    @ApiModelProperty(value = "组员")
    private String members;

    @ApiModelProperty(value = "上一班组成员")
    private String lastMembers;

    @ApiModelProperty(value = "下一班组成员")
    private String nextMembers;

    @ApiModelProperty(value = "未到岗组员")
    private String absentMembers;

    @ApiModelProperty(value = "未到岗原因")
    private String absentReason;

    @ApiModelProperty(value = "表单交接")
    private String formHandover;

    @ApiModelProperty(value = "物品交接")
    private String itemsHandover;

    @ApiModelProperty(value = "一个固定的自定义列")
    private String auto6s;

    @ApiModelProperty(value = "备注")
    private String remark;
}


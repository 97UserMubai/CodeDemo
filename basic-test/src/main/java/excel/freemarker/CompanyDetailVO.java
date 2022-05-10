package excel.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "CompanyDetailVO", description = "报告企业信息vo对象")
public class CompanyDetailVO {

    @ApiModelProperty("企业id")
    private String companyPkId;

    @ApiModelProperty("企业名称")
    private String companyName;

    @ApiModelProperty("组织机构编码")
    private String orgCode;

    @ApiModelProperty("所属地区")
    private String region;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("行业类型")
    private String industryPkId;

    @ApiModelProperty("企业法人")
    private String legalPerson;

    @ApiModelProperty("法人联系电话")
    private String legalPersonPhone;

    @ApiModelProperty("碳排放负责人")
    private String carbonLeader;

    @ApiModelProperty("碳排放负责人职务")
    private String carbonLeaderPosition;

    @ApiModelProperty("碳排放负责人联系电话")
    private String carbonLeaderPhone;

    @ApiModelProperty("报告年份")
    private String year;

    @ApiModelProperty("碳盘查期")
    private String dateRange;
}

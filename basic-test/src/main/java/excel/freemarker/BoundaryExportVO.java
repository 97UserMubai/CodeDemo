package excel.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @name: BoundaryExportVO
 * @author: mubai.
 * @date: 2022/5/10
 * @version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "BoundaryExportVO", description = "报告核算边界vo对象")
public class BoundaryExportVO {

    @ApiModelProperty(value = "核算单位总数")
    private Integer unitNum;

    @ApiModelProperty(value = "核算单位拼接名称")
    private String unitFullName;

    @ApiModelProperty("排放类型拼接名称")
    private String emissionFullName;

    @ApiModelProperty("直接排放源拼接名称")
    private String directSourceFullName;

    @ApiModelProperty("间接排放源拼接名称")
    private String indirectSourceFullName;

    @ApiModelProperty("边界节点集合")
    private List<ExportUnitNodeVo> unitNodes;

}

package excel.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @name: ExportNodeVo
 * @author: mubai.
 * @date: 2022/5/10
 * @version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "ExportNodeVo", description = "导出节点数据")
public class ExportUnitNodeVo {
    @ApiModelProperty(value = "排放单位名称")
    private String unitName;
    @ApiModelProperty(value = "核算行业名称")
    private String industryName;

    /**
     * 直接排放
     */
    private List<ExportActivityNodeVo> directEmissionNodes;
    /**
     * 间接排放
     */
    private List<ExportActivityNodeVo> indirectEmissionNodes;

}

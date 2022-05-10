package excel.freemarker;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @name: ExportActivityNodeVo
 * @author: mubai.
 * @date: 2022/5/10
 * @version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "ExportActivityNodeVo", description = "排放活动类型节点数据")
public class ExportActivityNodeVo {
    private String activityTypeName;

    private List<ExportEndNodeVo> endNodes;

}

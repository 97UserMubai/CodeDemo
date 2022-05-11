package excel.freemarker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @name: ExportNodeVo
 * @author: mubai.
 * @date: 2022/5/11
 * @version: 1.0
 * @description: <pre>
 *     freemarker导出的核算节点数据需要在遍历时候判断是否需要合并
 *     word格式的xml设计中，对需要合并的单元格，做了如下的处理
 *     <li>
 *         1.需要导出的合并数据为第一行，则合并部分的<w:tcPr>标签内需要如下的参数：
 *         <p>
 *             <w:vmerge w:val="restart"/>
 *         </p>
 *         2.对于导出的合并数据非第一行，则合并部分的<w:tcPr>标签内需要如下的参数：
 *         <p>
 *             <w:vmerge w:val="continue"/>
 *         </p>
 *         3.对于不需要合并的行，则不需要上述的这两行xml代码
 *     </li>
 *     基于上面的三种情况，需要在遍历的数据中进行判断，逻辑如下：
 *     1.当mergeType=1/2时需要根据mergeLevel进行参数的判断
 *     判断语句如下
 *     <p>
 *         <#if node.mergeType == 1>
 *         <#if node.mergeLevel == 1 || node.mergeLevel ==  2 || node.mergeLevel == 3>
 *              <w:vmerge w:val="restart"/>
 *         </#if>
 *         </#if>
 *     </p>
 *     上面的判断语句为核算行业层级的输出，往下两个需要合并的层级进行递减即可
 * </pre>
 */
@Data
@ApiModel(value = "ExportNodeVo", description = "导出核算节点数据")
public class ExportNodeVo {

    @ApiModelProperty("是否需要合并,1-合并，第一层，restart，2-合并，非第一层，continue，3-不需要合并")
    private String mergeType;

    @ApiModelProperty("合并到指定列，例如排放活动类型层需要合并(有多个核算节点)，则level=3，往前推：排放类型为2，排放单元和核算行业为1")
    private String mergeLevel;

    private String unitName;

    private String industryName;

    @ApiModelProperty(value = "类型名称")
    private String emissionName;

    @ApiModelProperty(value = "排放活动类型名称")
    private String activityTypeName;

    @ApiModelProperty(value = "排放源名称")
    private String sourceName;

    @ApiModelProperty(value = "排放单元名称")
    private String cellName;

    @ApiModelProperty(value = "排放设备名称")
    private String deviceName;

    @ApiModelProperty("能耗消耗量")
    private String calcValue;

    @ApiModelProperty(value = "二氧化碳排放量")
    private String carbonUseTotal;

}

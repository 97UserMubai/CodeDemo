package com.code.entity.freemarker;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @Classname ExportFactorNodeVo
 * @Date 2022-5-15 21:23
 * @Created by mubai
 * @Description 核算因子数据导出数据结构需要支持如下条件
 * <pre>
 *     1.根据排放水平因子和核算因子进行第一层的区分，届时会是两个独立的数组，分别包含ExportFactorNodeVo对象
 *     2.遍历内容从核算单位开始，具体结构
 *     <li>
 *         a) 1.1 核算单位名称-核算行业
 *         b) 1.1.1 直接排放活动水平数据  这一块是固定，当有一个单位是就一定会有一个排放类型(只需要有直接或间接或者两者都有)
 *         c) 1.1.1.1 排放活动类型名称
 *         d) 开始遍历table，除了前置的固定列:排放源，排放单元，排放设备，报告期间消耗量(单位)，数据来源，横向遍历因子列表
 *         PS: 这个位置的table页有点特别，表头和单元格数据都是需要遍历的，因为需要支持横向遍历，
 *         通过观察word xml格式中的表头和表格内容格式是一致的，ftl语言支持对map内容进行遍历，语法如下
 *         假定products这个map的内容为{ "apple": 5, "banana": 10, "kiwi": 15 }
 *         <#list products as name, price>
 *              <p>${name}: ${price}
 *         </#list>
 *         TODO 上面这个案例为String->String的例子，需要验证是否支持String-Object的模式
 *         假若支持，则最后的数据结构为List<Map<String,Object>>
 *         xml横向遍历逻辑如下
 *         ① List将遍历每一行的数据，Map<String,Object>用于横向遍历每个单元格的内容
 *         ② 每个Object内容包含:
 *            1.单元格内容
 *            2.是否需要merge
 *            3.mergeLevel
 *     </li>
 * </pre>
 */
@Data
@ApiModel(value = "ExportFactorNodeVo", description = "核算因子数据导出")
public class ExportFactorNodeVo {
    private String unitName;

    private String industryName;

    private List<ExportFactorDetailNodeVo> directDetailVos;

    private List<ExportFactorDetailNodeVo> indirectDetailVos;
}

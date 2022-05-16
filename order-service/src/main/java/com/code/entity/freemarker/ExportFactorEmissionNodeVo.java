package com.code.entity.freemarker;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @Classname ExportFactorEmissionNodeVo
 * @Description TODO
 * @Date 2022-5-16 22:28
 * @Created by mubai
 */
@Data
@ApiModel(value = "ExportFactorEmissionNodeVo", description = "核算因子排放类型对象")
public class ExportFactorEmissionNodeVo {

    private String emissionFullName;

    private List<ExportFactorDetailNodeVo> detailVos;


}

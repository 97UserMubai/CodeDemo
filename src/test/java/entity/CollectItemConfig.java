package entity;

import lombok.Data;

/**
 * @author liuyz
 * @Description 采集数据项配置
 * @date 2021/4/29 15:54
 */
@Data
public class CollectItemConfig {
    //采集数据项指标名称
    private String name;
    //生产工序，参照行业采集指南
    private String processCode;
    //工序单元
    private String processUnitCode;
    //重点耗能设备类型
    private String equipmentCode;
    //重点耗能设备编号
    private String equipmentUnitCode;
    //采集对象类型
    private String energyClassCode;
    //能源分类 + 分项
    private String energyTypeCode;
    //用途编码
    private String dataUsageCode;
    //数据采集来源
    private String inputType;
    //数据最大值
    private Long dataValueMax;
    //数据最小值
    private Long dataValueMin;
    //采集频率，0 实时; 1 日; 2 月;3 年
    private String statType;
    //采集系统名称
    private String collectSystemNam;
    //备注
    private String remark;
    //范围 1：全厂，2：生产工序，3：生产工序单元，4：重点耗能设备
    private Integer scope;
}

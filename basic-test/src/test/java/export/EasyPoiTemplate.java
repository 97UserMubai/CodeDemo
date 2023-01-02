package export;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.alibaba.fastjson.JSON;
import entity.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Classname EasyPoiTemplate
 * @Description TODO
 * @Date 2022-12-30 18:04
 * @Created by mubai
 */
@Slf4j
public class EasyPoiTemplate {

    private static final String STOCK_DQ = "3";
    private static final String STOCK_JX = "4";
    private static final String STOCK_HX = "2";

    //基础信息导出的行数12行,电话保修的行数=3+n*4,厂务报修的行数的=7+n*2
    private static final int BASE_ROW_INDEX = 12;
    private static final int PHONE_FAULT_ROW_INDEX = 3;
    private static final int FACTORY_FAULT_ROW_INDEX = 7;
    private static final int PHONE_FAULT_SIZE = 4;
    private static final int FACTORY_FAULT_SIZE = 2;
    private static final int IMPORTANCE_ROW_INDEX = 3;
    private static final int MERGER_EQUIPMENT_TYPE_BEGIN_INDEX = 1;
    private static final int MERGER_EQUIPMENT_TYPE_END_INDEX = 2;
    private static final int MERGER_EQUIPMENT_BEGIN_INDEX = 3;
    private static final int MERGER_EQUIPMENT_END_INDEX = 4;
    private static final int MERGER_MANAGER_BEGIN_INDEX = 23;
    private static final int MERGER_MANAGER_END_INDEX = 24;
    private static final int MERGER_REMARK_BEGIN_INDEX = 25;
    private static final int MERGER_REMARK_END_INDEX = 26;


    @Test
    public void testExport() throws Exception {
        Workbook workbook = getBaseWorkBook(getMaintenanceDayReportDetailVOList(), "2022-01-01", "2022-01-01 00:00:00");
        FileOutputStream fos = new FileOutputStream("D:\\export\\fault_template_" + System.currentTimeMillis() + ".xlsx");
        workbook.write(fos);
        fos.close();
    }

    @Test
    public void testFaultExport() throws Exception {
        Workbook workbook = getFaultBaseWorkBook();
        FileOutputStream fos = new FileOutputStream("D:\\export\\phone_fault_template_" + System.currentTimeMillis() + ".xlsx");
        workbook.write(fos);
        fos.close();
    }

    private Workbook getFaultBaseWorkBook() {
        Map<String, Object> dataListMap = new HashMap<>();
        dealPhoneFaultMap(dataListMap);
        //读取模板
        TemplateExportParams params = new TemplateExportParams("D:\\projects\\CodeDemo\\basic-test\\src\\main\\resources\\template\\export\\maintence_phone_fault_template.xlsx");
        return ExcelExportUtil.exportExcel(params, dataListMap);
    }


    private List<MaintenanceDayReportDetailVO> getMaintenanceDayReportDetailVOList() {
        List<MaintenanceDayReportDetailVO> list = new ArrayList<>();
        list.add(getMaintenanceDayReportDetailVO("2"));
        list.add(getMaintenanceDayReportDetailVO("3"));
        list.add(getMaintenanceDayReportDetailVO("4"));
        return list;
    }

    private MaintenanceDayReportDetailVO getMaintenanceDayReportDetailVO(String stockDepId) {
        MaintenanceDayReportDetailVO maintenanceDayReportDetailVO = new MaintenanceDayReportDetailVO();
        maintenanceDayReportDetailVO.setStockDepId(stockDepId);
        maintenanceDayReportDetailVO.setAuto6s("test");
        maintenanceDayReportDetailVO.setLeader("詹总");
        maintenanceDayReportDetailVO.setMembers("小王");
        maintenanceDayReportDetailVO.setAbsentMembers("小王");
        maintenanceDayReportDetailVO.setAbsentReason("杨康");
        maintenanceDayReportDetailVO.setLastMembers("小王");
        maintenanceDayReportDetailVO.setNextMembers("小王");
        maintenanceDayReportDetailVO.setFormHandover("nice表单");
        maintenanceDayReportDetailVO.setItemsHandover("nice物件");
        maintenanceDayReportDetailVO.setRemark("haha");
        return maintenanceDayReportDetailVO;
    }

    private Workbook getBaseWorkBook(List<MaintenanceDayReportDetailVO> detailVOList, String reportDate, String exportTime) {
        Map<String, Object> dataListMap = new HashMap<>();
        dataListMap.put("reportDate", reportDate);
        dataListMap.put("exportTime", exportTime);
        Map<String, MaintenanceDayReportDetailVO> detailVOMap = detailVOList.stream().collect(Collectors.toMap(MaintenanceDayReportDetailVO::getStockDepId,
                Function.identity()));
        if (detailVOMap.containsKey(STOCK_DQ)) {
            dataListMap.put("dqLeader", detailVOMap.get(STOCK_DQ).getLeader());
            dataListMap.put("dqMembers", detailVOMap.get(STOCK_DQ).getMembers());
            dataListMap.put("dqAbsentMembers", detailVOMap.get(STOCK_DQ).getAbsentMembers());
            dataListMap.put("dqAbsentReason", detailVOMap.get(STOCK_DQ).getAbsentReason());
            dataListMap.put("dqLastMembers", detailVOMap.get(STOCK_DQ).getLastMembers());
            dataListMap.put("dqFormHandover", detailVOMap.get(STOCK_DQ).getFormHandover());
            dataListMap.put("dqItemsHandover", detailVOMap.get(STOCK_DQ).getItemsHandover());
            dataListMap.put("dqAuto6s", detailVOMap.get(STOCK_DQ).getAuto6s());
            dataListMap.put("dqRemark", detailVOMap.get(STOCK_DQ).getRemark());
            dataListMap.put("dqNextMembers", detailVOMap.get(STOCK_DQ).getNextMembers());
        }

        if (detailVOMap.containsKey(STOCK_JX)) {
            dataListMap.put("jxLeader", detailVOMap.get(STOCK_JX).getLeader());
            dataListMap.put("jxMembers", detailVOMap.get(STOCK_JX).getMembers());
            dataListMap.put("jxAbsentMembers", detailVOMap.get(STOCK_JX).getAbsentMembers());
            dataListMap.put("jxAbsentReason", detailVOMap.get(STOCK_JX).getAbsentReason());
            dataListMap.put("jxLastMembers", detailVOMap.get(STOCK_JX).getLastMembers());
            dataListMap.put("jxFormHandover", detailVOMap.get(STOCK_JX).getFormHandover());
            dataListMap.put("jxItemsHandover", detailVOMap.get(STOCK_JX).getItemsHandover());
            dataListMap.put("jxAuto6s", detailVOMap.get(STOCK_JX).getAuto6s());
            dataListMap.put("jxRemark", detailVOMap.get(STOCK_JX).getRemark());
            dataListMap.put("jxNextMembers", detailVOMap.get(STOCK_JX).getNextMembers());
        }

        if (detailVOMap.containsKey(STOCK_HX)) {
            dataListMap.put("hxLeader", detailVOMap.get(STOCK_HX).getLeader());
            dataListMap.put("hxMembers", detailVOMap.get(STOCK_HX).getMembers());
            dataListMap.put("hxAbsentMembers", detailVOMap.get(STOCK_HX).getAbsentMembers());
            dataListMap.put("hxAbsentReason", detailVOMap.get(STOCK_HX).getAbsentReason());
            dataListMap.put("hxLastMembers", detailVOMap.get(STOCK_HX).getLastMembers());
            dataListMap.put("hxFormHandover", detailVOMap.get(STOCK_HX).getFormHandover());
            dataListMap.put("hxItemsHandover", detailVOMap.get(STOCK_HX).getItemsHandover());
            dataListMap.put("hxAuto6s", detailVOMap.get(STOCK_HX).getAuto6s());
            dataListMap.put("hxRemark", detailVOMap.get(STOCK_HX).getRemark());
            dataListMap.put("hxNextMembers", detailVOMap.get(STOCK_HX).getNextMembers());
        }

        int phoneFaultSize = dealPhoneFaultMap(dataListMap);

        int factorySize = dealFactoryFaultMap(dataListMap);

        List<MaintenanceExportItemData> itemDataList = dealImportanceData(dataListMap, getDefaultItemDataList());

        //读取模板
        TemplateExportParams params = new TemplateExportParams("D:\\projects\\CodeDemo\\basic-test\\src\\main\\resources\\template\\export\\maintence_base_template2.xlsx");
        Workbook workbook = new MyExcelExportOfTemplateUtil().createExcelByTemplate(params, null, null, dataListMap);
        //todo 进行重要运行参数的单元格合并处理
        if (Objects.nonNull(workbook)) {
            List<MergeEntity> mergeEntities = dealMergeRange(itemDataList, phoneFaultSize, factorySize);
            //进行合并处理
            if (mergeEntities.size() > 0) {
                merge(workbook, mergeEntities);
            }
        }
        return workbook;
    }

    private void merge(Workbook workbook, List<MergeEntity> mergeEntities) {
        Sheet sheet = workbook.getSheetAt(0);
        for (MergeEntity mergeEntity : mergeEntities) {
            try {
                sheet.addMergedRegion(new CellRangeAddress(mergeEntity.getFirstRow(), mergeEntity.getLastRow(),
                        mergeEntity.getFirstCol(), mergeEntity.getLastCol()));
            } catch (Exception e) {
                log.info("合并存在问题,当前偏移位置:{}", JSON.toJSONString(mergeEntity));
            }
        }
    }

    private List<MergeEntity> dealMergeRange(List<MaintenanceExportItemData> itemDataList, int phoneFaultSize, int factorySize) {
        List<MergeEntity> list = new ArrayList<>();
        if (itemDataList == null || itemDataList.size() <= 1) {
            return list;
        }
        //得到合并的初始行
        int prefixSize = BASE_ROW_INDEX + PHONE_FAULT_ROW_INDEX + (phoneFaultSize > 0 ? phoneFaultSize : 1) * PHONE_FAULT_SIZE +
                FACTORY_FAULT_ROW_INDEX + (factorySize > 0 ? factorySize : 1) * FACTORY_FAULT_SIZE + IMPORTANCE_ROW_INDEX;
        //进行重要运行参数的分组处理
        Map<String, List<MaintenanceExportItemData>> typeMap = new LinkedHashMap<>();
        itemDataList.forEach(item -> {
            if (typeMap.containsKey(item.getEquipmentTypePkId())) {
                typeMap.get(item.getEquipmentTypePkId()).add(item);
            } else {
                List<MaintenanceExportItemData> innerList = new ArrayList<>();
                innerList.add(item);
                typeMap.put(item.getEquipmentTypePkId(), innerList);
            }
        });
        AtomicInteger beginIndex = new AtomicInteger(prefixSize);
        //类型层处理完成,先组装系统名称,负责人,备注三列的合并内容
        typeMap.forEach((key, values) -> {
            int firstRow = beginIndex.get();
            int lastRow = firstRow + values.size() - 1;
            list.add(new MergeEntity(firstRow, lastRow, MERGER_EQUIPMENT_TYPE_BEGIN_INDEX, MERGER_EQUIPMENT_TYPE_END_INDEX));
            list.add(new MergeEntity(firstRow, lastRow, MERGER_MANAGER_BEGIN_INDEX, MERGER_MANAGER_END_INDEX));
            list.add(new MergeEntity(firstRow, lastRow, MERGER_REMARK_BEGIN_INDEX, MERGER_REMARK_END_INDEX));
            //进行设备合并的处理
            Map<String, List<MaintenanceExportItemData>> equipmentMap = new LinkedHashMap<>();
            values.forEach(equip -> {
                if (equipmentMap.containsKey(equip.getEquipmentPkId())) {
                    equipmentMap.get(equip.getEquipmentPkId()).add(equip);
                } else {
                    List<MaintenanceExportItemData> innerList = new ArrayList<>();
                    innerList.add(equip);
                    equipmentMap.put(equip.getEquipmentPkId(), innerList);
                }
            });
            //设备分组数据组装完成,进行合并单元格的处理
            AtomicInteger equipIndex = new AtomicInteger(beginIndex.get());
            equipmentMap.forEach((equipmentPkId, equipList) -> {
                int equipFirstRow = equipIndex.get();
                int equipLastRow = equipIndex.get() + equipList.size() - 1;
                list.add(new MergeEntity(equipFirstRow, equipLastRow, MERGER_EQUIPMENT_BEGIN_INDEX, MERGER_EQUIPMENT_END_INDEX));
                equipIndex.addAndGet(equipList.size());
            });
            beginIndex.addAndGet(values.size());
        });
        return list;
    }

    private List<MaintenanceEquipDataSaveParam> getDefaultItemDataList() {
        List<MaintenanceEquipDataSaveParam> list = new ArrayList<>();
        MaintenanceEquipDataSaveParam maintenanceEquipDataSaveParam = new MaintenanceEquipDataSaveParam();
        maintenanceEquipDataSaveParam.setEquipmentTypePkId("1");
        maintenanceEquipDataSaveParam.setEquipmentPkId("1");
        maintenanceEquipDataSaveParam.setEquipmentTypeName("测试系统");
        maintenanceEquipDataSaveParam.setEquipmentName("测试设备1");
        maintenanceEquipDataSaveParam.setEquipmentName("测试设备1");
        maintenanceEquipDataSaveParam.setItemDataVOS(getMaintenanceItemDataVO());
        MaintenanceEquipDataSaveParam maintenanceEquipDataSaveParam2 = new MaintenanceEquipDataSaveParam();
        maintenanceEquipDataSaveParam2.setEquipmentTypePkId("1");
        maintenanceEquipDataSaveParam2.setEquipmentPkId("2");
        maintenanceEquipDataSaveParam2.setEquipmentTypeName("测试系统");
        maintenanceEquipDataSaveParam2.setEquipmentName("测试设备2");
        maintenanceEquipDataSaveParam2.setItemDataVOS(getMaintenanceItemDataVO());
        MaintenanceEquipDataSaveParam maintenanceEquipDataSaveParam3 = new MaintenanceEquipDataSaveParam();
        maintenanceEquipDataSaveParam3.setEquipmentTypePkId("2");
        maintenanceEquipDataSaveParam3.setEquipmentPkId("3");
        maintenanceEquipDataSaveParam3.setEquipmentTypeName("测试系统");
        maintenanceEquipDataSaveParam3.setEquipmentName("测试设备2");
        maintenanceEquipDataSaveParam3.setItemDataVOS(getMaintenanceItemDataVO());
        MaintenanceEquipDataSaveParam maintenanceEquipDataSaveParam4 = new MaintenanceEquipDataSaveParam();
        maintenanceEquipDataSaveParam3.setEquipmentTypePkId("3");
        maintenanceEquipDataSaveParam4.setEquipmentPkId("4");
        maintenanceEquipDataSaveParam4.setEquipmentTypeName("测试系统");
        maintenanceEquipDataSaveParam4.setEquipmentName("测试设备2");
        maintenanceEquipDataSaveParam4.setItemDataVOS(getMaintenanceItemDataVO());
        list.add(maintenanceEquipDataSaveParam);
        list.add(maintenanceEquipDataSaveParam2);
        list.add(maintenanceEquipDataSaveParam3);
        list.add(maintenanceEquipDataSaveParam4);
        return list;
    }

    private List<MaintenanceItemDataVO> getMaintenanceItemDataVO() {
        List<MaintenanceItemDataVO> list = new ArrayList<>();
        MaintenanceItemDataVO maintenanceItemDataVO = new MaintenanceItemDataVO();
        maintenanceItemDataVO.setItemName("测试项目1");
        maintenanceItemDataVO.setRange("100~200");
        maintenanceItemDataVO.setValues(getValues());
        MaintenanceItemDataVO maintenanceItemDataVO2 = new MaintenanceItemDataVO();
        maintenanceItemDataVO2.setItemName("测试项目1");
        maintenanceItemDataVO2.setRange("100~200");
        maintenanceItemDataVO2.setValues(getValues());
        list.add(maintenanceItemDataVO);
        list.add(maintenanceItemDataVO2);
        return list;
    }

    private List<String> getValues() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            list.add(String.valueOf(i * 50));
        }
        return list;
    }

    /**
     * 进行故障导出测试
     *
     * @param dataListMap
     */
    private int dealPhoneFaultMap(Map<String, Object> dataListMap) {
        MaintenancePhoneFaultVO maintenancePhoneFaultVO = new MaintenancePhoneFaultVO();
        maintenancePhoneFaultVO.setJxFaultCount(100);
        maintenancePhoneFaultVO.setHxFaultCount(300);
        maintenancePhoneFaultVO.setDqFaultCount(200);
        dataListMap.put("dqFaultCount", maintenancePhoneFaultVO.getDqFaultCount());
        dataListMap.put("jxFaultCount", maintenancePhoneFaultVO.getJxFaultCount());
        dataListMap.put("hxFaultCount", maintenancePhoneFaultVO.getHxFaultCount());
        List<MaintenanceExportFaultDetailVO> list = getMaintenanceExportFaultDetailVO("1");
        dataListMap.put("mapList", list);
        return list.size();
    }

    private List<MaintenanceExportFaultDetailVO> getMaintenanceExportFaultDetailVO(String index) {
        List<MaintenanceExportFaultDetailVO> detailVOS = new ArrayList<>();
        detailVOS.add(getMaintenanceExportFaultDetailVO(1, "心态裂了" + index));
        detailVOS.add(getMaintenanceExportFaultDetailVO(2, "心态裂了" + index));
        detailVOS.add(getMaintenanceExportFaultDetailVO(3, "心态裂了" + index));
        detailVOS.add(getMaintenanceExportFaultDetailVO(4, "心态裂了" + index));
        detailVOS.add(getMaintenanceExportFaultDetailVO(5, "心态裂了" + index));
        detailVOS.add(getMaintenanceExportFaultDetailVO(6, "心态裂了" + index));
        detailVOS.add(getMaintenanceExportFaultDetailVO(7, "心态裂了" + index));
        detailVOS.add(getMaintenanceExportFaultDetailVO(8, "心态裂了" + index));
        detailVOS.add(getMaintenanceExportFaultDetailVO(9, "心态裂了" + index));
        detailVOS.add(getMaintenanceExportFaultDetailVO(10, "心态裂了" + index));
        detailVOS.add(getMaintenanceExportFaultDetailVO(11, "心态裂了" + index));
        return detailVOS;
    }

    private MaintenanceExportFaultDetailVO getMaintenanceExportFaultDetailVO(Integer index, String name) {
        MaintenanceExportFaultDetailVO maintenanceExportFaultDetailVO1 = new MaintenanceExportFaultDetailVO();
        maintenanceExportFaultDetailVO1.setIndex(index);
        maintenanceExportFaultDetailVO1.setFaultSolution("破镜重圆");
        maintenanceExportFaultDetailVO1.setAreaName("神秘地点");
        maintenanceExportFaultDetailVO1.setFaultDesc(name);
        maintenanceExportFaultDetailVO1.setStockDepName("化学课" + index);
        maintenanceExportFaultDetailVO1.setNoEndStatus("✔");
        maintenanceExportFaultDetailVO1.setReportDate("2023-1-1 03:50:55");
        maintenanceExportFaultDetailVO1.setCompleteTime("2023-1-1 03:50:55");
        maintenanceExportFaultDetailVO1.setHandleTime("2023-1-1 03:50:55");
        maintenanceExportFaultDetailVO1.setHandler("小王");
        maintenanceExportFaultDetailVO1.setReportUnit("2222");
        maintenanceExportFaultDetailVO1.setReportUser("小王");
        maintenanceExportFaultDetailVO1.setReportUserPhone("16626406950");
        maintenanceExportFaultDetailVO1.setReceiver("小王2");
        return maintenanceExportFaultDetailVO1;
    }


    private int dealFactoryFaultMap(Map<String, Object> dataListMap) {
        MaintenanceFactoryFaultVO maintenanceFactoryFaultVO = new MaintenanceFactoryFaultVO();
        maintenanceFactoryFaultVO.setJxMonthCount(100);
        maintenanceFactoryFaultVO.setJxDayCompleteCount(20);
        maintenanceFactoryFaultVO.setDqDayCompleteCount(200);
        maintenanceFactoryFaultVO.setDqMonthCount(40);
        maintenanceFactoryFaultVO.setHxMonthCount(400);
        maintenanceFactoryFaultVO.setHxDayCompleteCount(80);
        dataListMap.put("dqDayCompleteCount", maintenanceFactoryFaultVO.getDqDayCompleteCount());
        dataListMap.put("dqMonthCount", maintenanceFactoryFaultVO.getDqMonthCount());
        dataListMap.put("jxDayCompleteCount", maintenanceFactoryFaultVO.getJxDayCompleteCount());
        dataListMap.put("jxMonthCount", maintenanceFactoryFaultVO.getJxMonthCount());
        dataListMap.put("hxDayCompleteCount", maintenanceFactoryFaultVO.getHxDayCompleteCount());
        dataListMap.put("hxMonthCount", maintenanceFactoryFaultVO.getHxMonthCount());
        List<MaintenanceExportFaultDetailVO> mapList2 = getMaintenanceExportFaultDetailVO("2");
        List<MaintenanceExportFaultDetailVO> mapList3 = getMaintenanceExportFaultDetailVO("3");
        List<MaintenanceExportFaultDetailVO> mapList4 = getMaintenanceExportFaultDetailVO("4");
        dataListMap.put("mapList2", mapList2);
        dataListMap.put("mapList3", mapList3);
        dataListMap.put("mapList4", mapList4);
        return mapList2.size() + mapList3.size() + mapList4.size();
    }

    private List<MaintenanceExportItemData> dealImportanceData(Map<String, Object> dataListMap, List<MaintenanceEquipDataSaveParam> saveParams) {
        List<MaintenanceExportItemData> list = new ArrayList<>();
        saveParams.forEach(item -> {
            item.getItemDataVOS().forEach(innerItem -> {
                MaintenanceExportItemData maintenanceExportItemData = new MaintenanceExportItemData();
                maintenanceExportItemData.setEquipmentTypePkId(item.getEquipmentTypePkId());
                maintenanceExportItemData.setEquipmentTypeName(item.getEquipmentTypeName());
                maintenanceExportItemData.setEquipmentPkId(item.getEquipmentPkId());
                maintenanceExportItemData.setEquipmentName(item.getEquipmentName());
                maintenanceExportItemData.setItemName(innerItem.getItemName());
                maintenanceExportItemData.setUnit(innerItem.getUnit());
                maintenanceExportItemData.setRange(innerItem.getRange());
                maintenanceExportItemData.setManager(item.getManager());
                maintenanceExportItemData.setRemark(item.getRemark());
                maintenanceExportItemData.setValue1(innerItem.getValues().get(0));
                maintenanceExportItemData.setValue2(innerItem.getValues().get(1));
                maintenanceExportItemData.setValue3(innerItem.getValues().get(2));
                maintenanceExportItemData.setValue4(innerItem.getValues().get(3));
                maintenanceExportItemData.setValue5(innerItem.getValues().get(4));
                maintenanceExportItemData.setValue6(innerItem.getValues().get(5));
                maintenanceExportItemData.setValue7(innerItem.getValues().get(6));
                maintenanceExportItemData.setValue8(innerItem.getValues().get(7));
                maintenanceExportItemData.setValue9(innerItem.getValues().get(8));
                maintenanceExportItemData.setValue10(innerItem.getValues().get(9));
                maintenanceExportItemData.setValue11(innerItem.getValues().get(10));
                maintenanceExportItemData.setValue12(innerItem.getValues().get(11));
                maintenanceExportItemData.setValue13(innerItem.getValues().get(12));
                list.add(maintenanceExportItemData);
            });
        });
        dataListMap.put("mapList5", list);
        return list;
    }

}

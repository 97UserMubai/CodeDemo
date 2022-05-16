package export;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.poi.word.WordUtil;
import com.code.entity.freemarker.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @name: FreemarkerExport
 * @author: mubai.
 * @date: 2022/5/10
 * @version: 1.0
 * @description:
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = DcCompanyManageApplication.class)
public class FreemarkerExport {

    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(WordUtil.class, "/template/export");
        return configuration;
    }

    @Test
    public void exportWord() {
        try {
            Configuration configuration = getConfiguration();
            Template template = configuration.getTemplate("carbon_export2.ftl");
            File out = new File("D:\\export\\carbon_export_" + System.currentTimeMillis() + ".doc");
            Writer bufferWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), "utf-8"));
            Map<String, Object> params = new HashMap<>();
            //todo 这个位置需要注意，当bean对象的内容为Null时会导致文件损坏，所以需要有一个默认值
            CompanyDetailVO companyDetailVO = new CompanyDetailVO();
            companyDetailVO.setCompanyName("测试名称");
            companyDetailVO.setOrgCode("机构好1234123");
            companyDetailVO.setRegion("广东省珠海市香洲区");
            companyDetailVO.setAddress("诚丰嘉座913");
            companyDetailVO.setIndustryPkId("这是一个很大的行业");
            companyDetailVO.setLegalPerson("崖 is 法人");
            companyDetailVO.setLegalPersonPhone("123456");
            companyDetailVO.setCarbonLeader("Mr.王");
            companyDetailVO.setCarbonLeaderPhone("1365485222");
            companyDetailVO.setCarbonLeaderPosition("二氧化碳负责人");
            companyDetailVO.setYear("2022年");
            companyDetailVO.setDateRange("2022年1月1日至2022年12月31日");
            params.put("companyDetail", companyDetailVO);
            //进行第二步：核算边界数据的导出
            BoundaryExportVO boundaryVO = new BoundaryExportVO();
            boundaryVO.setUnitNum(2);
            boundaryVO.setUnitFullName("派诺科技园1期（公共建筑运营），派诺科技园2期（公共建筑运营）");
            boundaryVO.setEmissionFullName("直接排放");
            boundaryVO.setDirectSourceFullName("天然气，汽油");
            boundaryVO.setIndirectSourceFullName("");
            params.put("boundary", boundaryVO);
            params.put("nodes", getExportNodes());
            List<ExportFactorNodeVo> factorNodeVos = new ArrayList<>();
            factorNodeVos.add(getFactorNodeVos("1"));
            factorNodeVos.add(getFactorNodeVos("2"));
            params.put("factorNodes", factorNodeVos);
            template.process(params, bufferWriter);
        } catch (Exception e) {
            System.out.println("发生异常");
            e.printStackTrace();
        }
    }


    private ExportFactorNodeVo getFactorNodeVos(String level) {
        ExportFactorNodeVo nodeVo1 = new ExportFactorNodeVo();
        nodeVo1.setUnitFullName(String.format("派诺科技园%s期-公共建筑运营行业(Test)", level));
        List<ExportFactorEmissionNodeVo> emissionNodeVos = new ArrayList<>();
        ExportFactorEmissionNodeVo emissionNodeVo = new ExportFactorEmissionNodeVo();
        emissionNodeVo.setEmissionFullName("直接排放活动水平因子(Test)");
        List<ExportFactorDetailNodeVo> directDetailNodes = new ArrayList<>();
        ExportFactorDetailNodeVo detailNodeVo1 = new ExportFactorDetailNodeVo();
        detailNodeVo1.setActivityTypeName("化石燃料燃烧排放(TEST)");
        directDetailNodes.add(detailNodeVo1);
        emissionNodeVo.setDetailVos(directDetailNodes);
        emissionNodeVos.add(emissionNodeVo);
        nodeVo1.setEmissionNodeVos(emissionNodeVos);
        return nodeVo1;
    }

    private List<ExportNodeVo> getExportNodes() {
        List<ExportNodeVo> nodeVos = new ArrayList<>();
        ExportNodeVo nodeVo = new ExportNodeVo();
        //第三层级需要合并
        nodeVo.setMergeType("1");
        nodeVo.setMergeLevel("3");
        nodeVo.setUnitName("派诺科技园1期");
        nodeVo.setIndustryName("公共建筑运营1");
        nodeVo.setEmissionName("直接排放");
        nodeVo.setActivityTypeName("化石燃料燃烧排放");
        nodeVo.setSourceName("天然气");
        nodeVo.setCellName("自备电厂");
        nodeVo.setDeviceName("设备1号");
        ExportNodeVo nodeVo2 = new ExportNodeVo();
        BeanUtil.copyProperties(nodeVo, nodeVo2);
        nodeVo2.setSourceName("柴油");
        nodeVo2.setCellName("");
        nodeVo2.setDeviceName("");
        //需要合并的第二层级
        nodeVo2.setMergeType("2");
        nodeVo2.setMergeLevel("3");
        nodeVos.add(nodeVo);
        nodeVos.add(nodeVo2);

        //单元二测试数据
        ExportNodeVo nodeVo3 = new ExportNodeVo();
        //第三层级需要合并
        nodeVo3.setMergeType("3");
        nodeVo3.setMergeLevel("1");
        nodeVo3.setUnitName("派诺科技园2期");
        nodeVo3.setIndustryName("公共建筑运营2");
        nodeVo3.setEmissionName("间接排放");
        nodeVo3.setActivityTypeName("外购电力");
        nodeVo3.setSourceName("电力");
        nodeVo3.setCellName("二楼");
        nodeVo3.setDeviceName("空调");
        nodeVos.add(nodeVo3);
        return nodeVos;
    }

    /**
     * 获取基础单元树结构核算节点数据
     */
    private List<ExportUnitNodeVo> getBaseNodes() {
        List<ExportUnitNodeVo> unitNodes = new ArrayList<>();
        //单元层
        ExportUnitNodeVo unitNodeVo1 = new ExportUnitNodeVo();
        unitNodeVo1.setUnitName("派诺科技园1期");
        unitNodeVo1.setIndustryName("公共建筑运营1");
        //直接排放
        List<ExportActivityNodeVo> directActivityNodes = new ArrayList<>();
        //排放类型-化石燃料
        ExportActivityNodeVo activityNodeVo1 = new ExportActivityNodeVo();
        activityNodeVo1.setActivityTypeName("化石燃料燃烧排放");
        //核算叶子节点
        List<ExportEndNodeVo> endNodeVos = new ArrayList<>();
        ExportEndNodeVo endNodeVo1 = new ExportEndNodeVo();
        endNodeVo1.setSourceName("天然气");
        endNodeVo1.setCellName("自备电厂");
        endNodeVo1.setDeviceName("");
        endNodeVos.add(endNodeVo1);
        ExportEndNodeVo endNodeVo2 = new ExportEndNodeVo();
        endNodeVo2.setSourceName("汽油");
        endNodeVo2.setCellName("");
        endNodeVo2.setDeviceName("");
        endNodeVos.add(endNodeVo2);
        activityNodeVo1.setEndNodes(endNodeVos);
        directActivityNodes.add(activityNodeVo1);
        //排放类型-其他燃料
        ExportActivityNodeVo activityNodeVo2 = new ExportActivityNodeVo();
        activityNodeVo2.setActivityTypeName("其他燃料");
        //核算叶子节点
        List<ExportEndNodeVo> endNodeVos2 = new ArrayList<>();
        ExportEndNodeVo endNodeVo3 = new ExportEndNodeVo();
        endNodeVo3.setSourceName("其他1");
        endNodeVo3.setCellName("");
        endNodeVo3.setDeviceName("");
        endNodeVos2.add(endNodeVo3);
        ExportEndNodeVo endNodeVo4 = new ExportEndNodeVo();
        endNodeVo4.setSourceName("其它2");
        endNodeVo4.setCellName("");
        endNodeVo4.setDeviceName("");
        endNodeVos2.add(endNodeVo4);
        activityNodeVo2.setEndNodes(endNodeVos2);
        directActivityNodes.add(activityNodeVo2);
        unitNodeVo1.setDirectEmissionNodes(directActivityNodes);

        //间接排放
        List<ExportActivityNodeVo> indirectActivityNodes = new ArrayList<>();
        //排放类型-其他燃料
        ExportActivityNodeVo activityNodeVo3 = new ExportActivityNodeVo();
        activityNodeVo3.setActivityTypeName("净购电力");
        //核算叶子节点
        List<ExportEndNodeVo> endNodeVos3 = new ArrayList<>();
        ExportEndNodeVo endNodeVo5 = new ExportEndNodeVo();
        endNodeVo5.setSourceName("电力");
        endNodeVo5.setCellName("");
        endNodeVo5.setDeviceName("");
        endNodeVos3.add(endNodeVo3);
        activityNodeVo3.setEndNodes(endNodeVos3);
        indirectActivityNodes.add(activityNodeVo3);
        unitNodeVo1.setIndirectEmissionNodes(indirectActivityNodes);
        unitNodes.add(unitNodeVo1);


//        //单元2-只配置间接排放
//        ExportUnitNodeVo unitNodeVo2 = new ExportUnitNodeVo();
//        unitNodeVo1.setUnitName("派诺科技园2期");
//        unitNodeVo1.setIndustryName("公共建筑运营2");
//        //间接排放
//        List<ExportActivityNodeVo> indirectActivityNodes2 = new ArrayList<>();
//        //排放类型-其他燃料
//        ExportActivityNodeVo activityNodeVo4 = new ExportActivityNodeVo();
//        activityNodeVo4.setActivityTypeName("净购热力");
//        //核算叶子节点
//        List<ExportEndNodeVo> endNodeVos4 = new ArrayList<>();
//        ExportEndNodeVo endNodeVo6 = new ExportEndNodeVo();
//        endNodeVo6.setSourceName("热力");
//        endNodeVo6.setCellName("哈哈");
//        endNodeVo6.setDeviceName("设备测试");
//        endNodeVos4.add(endNodeVo6);
//        activityNodeVo4.setEndNodes(endNodeVos4);
//        indirectActivityNodes2.add(activityNodeVo3);
//        unitNodeVo2.setIndirectEmissionNodes(indirectActivityNodes2);
//        unitNodes.add(unitNodeVo2);

        return unitNodes;
    }

}

package designPattern;

import designPattern.builderPattern.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>建造者模式</h>
 * @Date 2021/4/29
 **/
public class BuilderPatternTest {
    @Test
    public void test() {
        //准备数据
        ExportHeaderModel header = new ExportHeaderModel();
        header.setDepId("王老板公司");
        header.setExportDate("2021-04-29");

        Map<String, List<ExportDataModel>> bodyData = new HashMap<String, List<ExportDataModel>>();
        List<ExportDataModel> dataModels = new ArrayList<ExportDataModel>();
        dataModels.add(ExportDataModel.builder().productId("狗子产品一号").price(1000.00).amount(100.0)
                .build());
        dataModels.add(ExportDataModel.builder().productId("狗子产品二号").price(2000.0).amount(200.0)
                .build());
        dataModels.add(ExportDataModel.builder().productId("狗子产品三号").price(3000.00).amount(300.0)
                .build());
        bodyData.put("年度统计", dataModels);

        ExportFooterModel footer = new ExportFooterModel();
        footer.setExportUser("王狗子");

        //将需求的生成器子类通过construct方法入口进行构建
        TxtBuilder txtBuilder = new TxtBuilder();
        Director director = new Director(txtBuilder);
        director.construct(header, bodyData, footer);
        //director只是做了中转，具体的结果还是需要通过实际的生成器实现类返回
        System.out.println(txtBuilder.getResult().toString());

        XmlBuilder xmlBuilder = new XmlBuilder();
        director = new Director(xmlBuilder);
        director.construct(header, bodyData, footer);
        System.out.println(xmlBuilder.getResult().toString());

    }
}

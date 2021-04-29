package designPattern.builderPattern;

import java.util.List;
import java.util.Map;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>xml builder</h>
 * @Date 2021/4/29
 **/
public class XmlBuilder implements Builder {

    private final StringBuffer buffer = new StringBuffer();

    public void buildHeader(ExportHeaderModel exportHeaderModel) {
        buffer.append("<?xml version='1.0' encoding='UTF-8'?>\n");
        buffer.append("<Report>\n");
        buffer.append("\t<Header>\n");
        buffer.append("\t\t<DepId>").append(exportHeaderModel.getDepId()).append("</DepId>\n");
        buffer.append("\t\t<ExportDate>").append(exportHeaderModel.getExportDate())
                .append("</ExportDate>\n");
        buffer.append("\t</Header>\n");
    }

    public void buildBody(Map<String, List<ExportDataModel>> mapData) {
        buffer.append("\t<Body>\n");
        for (String tablName : mapData.keySet()) {
            buffer.append("\t\t<Datas TableName=\"").append(tablName).append("\">\n");
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tablName)) {
                buffer.append("\t\t\t<Data>\n");
                buffer.append("\t\t\t\t<ProductId>").append(edm.getProductId()).append("</ProductId>\n");
                buffer.append("\t\t\t\t<Price>").append(edm.getPrice()).append("</Price>\n");
                buffer.append("\t\t\t\t<Amount>").append(edm.getAmount()).append("</Amount>\n");
                buffer.append("\t\t\t</Data>\n");
            }
            buffer.append("\t\t</Datas>\n");
        }
        buffer.append("\t</Body>\n");
    }

    public void buildFooter(ExportFooterModel exportFooterModel) {
        buffer.append("\t<Footer>\n");
        buffer.append("\t\t<ExportUser>").append(exportFooterModel.getExportUser()).append("</ExportUser>\n");
        buffer.append("\t</Footer>\n");
        buffer.append("</Report>\n");
    }

    public StringBuffer getResult() {
        return buffer;
    }

}

package designPattern.builderPattern;

import java.util.List;
import java.util.Map;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>txt文件生成器</h>
 * @Date 2021/4/29
 **/
public class TxtBuilder implements Builder {
    /**
     * 定义一个承载结果的容器
     * 在其他场景中可以是复杂的产品VO对象等
     */
    private final StringBuffer buffer = new StringBuffer();

    public void buildHeader(ExportHeaderModel exportHeaderModel) {
        buffer.append(exportHeaderModel.getDepId()).append(",")
                .append(exportHeaderModel.getExportDate()).append("\n");
    }

    public void buildBody(Map<String, List<ExportDataModel>> mapData) {
        for (String keyName : mapData.keySet()) {
            buffer.append(keyName).append("\n");
            for (ExportDataModel data : mapData.get(keyName)) {
                buffer.append(data.getProductId()).append(",").append(data.getPrice()).append(",")
                        .append(data.getAmount()).append("\n");
            }
        }
    }

    public void buildFooter(ExportFooterModel exportFooterModel) {
        buffer.append(exportFooterModel.getExportUser());
    }

    public StringBuffer getResult() {
        return buffer;
    }
}

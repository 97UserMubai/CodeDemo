package designPattern.builderPattern;

import java.util.List;
import java.util.Map;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h></h>
 * @Date 2021/4/29
 **/
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(ExportHeaderModel header, Map<String, List<ExportDataModel>> body,
                          ExportFooterModel footer) {
        builder.buildHeader(header);
        builder.buildBody(body);
        builder.buildFooter(footer);
    }
}

package designPattern.builderPattern;

import java.util.List;
import java.util.Map;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>生成器接口</h>
 * <pre>
 *     生成器模式的主要功能是构建复杂的产品，而且是细化的，分步骤的构建产品，
 *     也就是生成器模式重在一步一步解决构造复杂对象的问题。如果仅仅这么认知生成器模式的功能是不够的。
 *     更为重要的是，这个构建的过程是统一的、固定不变的，变化的部分放到生成器部分了，只要配置不同的生成器，
 *     那么同样的构建过程，就能构建出不同的产品来。
 * </pre>
 * @Date 2021/4/29
 **/
public interface Builder {

    void buildHeader(ExportHeaderModel exportHeaderModel);

    void buildBody(Map<String, List<ExportDataModel>> mapData);

    void buildFooter(ExportFooterModel exportFooterModel);
}

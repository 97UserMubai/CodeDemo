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

    /**
     * 通过构造器进行对应的生成器子类对象的注入
     */
    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 在direct中进行生成器方法调用，可以自由组合，在实际生产中，这部分代码的接口为了符合开闭原则，只增加不改
     * 这里基本都是用void方法，将对象具体的构建委托给生成器的实现类
     */
    public void construct(ExportHeaderModel header, Map<String, List<ExportDataModel>> body,
                          ExportFooterModel footer) {
        builder.buildHeader(header);
        builder.buildBody(body);
        builder.buildFooter(footer);
    }
}

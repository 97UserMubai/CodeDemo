package designPattern.chainOfResponsibilityPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangbaitao
 * @version 1.0.0
 * @ClassName SumbitHandlerChain.java
 * @Description 责任链结果加工
 * @createTime 2021年05月06日 17:22:00
 */
public class SumbitHandlerChain {
    //对于责任链来说，必须是有序的处理，则使用列表集合来作为对象的容器
    private List<SumbitHandler> handlers = new ArrayList<SumbitHandler>();

    public void addHandler(SumbitHandler sumbitHandler) {
        this.handlers.add(sumbitHandler);
    }

    //创建process接口作为用户请求的入口，在初始化完成Handlers后，可以进行process方法的随意调用
    public String process(SumbitRequest request) {
        //遍历处理者
        StringBuilder stringBuilder = new StringBuilder();
        for (SumbitHandler handler : handlers) {
            Boolean result = handler.process(request);
            if (result != null) {
                //对结果进行加工
                return stringBuilder.append(request.getName()).append("提交报销申请，额度为：").append(request.getAmount())
                        .append(",审批人").append(handler.getClass().getSimpleName()).append(",审批结果")
                        .append(handler).append(result ? "同意" : "失败").toString();
            }
        }
        throw new RuntimeException("Could not handle request:" + request.toString());
    }
}

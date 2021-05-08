package designPattern.chainOfResponsibilityPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Classname AllSumbitHandlerChain
 * @Description
 * @Date 2021/5/8 15:42
 * @Created by mubai
 */
public class AllSumbitHandlerChain {
    private List<SumbitHandler> handlers = new ArrayList<>();

    public void addHandler(SumbitHandler sumbitHandler) {
        this.handlers.add(sumbitHandler);
    }

    /**
     * 全流程判断和加工
     */
    public String process(SumbitRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        AtomicBoolean continueState = new AtomicBoolean(true);
        handlers.forEach(handler -> {
            if (continueState.get()) {
                Boolean result = handler.process(request);
                if (result != null) {
                    //对结果进行加工
                    stringBuilder.append(request.getName()).append("提交报销申请，额度为：").append(request.getAmount())
                            .append(",审批人").append(handler.getClass().getSimpleName()).append(",审批结果:")
                            .append(result ? "同意" : "失败").append("\n");
                    //结果为false时结束审批流程
                    if (!result) {
                        continueState.getAndSet(false);
                    }
                }
            }
        });
        if (stringBuilder.length() > 0) {
            return stringBuilder.toString();
        }
        throw new RuntimeException("Could not handle request:" + request.toString());
    }

}

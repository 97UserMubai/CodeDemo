package designPattern.chainOfResponsibilityPattern;

/**
 * @author wangbaitao
 * @version 1.0.0
 * @ClassName SumbitHandler.java
 * @Description 责任链模式处理器
 * @createTime 2021年05月06日 17:06:00
 * <pre>
 *    该案例以某个节点审批通过直接则结束用户请求，在责任链的应用场景中还包含其他情况：
 *    ①拦截器(Interceptor)
 *    ②过滤器(Filter)
 *    上面的目的不是找到某个Handler来处理这个request，而是每个Handler都做一些工作，比如：
 *    记录日志，检查权限，进行资源加载(本地缓存)等
 * </pre>
 * <pre>
 *     当前案例为审批流程：
 *     ①经理可以审批100额度以下的报销
 *     ②主管可以审批100~1000额度的报销
 *     ③CEO可以审批1000额度以上的报销
 * </pre>
 */
public interface SumbitHandler {
    //这里必须使用包装类
    //在责任链模式中，handler接口返回true/false/null可以作为不同传递选择的判断
    Boolean process(SumbitRequest sumbitRequest);
}

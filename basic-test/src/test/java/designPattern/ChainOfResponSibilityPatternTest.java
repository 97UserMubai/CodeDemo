package designPattern;

import designPattern.chainOfResponsibilityPattern.*;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author wangbaitao
 * @version 1.0.0
 * @ClassName ChainOfResponSibilityPatternTest.java
 * @Description 责任链模式测试案例
 * @createTime 2021年05月06日 17:31:00
 */
public class ChainOfResponSibilityPatternTest {

    /**
     * 测试案例① ：
     * 当前模式为遇到一个可以处理的handler就会结束流程，返回处理结果
     */
    @Test
    public void test() {
        SumbitHandlerChain chain = new SumbitHandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());

        //请求
        System.out.println(chain.process(SumbitRequest.builder().name("wangbaitao").amount(new BigDecimal(99)).build()));
        System.out.println(chain.process(SumbitRequest.builder().name("wangbaitao").amount(new BigDecimal(199)).build()));
        System.out.println(chain.process(SumbitRequest.builder().name("wangbaitao").amount(new BigDecimal(1999)).build()));
        System.out.println(chain.process(SumbitRequest.builder().name("wangbaitao").amount(new BigDecimal(9999)).build()));
    }

    /**
     * 测试案例②：
     * 当前模式为所有审批者都必须审核，如果遇到某个审核失败的则直接结束
     */
    @Test
    public void test2(){
        AllSumbitHandlerChain chain = new AllSumbitHandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());

        //请求
        System.out.println(chain.process(SumbitRequest.builder().name("wangbaitao").amount(new BigDecimal(99)).build()));
        System.out.println(chain.process(SumbitRequest.builder().name("wangbaitao").amount(new BigDecimal(199)).build()));
        System.out.println(chain.process(SumbitRequest.builder().name("wangbaitao").amount(new BigDecimal(1999)).build()));
        System.out.println(chain.process(SumbitRequest.builder().name("wangbaitao").amount(new BigDecimal(9999)).build()));
    }


}

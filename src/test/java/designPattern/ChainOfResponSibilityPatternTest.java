package designPattern;

import designPattern.chainOfResponsibilityPattern.*;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author wangbaitao
 * @version 1.0.0
 * @ClassName ChainOfResponSibilityPatternTest.java
 * @Description
 * @createTime 2021年05月06日 17:31:00
 */
public class ChainOfResponSibilityPatternTest {

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


}

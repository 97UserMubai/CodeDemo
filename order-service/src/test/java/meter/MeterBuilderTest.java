package meter;

import com.code.OrderApplication;
import com.code.meter.MeterBuilder;
import com.code.meter.PageOperator;
import com.code.meter.ReplaceOperator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Classname MeterBuilderTest
 * @Description TODO
 * @Date 2022-8-1 15:43
 * @Created by mubai
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = OrderApplication.class)
//@AutoConfigureMockMvc
public class MeterBuilderTest {


    @Test
    public void testBuilder() {
        MeterBuilder meterBuilder = MeterBuilder.builder()
                .on("分页查询", new PageOperator<>())
                .on("换表操作", new ReplaceOperator<>())
                .execute();
        System.out.println("debug");
    }


}
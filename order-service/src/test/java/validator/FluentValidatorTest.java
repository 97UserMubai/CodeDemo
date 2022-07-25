package validator;

import com.code.OrderApplication;
import com.code.mapper.CommonMapper;
import com.code.validate.DbExistValidator;
import com.code.validate.FluentValidator;
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

import javax.annotation.Resource;

/**
 * @name: FluentValidatorTest
 * @author: mubai.
 * @date: 2022/7/25
 * @version: 1.0
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrderApplication.class)
@AutoConfigureMockMvc
public class FluentValidatorTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Resource
    private CommonMapper commonMapper;

    /**
     * 测试前初始化
     */
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testValidator() {
        String dbSql = "select count(1) from base_sys_login_user where `userPkId` = 'wy' and flag = 0";
        FluentValidator fluentValidator = FluentValidator.checkAll()
                .on(dbSql, new DbExistValidator<>(), key -> commonMapper.findExist(key))
                .doValidate();
        Object result = fluentValidator.getContext().getString(dbSql);
        System.out.println(result);
    }


}

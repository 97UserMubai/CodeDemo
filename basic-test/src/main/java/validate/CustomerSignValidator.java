package validate;

import org.springframework.stereotype.Component;
import validate.exception.ValidatorException;

import java.util.Random;

/**
 * @Classname CustomerSignValidator
 * @Description TODO
 * @Date 2022-7-23 16:49
 * @Created by mubai
 */
@Component
public class CustomerSignValidator implements Validator<String> {
    @Override
    public void validate(ValidatorContext context, String s) {
        Random random = new Random();
        if (random.nextInt() < random.nextInt()) {
            throw new ValidatorException("客户授权验证失败");
        }
        
        context.setAttributes("customerSign", "随机结果测试:" + random.nextInt());
    }
}

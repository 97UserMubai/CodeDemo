package validate;

/**
 * @Classname ValidatorElement
 * @Description 验证器的包装类
 * @Date 2022-7-23 15:14
 * @Created by mubai
 */
public class ValidatorElement {

    private Object target;

    private Validator validator;

    public ValidatorElement(Object target, Validator validator) {
        this.target = target;
        this.validator = validator;
    }

    public Object getTarget() {
        return target;
    }

    public Validator getValidator() {
        return validator;
    }
}

package validate;

import lombok.extern.slf4j.Slf4j;

/**
 * @Classname FluentValidator
 * @Description 链式调用验证器，一个基于Fluent-validator的简单实现
 * @Date 2022-7-23 14:44
 * @Created by mubai
 */
@Slf4j
public class FluentValidator {

    /**
     * 验证器链，惰性求值期间就是不断地改变这个链表，及时求值期间就是遍历链表依次执行验证
     */
    private ValidatorElementList validatorElementList = new ValidatorElementList();

    /**
     * 验证器上下文
     */
    private ValidatorContext context = new ValidatorContext();

    /**
     * 私有构造器，只能通过checkAll方法创建对象
     */
    private FluentValidator() {
    }

    /**
     * 创建FluentValidator对象
     *
     * @return FluentValidator对象
     */
    public static FluentValidator checkAll() {
        return new FluentValidator();
    }

    /**
     * 链式补充验证器对象
     *
     * @param validator 验证器对象
     * @param <T>       验证对象泛型
     * @return FluentValidator对象
     */
    public <T> FluentValidator on(Validator<T> validator) {
        validatorElementList.add(new ValidatorElement(null, validator));
        return this;
    }

    /**
     * 链式补充验证器对象
     *
     * @param t         验证目标对象
     * @param validator 验证器对象
     * @param <T>       验证对象泛型
     * @return FluentValidator对象
     */
    public <T> FluentValidator on(T t, Validator<T> validator) {
        validatorElementList.add(new ValidatorElement(t, validator));
        return this;
    }


    /**
     * 使用验证器验证指定对象，只有当condition为true时才做验证
     *
     * @param t         验证目标对象
     * @param validator 验证器对象
     * @param condition 是否需要验证
     * @param <T>       验证对象泛型
     * @return FluentValidator对象
     */
    public <T> FluentValidator on(T t, Validator<T> validator, boolean condition) {
        if (condition) {
            validatorElementList.add(new ValidatorElement(t, validator));
        }
        return this;
    }

    /**
     * 将键值放入上下文
     *
     * @param key   键
     * @param value 值
     * @return FluentValidator对象
     */
    public FluentValidator putContext(String key, Object value) {
        if (context == null) {
            context = new ValidatorContext();
        }
        context.setAttributes(key, value);
        return this;
    }

    /**
     * 获取上下文对象
     *
     * @return 上下文对象
     */
    public ValidatorContext getContext() {
        return context;
    }

    /**
     * 执行验证器链中的各个验证逻辑
     */
    public FluentValidator doValidate() {
        if (validatorElementList.isEmpty()) {
            log.info("Nothing need to validate");
            return null;
        }
        validatorElementList.getList().forEach(element -> {
            Object target = element.getTarget();
            Validator validator = element.getValidator();
            String validatorName = validator.getClass().getSimpleName();
            log.info("{} is running", validatorName);
            validator.validate(context, target);
        });
        return this;
    }


}

package validate;

/**
 * @Classname Validator
 * @Description 验证器对象，泛型T表示待验证的对象类型
 * @Date 2022-7-23 15:19
 * @Created by mubai
 */
public interface Validator<T> {
    /**
     * 执行验证，如果验证失败，则抛出ValidatorException异常
     *
     * @param context 验证上下文
     * @param t       待验证对象
     */
    void validate(ValidatorContext context, T t);

}

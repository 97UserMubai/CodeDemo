package validate;

/**
 * @Classname ValidatorTestMain
 * @Description TODO
 * @Date 2022-7-23 16:52
 * @Created by mubai
 */
public class ValidatorTestMain {
    public static void main(String[] args) {
        /*
         * 总结：
         * 1.fluentValidator对象可以通过链式将Validator的实现类进行链式追加，在doValidator可以支持是全量校验或者校验失败之后马上抛出对应的异常
         * 2.Context上下文是在fluentValidator中进行初始化的，不是全局单例的
         * 3.Context可以在doValidate中进行赋值，用于后续业务代码的处理
         * */
        FluentValidator fluentValidator = FluentValidator.checkAll()
                .on(new CustomerSignValidator())
                .doValidate();
        String result = fluentValidator.getContext().getString("customerSign");
        System.out.println(result);
    }
}

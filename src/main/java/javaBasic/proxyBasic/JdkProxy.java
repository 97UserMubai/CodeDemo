package javaBasic.proxyBasic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @name: JdkProxy
 * @author: mubai.
 * @date: 2021/12/31
 * @version: 1.0
 * @description: 通过实现InvocationHandler拦截器来生成一个实现代理接口的匿名类，本质上是将反射过程封装起来，用户只需要关系反射过程中要做的业务
 */
public class JdkProxy implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始");
        /*这个位置可以看到，一般反射的几个要素为： Constructor,Field,Method ，通过集成JDK动态代理的InvocationHandler方法之后，
        其定义的invoke方法帮我们忽略了这几个要素的创建过程
        因为多了一层处理的信息，所以我们便可以不再关心怎么去实现反射的动作，而需要将注意力放在invoke方法执行前后，你想额外处理的事情，例如：
        打日志，对入参进行记录，对出餐进行记录，对异常进行捕捉记录等*/
        System.out.println("JDK代理对象：" + proxy.getClass());
        System.out.println("JDK代理对象父类" + proxy.getClass().getSuperclass());
        if (method.getName().equals("addUser")) {
            args[1] = "我是被修改的密码";
        }
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理，监听结束");
        return result;
    }


    private Object getJDKProxy(Object targetObject) {
        this.target = targetObject;
        System.out.println(this.getClass());
        /*断点测试可以发现，targetObject.getClass().getInterfaces() 一般就是他implements的接口，这里得到的是UserManager/2的Class信息
         * 如果implement了多个接口，那么返回的就是Class数组
         * newProxyInstance(目标对象的loader加载器，目标对象的接口类信息，当前句柄)
         * */
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        //创建当前对象实例，调用getJDKProxy方法，进行代理目标的赋值，同时获取代理instance
        JdkProxy jdkProxy = new JdkProxy();
        //todo 这里返回的是UserManager对象
        UserManager userManager = (UserManager) jdkProxy.getJDKProxy(new UserManagerImpl());
        //这里可以发现getJDKProxy方法返回的object是 Proxy.newProxyInstance方法通过当前句柄代理得到的实例
        userManager.addUser("wbt", "wbt970326");
        //todo 这个位置使用impl实现类会报错，所以JDK动态代理只能用于接口?
//        UserManagerImpl userManager1 = (UserManagerImpl) jdkProxy.getJDKProxy(new UserManagerImpl());
//        userManager1.getUser("wbt");
    }
}

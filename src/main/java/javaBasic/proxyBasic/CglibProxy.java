package javaBasic.proxyBasic;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @name: CglibProxy
 * @author: mubai.
 * @date: 2021/12/31
 * @version: 1.0
 * @description:
 */
public class CglibProxy implements MethodInterceptor {
    private Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib动态代理，监听开始");
        System.out.println("代理对象：" + o.getClass());
        System.out.println("代理父类：" + o.getClass().getSuperclass());
        Object invoke = method.invoke(target, objects);
        System.out.println("Cglib动态代理，监听结束");
        return invoke;
    }

    public Object getCglibProxy(Object objectTarget) {
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public static void main(String[] args) {
        CglibProxy cglib = new CglibProxy();
        UserManager userManager = (UserManager) cglib.getCglibProxy(new UserManagerImpl());
        userManager.delUser("wbt");
        //todo 需要注意的是：这个位置获取impl实现类是不会报错的，在JDK动态代理中则会抛出异常
//        UserManagerImpl userManager2 = (UserManagerImpl) cglib.getCglibProxy(new UserManagerImpl());
//        userManager2.getUser("wbt");
    }
}

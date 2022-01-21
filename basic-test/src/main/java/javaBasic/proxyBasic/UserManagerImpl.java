package javaBasic.proxyBasic;

/**
 * @name: UserManagerImpl
 * @author: mubai.
 * @date: 2021/12/31
 * @version: 1.0
 * @description:
 */
public class UserManagerImpl implements UserManager,UserManager2 {

    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了addUser方法");
        System.out.println("传入参数为 userName :" + userName + ",password:" + password);
    }

    @Override
    public void delUser(String userName) {
        System.out.println("调用了delUser方法");
        System.out.println("传入参数为 userName" + userName);
    }

    @Override
    public void getUser(String userName) {
        System.out.println("调用了getUser方法");
        System.out.println("传入参数为 userName" + userName);
    }
}

package javaBasic.annotationBasic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname ReflectTest
 * @Description 反射基本类测试
 * @Date 2021/12/27 21:12
 * @Created by mubai
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("javaBasic.annotationBasic.User");
        Class c2 = Class.forName("javaBasic.annotationBasic.User");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        StaticA staticA = new StaticA();
        System.out.println(staticA.m);
    }

}

@AllArgsConstructor
@NoArgsConstructor
@Data
class User {
    private String name;
    private int id;
    private int age;
}


class StaticA {


   static {
       System.out.println("静态成员变量测试");
       m = 100;
   }

    static int m = 300;

   public StaticA(){
       System.out.println("构造器");
   }

}

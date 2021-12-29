package javaBasic.annotationBasic;

/**
 * @Classname AnnotationValueTest
 * @Description
 * @Date 2021/12/25 21:10
 * @Created by mubai
 */
public class AnnotationValueTest {
//    @MyInterface("这个注解的属性名称不是value所以不写会报错")
//    private void test01(){
//
//    }

    @MyInterface2("")
    public void test02() {

    }

//    @MyInterface3(1)
//    public void test03(){
//
//    }
}


//@interface MyInterface{
//    String noValue();
//}

@interface MyInterface2 {
    String value();
}

//@interface MyInterface3{
//    int noValue();
//}
package effectiveJava;

import com.alibaba.fastjson.JSON;
import effectiveJava.part2.AbstractFriend;
import effectiveJava.part2.CrazyFriend;
import effectiveJava.part2.GirlFriend;
import effectiveJava.part3.CaseInsensitiveString;
import effectiveJava.part3.ColorPoint;
import effectiveJava.part3.ColorPoint2;
import effectiveJava.part3.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AllPartTest
 * @Description TODO
 * @Date 2022-10-29 18:41
 * @Created by mubai
 */
public class AllPartTest {
    @Test
    public void testPart1GirlFriend() {
        GirlFriend girlFriend = new GirlFriend.Builder(18).high(170).weight(100).location("珠海湾仔中学").build();
        //girlFriend的参数都是私有的，所有输出是个空
        System.out.println(JSON.toJSONString(girlFriend));
    }

    @Test
    public void testPart1AbstractFriend() {
        CrazyFriend crazyFriend = new CrazyFriend.Builder(CrazyFriend.Size.SMALL)
                .addSex(AbstractFriend.Sex.BOY).addSex(AbstractFriend.Sex.GIRL).build();
        System.out.println(JSON.toJSON(crazyFriend));
    }

    @Test
    public void testPart2PointEquals() {
        Point point = new Point(1, 2);
        ColorPoint colorPoint = new ColorPoint(1, 2, "Green");
        //true
        System.out.println(point.equals(colorPoint));
        //false
        System.out.println(colorPoint.equals(point));
    }

    @Test
    public void testPart3PointEquals() {
        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(new CaseInsensitiveString("test"));
        String test = "test";
        //true
        System.out.println(list.contains(new CaseInsensitiveString("test")));
        //false
        System.out.println(list.contains(test));
    }

    @Test
    public void testPart3ColorPoint2() {
        Point point = new Point(1, 2);
        ColorPoint2 colorPoint = new ColorPoint2(1, 2, "Green");
        //true
        System.out.println(point.equals(colorPoint));
        //false
        System.out.println(colorPoint.equals(point));
    }

}

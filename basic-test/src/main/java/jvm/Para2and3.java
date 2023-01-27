package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Para23
 * @Description 测试堆内存OOM，JVM配置： -Xms20M -Xmx20M
 * @Date 2023-1-19 23:17
 * @Created by mubai
 */
public class Para2and3 {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}

package javaBasic.arrayBasic;

import java.util.Hashtable;
import java.util.Objects;

/**
 * @name: SpringDetector
 * @author: mubai.
 * @date: 2021/11/23
 * @version: 1.0
 * @description: 测试集合映射关系用通过Object作为key查询时，需要重写hashCode和equals方法才能在containKey方法中判断正确
 */
public class SpringDetector {
    static class Groundhog {
        int ghNumber;

        Groundhog(int n) {
            ghNumber = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Groundhog groundhog = (Groundhog) o;
            return ghNumber == groundhog.ghNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ghNumber);
        }
    }

    static class Prediction {
        boolean shadow = Math.random() > 0.5;

        public String toString() {
            if (shadow) {
                return "随机数大于0.5,大大大大大大";
            } else {
                return "随机数小于等于0.5,小小小小小小";
            }
        }
    }

    public static void main(String[] args) {
        Hashtable<Groundhog, Prediction> ht = new Hashtable<>();
        for (int i = 0; i < 10; i++) {
            ht.put(new Groundhog(i), new Prediction());
        }
        //创建一个Groundhog对象
        Groundhog gh = new Groundhog(3);
        /*
         * 这个位置存在的知识点：object作为集合的key，如果不重写hashCode和equals方法，那么containKeys将无法正确匹配
         */
        if (ht.containsKey(gh)) {
            System.out.println(ht.get(gh).toString());
        }
    }
}

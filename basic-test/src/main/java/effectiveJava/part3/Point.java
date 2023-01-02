package effectiveJava.part3;

import java.util.Objects;

/**
 * @Classname Point
 * @Description TODO
 * @Date 2022-11-1 21:31
 * @Created by mubai
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

package effectiveJava.part3;

/**
 * @Classname ColorPoint2
 * @Description TODO
 * @Date 2022-11-3 22:40
 * @Created by mubai
 */
public class ColorPoint2 {
    private final Point point;
    private final String color;

    public ColorPoint2(int x, int y, String color) {
        this.point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint2))
            return false;
        ColorPoint2 colorPoint2 = (ColorPoint2) o;
        return colorPoint2.point.equals(point) && colorPoint2.color.equals(color);
    }

}

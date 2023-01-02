package effectiveJava.part3;

import java.util.Objects;

/**
 * @Classname ColorPoint
 * @Description TODO
 * @Date 2022-11-2 21:04
 * @Created by mubai
 */
public class ColorPoint extends Point {

    private final String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}

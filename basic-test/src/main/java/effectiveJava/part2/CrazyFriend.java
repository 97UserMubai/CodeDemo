package effectiveJava.part2;

/**
 * @Classname CrazyFriend
 * @Description TODO
 * @Date 2022-10-30 11:21
 * @Created by mubai
 */
public class CrazyFriend extends AbstractFriend {

    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    //这个位置的
    public static class Builder extends AbstractFriend.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = size;
        }

        @Override
        public CrazyFriend build() {
            return new CrazyFriend(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    CrazyFriend(Builder builder) {
        super(builder);
        size = builder.size;
    }

}

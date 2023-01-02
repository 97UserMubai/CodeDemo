package exception;

/**
 * @Classname MyException
 * @Description TODO
 * @Date 2022-11-27 20:02
 * @Created by mubai
 */
public class MyException extends RuntimeException {

    private final String diyName;

    private final Integer index;

    public MyException(String message, String diyName, Integer index) {
        super(message);
        this.diyName = diyName;
        this.index = index;
    }

    public String getDiyMsg() {
        return this.diyName + index;
    }
}


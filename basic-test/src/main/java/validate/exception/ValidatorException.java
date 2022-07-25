package validate.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Classname ValidatorException
 * @Description TODO
 * @Date 2022-7-23 15:43
 * @Created by mubai
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ValidatorException extends RuntimeException {
    //异常码
    private String code;

    public ValidatorException() {
    }

    public ValidatorException(String message) {
        super(message);
    }
}

package effectiveJava.part3;

import java.util.Objects;

/**
 * @Classname CaseInsensitiveString
 * @Description TODO
 * @Date 2022-11-3 22:02
 * @Created by mubai
 */
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if( o instanceof  CaseInsensitiveString){
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString)o).s
            );
        }
        if( o instanceof  String)
            return s.equalsIgnoreCase((String) o);
        return false;
    }

}

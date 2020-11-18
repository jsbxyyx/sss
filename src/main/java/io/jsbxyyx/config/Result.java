package io.jsbxyyx.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jsbxyyx
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Result<T> {

    public static final int SUCCESS = 1;
    public static final int ERROR = -1;

    private int c;
    private String m;
    private T d;

    public static Result success() {
        return success(null);
    }

    public static <T> Result success(T d) {
        return build(SUCCESS, "success", d);
    }

    public static Result error() {
        return error(null);
    }

    public static Result error(String m) {
        return build(ERROR, m, null);
    }

    public static <T> Result build(int c, String m, T d) {
        Result result = new Result();
        result.setC(c);
        result.setM(m);
        result.setD(d);
        return result;
    }

}

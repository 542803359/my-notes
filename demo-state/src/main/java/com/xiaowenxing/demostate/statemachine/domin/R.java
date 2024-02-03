
package com.xiaowenxing.demostate.statemachine.domin;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * 响应信息主体
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 1;
    public static final String SUCCESS_MSG = "success";
    /**
     * 失败标记
     */
    public static final int FAIL = 500;

    @Getter
    @Setter
    private Integer code;

    /**
     * 错误类型：对应i18n文件错误类型
     */
    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private T data;

    public static <T> R<T> ok() {
        return new R<>(SUCCESS, null, SUCCESS_MSG, null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(SUCCESS, null, SUCCESS_MSG, data);
    }

    public static <T> R<T> fail(Integer code, String type, String msg) {
        return new R<>(code, type, msg, null);
    }

    public static <T> R<T> fail(Integer code, String msg) {
        return new R<>(code, null, msg, null);
    }
}

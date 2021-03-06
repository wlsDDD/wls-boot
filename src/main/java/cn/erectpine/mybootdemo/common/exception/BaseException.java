package cn.erectpine.mybootdemo.common.exception;

import cn.erectpine.mybootdemo.common.enums.CodeMsgEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常基类
 *
 * @Author wls
 * @Date 2021/1/13 14:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 所属模块
     */
    private String module;
    
    /**
     * 错误码
     */
    private Integer code;
    
    
    /**
     * 构造方法-带code
     *
     * @param codeMsgEnum {@link CodeMsgEnum}
     */
    public BaseException(CodeMsgEnum codeMsgEnum) {
        super(codeMsgEnum.getMsg());
        this.code = codeMsgEnum.getCode();
    }
    
    /**
     * 构造方法-带code和module
     *
     * @param codeMsgEnum {@link CodeMsgEnum}
     * @param module      module
     */
    public BaseException(CodeMsgEnum codeMsgEnum, String module) {
        super(codeMsgEnum.getMsg());
        this.code = codeMsgEnum.getCode();
        this.module = module;
    }
    
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public BaseException() {
        super();
    }
    
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BaseException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this runtime exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     * @since 1.4
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs a new runtime exception with the specified cause and a
     * detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for runtime exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A <tt>null</tt> value is
     *              permitted, and indicates that the cause is nonexistent or
     *              unknown.)
     * @since 1.4
     */
    public BaseException(Throwable cause) {
        super(cause);
    }
    
    /**
     * Constructs a new runtime exception with the specified detail
     * message, cause, suppression enabled or disabled, and writable
     * stack trace enabled or disabled.
     *
     * @param message            the detail message.
     * @param cause              the cause.  (A {@code null} value is permitted,
     *                           and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression  whether or not suppression is enabled
     *                           or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     * @since 1.7
     */
    protected BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

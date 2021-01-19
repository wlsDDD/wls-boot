package cn.erectpine.mybootdemo.common.enums;


import cn.erectpine.mybootdemo.common.constant.HttpStatus;
import lombok.Getter;

/**
 * 异常枚举
 *
 * @author wls
 * @date 2021/01/13
 */
@Getter
public enum CodeMsgEnum {
    
    /**
     * 成功返回信息code&msg
     */
    SUCCESS(HttpStatus.SUCCESS, "success"),
    ERROR(HttpStatus.ERROR, "fail"),
    /**
     * 统一验证参数错误
     */
    ARG_ERROR(-1, "参数错误提示信息"),
    DATA_SAVE_ERROR(5001, "新增数据失败，请联系数据库管理员"),
    DATA_UPDATE_ERROR(5001, "修改数据失败，请联系数据库管理员"),
    DATA_DELETE_ERROR(5001, "删除数据失败，请联系数据库管理员"),
    ;
    
    
    private final Integer code;
    private       String  msg;
    
    
    CodeMsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public CodeMsgEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }
    
}

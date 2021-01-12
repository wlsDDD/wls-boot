package cn.erectpine.mybootdemo.common.web;


import cn.erectpine.mybootdemo.common.constant.HttpStatus;
import cn.hutool.core.bean.BeanUtil;

import java.util.HashMap;

/**
 * 操作消息提醒
 *
 * @author wls
 */
public class ResponseTemplate extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";
    /**
     * 返回内容
     */
    public static final String MSG_TAG  = "msg";
    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";


    /**
     * 初始化一个新创建的 ResponseTemplate 对象，使其表示一个空消息。
     */
    public ResponseTemplate() {
    }

    /**
     * 初始化一个新创建的 ResponseTemplate 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public ResponseTemplate(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 ResponseTemplate 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public ResponseTemplate(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (BeanUtil.isNotEmpty(data)) {
            super.put(DATA_TAG, data);
        }

    }

    @Override
    public ResponseTemplate put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ResponseTemplate success() {
        return ResponseTemplate.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static ResponseTemplate success(Object data) {
        return ResponseTemplate.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResponseTemplate success(String msg) {
        return ResponseTemplate.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResponseTemplate success(String msg, Object data) {
        return new ResponseTemplate(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 错误
     * 返回错误消息
     *
     * @return {@link ResponseTemplate}
     */
    public static ResponseTemplate error() {
        return ResponseTemplate.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResponseTemplate error(String msg) {
        return ResponseTemplate.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResponseTemplate error(String msg, Object data) {
        return new ResponseTemplate(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static ResponseTemplate error(int code, String msg) {
        return new ResponseTemplate(code, msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResponseTemplate error(int code, String msg, Object data) {
        return new ResponseTemplate(code, msg, data);
    }

}

package com.jiuhaox.foundation.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppErrorCode implements ErrorCode {
    ERR_UNKNOWN_ERROR("未知错误"),
    ERR_SYS_ERROR("系统错误"),
    ERR_PARAM_ERROR("参数错误"),
    ERR_NOT_FOUND_SERVICE("未找到服务或服务异常"),
    ERR_NET_BUSY("网络繁忙，请稍后重试"),
    ERR_BLOCK_REQUEST("系统繁忙，请稍后重试"),
    ERR_NOT_SUPPORTED("不支持的操作"),

    ERR_SIGN_ERROR("签名错误，无法完成请求"),
    ERR_REPEAT_REQUEST("请不要重复请求"),
    ERR_API_REQ_TIME_EXPIRE("接口调用已过期"),
    ERR_API_NOT_FOUND("接口未找到"),
    ERR_RPC_CALL_FAIL("远程调用失败"),

    ERR_DATA_FORMAT("发送数据格式错误"),
    ERR_JSON_DATA_FORMAT("错误的json数据格式"),
    ERR_DATA_PARSE_ERROR("数据解析异常，请稍后重试"),
    ERR_DATA_NOT_FOUND("数据不存在"),
    ERR_DATA_DELETE_FAIL("数据删除失败"),
    ERR_DATA_UPDATE_FAIL("数据更新失败"),
    ;

    private final String msg;
}

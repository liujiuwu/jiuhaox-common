package com.jiuhaox.boot.core.consts;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 公共常量
 *
 * @Author: liujiuwu
 */
public abstract class CommonConst {
    public static final Charset DEFAULT_CHARSET = Charset.forName(StandardCharsets.UTF_8.name());

    public static final String FMT_DATE_FULL = "yyyy-MM-dd HH:mm:ss";

    public static final String FMT_DATE = "yyyy-MM-dd";

    public static final String COMMA = ",";
    public static final String AMP = "&";
    public static final String EQ = "=";
    public static final String DOT = ".";
    public static final String SLASH = "/";
    public static final String UNDERLINE = "_";
    public static final String DASHED = "-";
    public static final String SEMICOLON = ";";

    public static final String SPRING_APPLICATION_NAME = "spring.application.name";

    /**
     * 请求中带的签名参数
     */
    public static final String SIGN = "sign";

    public static final String HEADER_CONTENT_TYPE = "content-type";

    /**
     * 客户端应用AppId
     */
    public static final String HEADER_APP_ID = "X-App-Id";

    /**
     * 用户登录token
     */
    public static final String HEADER_AUTH_TOKEN = "X-Auth-Token";

    /**
     * 时间戳，标识访问时间
     */
    public static final String HEADER_TIMESTAMP = "X-Timestamp";

    /**
     * 可取手机设备号，必须
     */
    public static final String HEADER_UNIQUELY_CODE = "X-Uniquely-Code";

    /**
     * 请求唯一码，必须
     */
    public static final String HEADER_NONCE = "X-Nonce";

    /**
     * 客户端终端类型
     */
    public static final String HEADER_CLIENT_TYPE = "X-Client-Type";

    /**
     * 客户端手机型号
     */
    public static final String HEADER_MOBILE_TYPE = "X-Mobile-Type";

    /**
     * 客户端App版本
     */
    public static final String HEADER_APP_VERSION = "X-App-Version";

    /**
     * 来源
     */
    public static final String HEADER_FROM = "X-From";

    /**
     * 返回给客户端的服务端时间
     */
    public static final String RESP_HEADER_SERVER_TIME = "X-Response-Server-Time";
}

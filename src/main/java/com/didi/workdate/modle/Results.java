package com.didi.workdate.modle;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Results<T> {

    private int code;

    private String msg;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int end;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Long total;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private T data;


    /**
     * success
     */
    public static Results success() {
        return builder()
                .code(Msg.SUCCESS.code)
                .msg(Msg.SUCCESS.value)
                .build();

    }

    public static Results success(final Object data) {
        return builder()
                .code(Msg.SUCCESS.code)
                .msg(Msg.SUCCESS.value)
                .data(data)
                .build();
    }

    public static Results success(String msg, final Object data) {
        return builder()
                .code(Msg.SUCCESS.code)
                .msg(msg)
                .data(data)
                .build();
    }

    public static Results success(String msg) {
        return builder()
                .code(Msg.SUCCESS.code)
                .msg(msg)
                .build();
    }



    /**
     * message
     */
    //自定义返回成功的code和msg
    public static Results message(int stat, String msg) {
        return builder()
                .code(stat)
                .msg(msg)
                .build();
    }

    //自定义返回成功的code和msg和data
    public static Results message(int stat, String msg, final Object data) {
        return builder()
                .code(stat)
                .msg(msg)
                .data(data)
                .build();
    }


    /**
     * invalid
     */
    public static Results error() {
        return builder()
                .code(Msg.INVALID.code)
                .msg(Msg.INVALID.value)
                .build();
    }

    public static Results error(final String msg) {
        return builder()
                .code(Msg.INVALID.code)
                .msg(msg)
                .build();
    }

    public static Results error(final Integer stat, final String msg) {
        return builder()
                .code(stat)
                .msg(msg)
                .build();
    }



    public enum Msg {
        //成功响应码
        SUCCESS(200, "success"),
        //失效，大多为程序未满足条件
        INVALID(500, "invalid");
        private int code;
        private String value;

        Msg(int code, String value) {
            this.code = code;
            this.value = value;
        }
    }

}

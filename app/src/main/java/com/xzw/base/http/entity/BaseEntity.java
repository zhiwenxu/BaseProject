package com.xzw.base.http.entity;

/**
 * Created by draven.xu on 17/12/22.
 */

public class BaseEntity<T> {
   private int code;
   private String message;
   private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

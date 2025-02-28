package com.example.firstjava.dto;

import java.time.LocalDateTime;

public class UserMessageRequestDto {
    private String msg;
    private LocalDateTime localDateTime;

    public UserMessageRequestDto() {
    }

    public UserMessageRequestDto(String msg, LocalDateTime localDateTime) {
        this.msg = msg;
        this.localDateTime = localDateTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}

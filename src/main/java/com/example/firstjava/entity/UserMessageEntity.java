package com.example.firstjava.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_messages")
public class UserMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message")
    private String msg;

    public UserMessageEntity() {
    }

    public UserMessageEntity(long id, String mgs) {
        this.id = id;
        this.msg = mgs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

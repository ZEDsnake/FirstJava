package com.example.firstjava.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_messages")
public class UserMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message")
    private String mgs;

    public UserMessageEntity() {
    }

    public UserMessageEntity(long id, String mgs) {
        this.id = id;
        this.mgs = mgs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMgs() {
        return mgs;
    }

    public void setMgs(String mgs) {
        this.mgs = mgs;
    }
}

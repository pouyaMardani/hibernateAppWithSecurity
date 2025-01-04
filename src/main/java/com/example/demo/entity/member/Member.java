package com.example.demo.entity.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;


@Getter
@Setter
@Entity
@Table(name="members")
public class Member {

    public Member() {
    }

    public Member(String id, String password, Boolean active) {
        this.userId = id;
        this.password = password;
        this.active = active;
    }

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

    @Formula("(select a.role from roles a where a.user_id = user_id)")
    public String access;

    @Override
    public String toString() {
        return "Member{" +
                "id='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}

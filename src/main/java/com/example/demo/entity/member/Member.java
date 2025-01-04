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

    public Member(Long id, String username, String password, Boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

    @Formula("(select a.role from roles a where a.user_id = id)")
    public String access;

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}

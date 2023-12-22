package com.gambunsa.gambunsaBackend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="members")
public class Members {

    @Id
    @Column(length = 50, nullable = false, unique = true)
    private String userId;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String birth;

    @Column(length = 255)
    private String address;

    @Column(length = 30)
    private String tel;

    @Column(length = 255)
    private String profile;
}



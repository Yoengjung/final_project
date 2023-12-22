package com.gambunsa.gambunsaBackend.model.dto;

import jakarta.persistence.Column;
import org.springframework.stereotype.Repository;

@Repository
public class idcheck {
    @Column
    private String userid;
    @Column
    private String password;
}

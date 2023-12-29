package com.gambunsa.gambunsaBackend.model.dto;

import jakarta.persistence.Column;
import org.springframework.stereotype.Repository;

@Repository
public class IdCheck {
    @Column
    private String userId;
    @Column
    private String password;
}

package com.gambunsa.gambunsaBackend.controller;


import com.gambunsa.gambunsaBackend.service.IdCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class IdCheckController {
    private final IdCheckService idCheckService;

    public IdCheckController(IdCheckService idCheckService) {
        this.idCheckService = idCheckService;
    }

    @GetMapping("/idCheck")
    public boolean checkUserId(@RequestParam String userId) {
        System.out.println(userId);
        return idCheckService.getUserByUserId(userId);
    }
}

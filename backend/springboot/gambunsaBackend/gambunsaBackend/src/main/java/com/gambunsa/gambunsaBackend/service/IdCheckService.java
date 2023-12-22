package com.gambunsa.gambunsaBackend.service;


import com.gambunsa.gambunsaBackend.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class IdCheckService {
    private final MemberRepository memberRepository;

    public IdCheckService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public boolean getUserByUserId(String userId) {
        return memberRepository.existsByUserId(userId);
    }
}

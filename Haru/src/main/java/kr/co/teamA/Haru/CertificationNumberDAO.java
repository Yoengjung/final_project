package kr.co.teamA.Haru;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@RequiredArgsConstructor
@Repository
public class CertificationNumberDAO {
    private final StringRedisTemplate stringRedisTemplate;

    public void saveCertificationNumber(String email, String authCode) {
        stringRedisTemplate.opsForValue().set(email, authCode, Duration.ofSeconds(300));
    }

    public String getCertificationNumber(String email) {
        return stringRedisTemplate.opsForValue().get(email);
    }

    public void deleteCertificationNumber(String email) {
        stringRedisTemplate.delete(email);
    }

    public boolean hasKey(String email) {
        return stringRedisTemplate.hasKey(email);
    }

}

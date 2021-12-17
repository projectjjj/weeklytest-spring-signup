package com.sparta.weeklytestspring.service;

import com.sparta.weeklytestspring.domain.User;
import com.sparta.weeklytestspring.dto.SignupRequestDto;
import com.sparta.weeklytestspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(SignupRequestDto requestDto) {
        String userid = requestDto.getUserid();
        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUserid(userid);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        String password = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(userid, password);
        userRepository.save(user);
    }
}

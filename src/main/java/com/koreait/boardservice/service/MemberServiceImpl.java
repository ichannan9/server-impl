package com.koreait.boardservice.service;

import com.koreait.boardservice.domain.Member;
import com.koreait.boardservice.dto.*;
import com.koreait.boardservice.mapper.MemberMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder encoder;
    @Value("${jwt.secret}") private String jwtSecret;
    @Value("${jwt.expiration}") private long jwtExp;

    public MemberServiceImpl(MemberMapper memberMapper, PasswordEncoder encoder) {
        this.memberMapper = memberMapper;
        this.encoder = encoder;
    }

    @Override
    public Member signup(SignupDTO dto) {
        String encoded = encoder.encode(dto.getPassword());
        Member m = new Member(null, dto.getUsername(), encoded, dto.getEmail());
        memberMapper.insertMember(m);
        return memberMapper.findById(m.getId());
    }

    @Override
    public LoginResponse login(LoginDTO dto) {
        Member m = memberMapper.findByUsername(dto.getUsername());
        if (m == null || !encoder.matches(dto.getPassword(), m.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = Jwts.builder()
                .setSubject(m.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExp))
                .signWith(SignatureAlgorithm.HS256, jwtSecret.getBytes())
                .compact();
        return new LoginResponse(token);
    }

    @Override
    public Member update(Long id, UpdateDTO dto) {
        String encoded = encoder.encode(dto.getPassword());
        Member m = new Member(id.intValue(), null, encoded, dto.getEmail());
        memberMapper.updateMember(m);
        return memberMapper.findById(id.intValue());
    }

    @Override
    public void delete(Long id) {
        memberMapper.deleteMember(new HashMap<>() {{ put("id", id.intValue()); }});
    }
}

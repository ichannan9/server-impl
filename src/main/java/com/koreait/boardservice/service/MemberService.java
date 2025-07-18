package com.koreait.boardservice.service;

import com.koreait.boardservice.domain.Member;
import com.koreait.boardservice.dto.LoginDTO;
import com.koreait.boardservice.dto.LoginResponse;
import com.koreait.boardservice.dto.SignupDTO;
import com.koreait.boardservice.dto.UpdateDTO;

public interface MemberService {
    Member signup(SignupDTO dto);
    LoginResponse login(LoginDTO dto);
    Member update(Long id, UpdateDTO dto);
    void delete(Long id);
}

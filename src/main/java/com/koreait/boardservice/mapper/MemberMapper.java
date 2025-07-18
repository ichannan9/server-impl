package com.koreait.boardservice.mapper;

import com.koreait.boardservice.domain.Member;
import java.util.Map;

public interface MemberMapper {
    void insertMember(Member m);
    Member findById(int id);
    Member findByUsername(String username);
    void updateMember(Member m);
    void deleteMember(Map<String,Integer> params);
}

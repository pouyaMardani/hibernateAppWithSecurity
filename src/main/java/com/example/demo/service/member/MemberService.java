package com.example.demo.service.member;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.member.Member;
import jakarta.transaction.Transactional;

import java.util.List;

public interface MemberService {

    @Transactional
    void save(String userId, String password);

    List<Member> findAll();
}

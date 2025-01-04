package com.example.demo.service.role;

import com.example.demo.entity.member.Member;
import com.example.demo.entity.role.Role;
import jakarta.transaction.Transactional;

public interface RoleService {

    @Transactional
    void save(Member member);

    Role findByUserId(Long userId,String access);
}

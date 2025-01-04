package com.example.demo.service.role;

import com.example.demo.entity.member.Member;
import jakarta.transaction.Transactional;

public interface RoleService {

    @Transactional
    void save(Member member);

}

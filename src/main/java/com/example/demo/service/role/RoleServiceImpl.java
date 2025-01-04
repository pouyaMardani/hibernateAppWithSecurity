package com.example.demo.service.role;

import com.example.demo.dao.member.MemberRepository;
import com.example.demo.dao.role.RoleRepository;
import com.example.demo.entity.member.Member;
import com.example.demo.entity.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

    }

    @Override
    public void save(Member userId) {

        Role role = new Role();
        role.setUserId(userId);
        role.setRole("ROLE_EMPLOYEE");
        roleRepository.save(role);
    }
}

package com.example.demo.service.role;

import com.example.demo.dao.member.MemberRepository;
import com.example.demo.dao.role.RoleRepository;
import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.member.Member;
import com.example.demo.entity.role.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    @Override
    @Transactional
    public Role findByUserId(Long userId,String access) {

        Role role = roleRepository.findRolesByUserId(userId);
        role.setRole(access);
        roleRepository.save(role);
        return role;
    }
}

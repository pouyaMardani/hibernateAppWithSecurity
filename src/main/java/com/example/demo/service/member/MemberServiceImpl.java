package com.example.demo.service.member;

import com.example.demo.dao.employee.EmployeeRepository;
import com.example.demo.dao.member.MemberRepository;
import com.example.demo.dao.role.RoleRepository;
import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.member.Member;
import com.example.demo.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberServiceImpl implements MemberService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    private RoleService roleService;
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository,RoleService roleService) {
        this.memberRepository = memberRepository;
        this.roleService = roleService;

    }

    @Override
    public void save(String username, String password) {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword("{bcrypt}"+passwordEncoder.encode(password));
        member.setActive(true);
        memberRepository.save(member);

        roleService.save(member);
    }

    @Override
    public List<Member> findAll() {
        List<Member> members =  memberRepository.findAll();
        return members;
    }
}

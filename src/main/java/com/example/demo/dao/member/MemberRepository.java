package com.example.demo.dao.member;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Integer> {




}

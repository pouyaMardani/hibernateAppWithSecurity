package com.example.demo.dao.role;

import com.example.demo.entity.member.Member;
import com.example.demo.entity.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role,Integer> {



    @Query("SELECT r FROM Role r WHERE r.userId.id = :userId")
    Role findRolesByUserId(@Param("userId") Long userId);

}

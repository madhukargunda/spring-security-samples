package com.study.pattern.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.study.pattern.security.domain.SecUserRole;

public interface SecUserRoleRespository extends CrudRepository<SecUserRole, Long> {

	@Query("select a.role from UserRole a, User b where b.userName=?1 and a.userid=b.userId")
    public List<String> findRoleByUserName(String username);
}

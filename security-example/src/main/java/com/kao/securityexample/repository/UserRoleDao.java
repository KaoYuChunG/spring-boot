package com.kao.securityexample.repository;

import com.xkcoding.rbac.security.model.UserRole;
import com.xkcoding.rbac.security.model.unionkey.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 用户角色 DAO
 * </p>
 *
 */
public interface UserRoleDao extends JpaRepository<UserRole, UserRoleKey>, JpaSpecificationExecutor<UserRole> {

}

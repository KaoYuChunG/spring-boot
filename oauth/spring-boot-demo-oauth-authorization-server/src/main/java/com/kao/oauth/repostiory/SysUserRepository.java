package com.kao.oauth.repostiory;

import com.kao.oauth.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 用户信息仓库.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    /**
     * 通过用户名查找用户.
     *
     * @param username 用户名
     * @return 结果
     */
    Optional<SysUser> findFirstByUsername(String username);

}

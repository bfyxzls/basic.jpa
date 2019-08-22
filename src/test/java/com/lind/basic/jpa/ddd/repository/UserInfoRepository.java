package com.lind.basic.jpa.ddd.repository;

import com.lind.basic.jpa.ddd.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户仓储.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}

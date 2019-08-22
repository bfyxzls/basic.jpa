package com.lind.basic.jpa.ddd.service;

import com.lind.basic.jpa.ddd.entity.UserInfo;

/**
 * 领域服务-用户模块.
 */
public interface UserService {

  /**
   * 注册.
   *
   * @param userInfo .
   */
  void register(UserInfo userInfo);

  /**
   * 获取.
   *
   * @param id .
   * @return
   */
  UserInfo get(Long id);
}

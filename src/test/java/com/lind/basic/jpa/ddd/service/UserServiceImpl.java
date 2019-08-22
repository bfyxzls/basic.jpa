package com.lind.basic.jpa.ddd.service;

import com.lind.basic.jpa.ddd.entity.UserInfo;
import com.lind.basic.jpa.ddd.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  ApplicationEventPublisher applicationEventPublisher;
  @Autowired
  UserInfoRepository userInfoRepository;

  @Override
  public void register(UserInfo userInfo) {
    userInfo.validate();
    userInfoRepository.save(userInfo);
    userInfo.registerUserEvent(applicationEventPublisher);
  }

  @Override
  public UserInfo get(Long id) {
    return userInfoRepository.getOne(id);
  }
}

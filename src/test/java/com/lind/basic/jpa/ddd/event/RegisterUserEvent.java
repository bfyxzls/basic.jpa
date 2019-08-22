package com.lind.basic.jpa.ddd.event;

import lombok.Builder;
import lombok.Getter;

/**
 * 事件源-注册用户.
 */
@Builder(toBuilder = true)
@Getter
public class RegisterUserEvent {
  private Long userId;
  private String msg;
}
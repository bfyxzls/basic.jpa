package com.lind.basic.jpa.ddd.entity;

import com.lind.basic.jpa.ddd.event.DelUserEvent;
import com.lind.basic.jpa.ddd.event.RegisterUserEvent;
import com.lind.basic.jpa.ddd.valueObject.Address;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationEventPublisher;

/**
 * 领域实体-用户主体信息.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor()
@NoArgsConstructor
public class UserInfo extends BaseEntity {
  private String username;
  private String email;

  /**
   * 值对象-地址.
   */
  @Embedded
  private Address address;

  /**
   * 实体-用户业务行业.
   */
  private UserBusinessInfo userBusinessInfo;

  /**
   * 领域方法-校验.
   */
  public void validate() {
    if (getAddress() == null) {
      throw new IllegalArgumentException("address is not empty");
    }

    if (StringUtils.isBlank(getAddress().getProvince_name())) {
      throw new IllegalArgumentException("province is not empty");
    }

    if (StringUtils.isBlank(getAddress().getCity_name())) {
      throw new IllegalArgumentException("city is not empty");
    }
  }

  /**
   * 领域方法-获取完整的地址信息.
   *
   * @return
   */
  public String fullAddress() {
    return StringUtils.join(
        getAddress().getProvince_name(),
        getAddress().getCity_name(),
        getAddress().getDistrict_name());
  }

  /**
   * 领域方法-调用领域事件.
   */
  public void registerUserEvent(ApplicationEventPublisher applicationEventPublisher) {
    applicationEventPublisher.publishEvent(RegisterUserEvent
        .builder()
        .msg("注册用户")
        .userId(getId())
        .build());
  }

  /**
   * 领域方法-调用领域事件.
   */
  public void delUserEvent(ApplicationEventPublisher applicationEventPublisher) {
    applicationEventPublisher.publishEvent(DelUserEvent
        .builder()
        .msg("删除用户")
        .userId(getId())
        .build());
  }

}

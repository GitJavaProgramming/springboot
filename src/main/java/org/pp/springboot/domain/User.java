package org.pp.springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 尝试解决乘法运算的用户
 */
@Entity
@Data
@RequiredArgsConstructor
public final class User {

    @Id
    @GeneratedValue
    @Column(name= "USER_ID")
    private Long id;

    private final String alias;

    protected User() {
        alias = null;
    }
}

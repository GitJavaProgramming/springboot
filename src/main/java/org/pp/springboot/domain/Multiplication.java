package org.pp.springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 乘法运算，包含运算因数
 */
@Entity
@Data
@RequiredArgsConstructor
public final class Multiplication {

    @Id
    @GeneratedValue
    @Column(name = "MULTIPLICATION_ID")
    private Long id;

    // 所有因数
    private final int factorA;
    private final int factorB;

    // 保存factorA * factorB 的结果
    private int result;

    Multiplication() {
        this(0, 0);
    }
}


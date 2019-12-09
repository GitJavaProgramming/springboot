package org.pp.springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 乘法运算，包含运算因数
 */
@Data
@RequiredArgsConstructor
public final class Multiplication {

    // 所有因数
    private final int factorA;
    private final int factorB;

    // 保存factorA * factorB 的结果
    private int result;

    Multiplication() {
        this(0, 0);
    }
}


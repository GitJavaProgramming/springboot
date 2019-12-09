package org.pp.springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 尝试解决乘法运算的用户
 */
@Data
@RequiredArgsConstructor
public final class User {
    private final String alias;

    protected User() {
        alias = null;
    }
}

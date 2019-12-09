package org.pp.springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 保存运算问题的一次尝试和真正的结果
 */
@Data
@RequiredArgsConstructor
public final class MultiplicationResultAttempt {
    private final User user;
    private final Multiplication multiplication;
    private final int resultAttempt;

    MultiplicationResultAttempt() {
        user = null;
        multiplication = null;
        resultAttempt = -1;
    }
}

package org.pp.springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * 保存运算问题的一次尝试和真正的结果
 */
@Entity
@Data
@RequiredArgsConstructor
public final class MultiplicationResultAttempt {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private final User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MULTIPLICATION_ID")
    private final Multiplication multiplication;

    private final int resultAttempt;

    /**
     * 尝试结果
     */
    private final boolean correct;

    MultiplicationResultAttempt() {
        user = null;
        multiplication = null;
        resultAttempt = -1;
        correct = false;
    }
}

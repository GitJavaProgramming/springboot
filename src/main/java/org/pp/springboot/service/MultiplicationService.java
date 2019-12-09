package org.pp.springboot.service;

import org.pp.springboot.domain.Multiplication;
import org.pp.springboot.domain.MultiplicationResultAttempt;

public interface MultiplicationService {
    /**
     * 创建随机数乘法对象
     *
     * @return 生成的随机数乘法对象
     */
    Multiplication createRandomMultiplication();

    boolean checkAttempt(MultiplicationResultAttempt multiplicationResultAttempt);
}

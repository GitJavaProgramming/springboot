package org.pp.springboot.service;

import org.pp.springboot.domain.Multiplication;
import org.pp.springboot.domain.MultiplicationResultAttempt;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    public boolean checkAttempt(MultiplicationResultAttempt multiplicationResultAttempt) {
        return multiplicationResultAttempt.getResultAttempt() == multiplicationResultAttempt.getMultiplication().getFactorA() *
                multiplicationResultAttempt.getMultiplication().getFactorB();
    }

}

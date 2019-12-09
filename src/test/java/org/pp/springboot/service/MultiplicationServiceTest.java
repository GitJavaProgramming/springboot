package org.pp.springboot.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.pp.springboot.domain.Multiplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class MultiplicationServiceTest {

    @MockBean
    private RandomGeneratorService randomGeneratorService;
    @Autowired
    private MultiplicationService multiplicationService;

    @Test
    public void createGeneratorServiceTest() {
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        Multiplication multiplication = multiplicationService.createRandomMultiplication();
    }
}

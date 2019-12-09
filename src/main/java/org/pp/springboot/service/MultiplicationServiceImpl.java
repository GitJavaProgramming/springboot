package org.pp.springboot.service;

import org.pp.springboot.domain.Multiplication;
import org.pp.springboot.domain.MultiplicationResultAttempt;
import org.pp.springboot.domain.User;
import org.pp.springboot.repository.MultiplicationResultAttemptRepository;
import org.pp.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    @Autowired
    private MultiplicationResultAttemptRepository attemptRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
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
    public boolean checkAttempt(final MultiplicationResultAttempt multiplicationResultAttempt) {

        Optional<User> user = userRepository.findByAlias(multiplicationResultAttempt.getUser().getAlias());

        boolean correct = multiplicationResultAttempt.getResultAttempt() ==
                multiplicationResultAttempt.getMultiplication().getFactorA() * multiplicationResultAttempt.getMultiplication().getFactorB();

        MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(
                user.orElse(multiplicationResultAttempt.getUser()),
                multiplicationResultAttempt.getMultiplication(),
                multiplicationResultAttempt.getResultAttempt(),
                correct
        );

        // 数据持久化
        attemptRepository.save(checkedAttempt);

        return correct;
    }

    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
        return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
    }

}

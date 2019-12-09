package org.pp.springboot.repository;

import org.pp.springboot.domain.Multiplication;
import org.springframework.data.repository.CrudRepository;

public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {
}

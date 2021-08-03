package com.codegym.repository;

import com.codegym.model.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProducerRepository extends CrudRepository<Producer, Long> {
}

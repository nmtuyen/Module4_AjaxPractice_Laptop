package com.codegym.repository;

import com.codegym.model.Laptop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILaptopRepository extends PagingAndSortingRepository<Laptop, Long> {
    Optional<Laptop> findByModel(String model);
    Iterable<Laptop> findAllByModelContaining(String name);
}

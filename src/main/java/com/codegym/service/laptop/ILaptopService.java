package com.codegym.service.laptop;

import com.codegym.model.Laptop;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface ILaptopService extends IGeneralService<Laptop> {
    Optional<Laptop> findByModel(String model);
    Iterable<Laptop> findAllByModelContaining(String name);
}

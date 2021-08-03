package com.codegym.service.laptop;

import com.codegym.model.Laptop;
import com.codegym.repository.ILaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopService implements ILaptopService{
    @Autowired
    private ILaptopRepository iLaptopRepository;

    @Override
    public Iterable<Laptop> findAll() {
        return iLaptopRepository.findAll();
    }

    @Override
    public Optional<Laptop> findById(Long id) {
        return iLaptopRepository.findById(id);
    }

    @Override
    public Laptop save(Laptop laptop) {
        return iLaptopRepository.save(laptop);
    }

    @Override
    public void remove(Long id) {
        iLaptopRepository.deleteById(id);
    }

    @Override
    public Optional<Laptop> findByModel(String model) {
        return iLaptopRepository.findByModel(model);
    }

    @Override
    public Iterable<Laptop> findAllByModelContaining(String name) {
        return iLaptopRepository.findAllByModelContaining(name);
    }

}

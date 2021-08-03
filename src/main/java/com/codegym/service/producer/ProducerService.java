package com.codegym.service.producer;

import com.codegym.model.Laptop;
import com.codegym.model.Producer;
import com.codegym.repository.IProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProducerService implements IProducerService{
    @Autowired
    private IProducerRepository iProducerRepository;

    @Override
    public Iterable<Producer> findAll() {
        return iProducerRepository.findAll();
    }

    @Override
    public Optional<Producer> findById(Long id) {
        return iProducerRepository.findById(id);
    }

    @Override
    public Producer save(Producer producer) {
        return iProducerRepository.save(producer);
    }

    @Override
    public void remove(Long id) {
        iProducerRepository.deleteById(id);
    }


}

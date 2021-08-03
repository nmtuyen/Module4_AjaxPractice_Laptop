package com.codegym.service.cpu;

import com.codegym.model.Cpu;
import com.codegym.model.Laptop;
import com.codegym.repository.ICpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CpuService implements ICpuService{
    @Autowired
    private ICpuRepository iCpuRepository;

    @Override
    public Iterable<Cpu> findAll() {
        return iCpuRepository.findAll();
    }

    @Override
    public Optional<Cpu> findById(Long id) {
        return iCpuRepository.findById(id);
    }

    @Override
    public Cpu save(Cpu cpu) {
        return iCpuRepository.save(cpu);
    }

    @Override
    public void remove(Long id) {
        iCpuRepository.deleteById(id);
    }
    
}

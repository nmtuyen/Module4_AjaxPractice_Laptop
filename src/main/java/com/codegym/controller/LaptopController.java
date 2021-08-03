package com.codegym.controller;

import com.codegym.model.Laptop;
import com.codegym.service.laptop.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/laptops")
@CrossOrigin("*")
public class LaptopController {
    @Autowired
    private ILaptopService laptopService;

    @GetMapping("")
    public ResponseEntity<Iterable<Laptop>> findAll(){
        return new ResponseEntity<>(laptopService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Laptop> saveNew(@RequestBody Laptop laptop){
        if (laptopService.findByModel(laptop.getModel()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            laptopService.save(laptop);
            return new  ResponseEntity<>(laptopService.findById(laptop.getId()).get(), HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Laptop> save(@RequestBody Laptop laptop){
        laptopService.save(laptop);
        return new  ResponseEntity<>(laptopService.findById(laptop.getId()).get(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id){
        Optional<Laptop> laptopOption = laptopService.findById(id);
        if (!laptopOption.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(laptopOption.get(), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Laptop> update(@PathVariable Long id, @RequestBody Laptop laptop){
        Optional<Laptop> laptopOptional = laptopService.findById(id);
        if (!laptopOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (laptop.getModel().equals("")){
            laptop.setModel(laptopOptional.get().getModel());
        }
        if (laptop.getPrice()==0){
            laptop.setPrice(laptopOptional.get().getPrice());
        }
        if (laptop.getCpu().equals("")){
            laptop.setCpu(laptopOptional.get().getCpu());
        }
        if (laptop.getProducer().equals("")) {
            laptop.setProducer(laptopOptional.get().getProducer());
        }
        if (laptop.getColor().equals("")) {
            laptop.setColor(laptopOptional.get().getColor());
        }
        laptop.setId(id);

        return new ResponseEntity<>(laptopService.save(laptop), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        Optional<Laptop> laptopOptional = laptopService.findById(id);
        if (!laptopOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        laptopService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Laptop>> searchModel(@RequestParam String name){
        Iterable<Laptop> laptops = laptopService.findAllByModelContaining(name);
        return new ResponseEntity(laptops, HttpStatus.OK);
    }
}

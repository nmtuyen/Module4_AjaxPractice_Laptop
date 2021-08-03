package com.codegym.controller;

import com.codegym.model.Laptop;
import com.codegym.model.Producer;
import com.codegym.service.producer.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/producers")
@CrossOrigin("*")
public class ProducerController {
    @Autowired
    private IProducerService iProducerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Producer>> findAll(){
        return new ResponseEntity<>(iProducerService.findAll(), HttpStatus.OK);
    }
}

package com.codegym.controller;

import com.codegym.model.Cpu;
import com.codegym.model.Laptop;
import com.codegym.service.cpu.ICpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/cpus")
@CrossOrigin("*")
public class CpuController {
    @Autowired
    private ICpuService cpuService;

    @GetMapping("")
    public ResponseEntity<Iterable<Cpu>>findAll(){
        return new ResponseEntity<>(cpuService.findAll(), HttpStatus.OK);
    }
}

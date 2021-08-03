package com.codegym.formatter;

import com.codegym.model.Cpu;
import com.codegym.service.cpu.ICpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CpuFormatter implements Formatter<Cpu> {
    private ICpuService iCpuService;

    @Autowired
    public CpuFormatter(ICpuService iCpuService){
        this.iCpuService = iCpuService;
    }

    @Override
    public Cpu parse(String text, Locale locale) throws ParseException {
        return this.iCpuService.findById(Long.valueOf(text)).get();
    }

    @Override
    public String print(Cpu object, Locale locale) {
        return null;
    }
}

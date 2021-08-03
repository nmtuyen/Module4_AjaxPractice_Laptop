package com.codegym.formatter;

import com.codegym.model.Producer;
import com.codegym.service.producer.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ProducerFormatter implements Formatter<Producer> {
    private IProducerService producerService;


    @Autowired
    public ProducerFormatter(IProducerService producerService){
        this.producerService = producerService;
    }

    @Override
    public Producer parse(String text, Locale locale) throws ParseException {
        return this.producerService.findById(Long.valueOf(text)).get();
    }

    @Override
    public String print(Producer object, Locale locale) {
        return null;
    }
}

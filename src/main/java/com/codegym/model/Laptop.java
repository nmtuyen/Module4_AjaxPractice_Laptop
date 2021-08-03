package com.codegym.model;


import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String color;
    @ManyToOne
    private Producer producer;
    @ManyToOne
    private Cpu cpu;
    private double price;

    public Laptop() {
    }

    public Laptop(String model, String color, Producer producer, Cpu cpu, double price) {
        this.model = model;
        this.color = color;
        this.producer = producer;
        this.cpu = cpu;
        this.price = price;
    }

    public Laptop(Long id, String model, String color, Producer producer, Cpu cpu, double price) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.producer = producer;
        this.cpu = cpu;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


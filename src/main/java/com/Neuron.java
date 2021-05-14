package com;

import lombok.Data;

@Data
public class Neuron {

    private String name;

    private Double value = 0.0;

    private Double dMin = 0.0;

    public Neuron(String name) {
        this.name = name;
    }

    public Neuron(String name, Double value, Double dMin) {
        this.name = name;
        this.value = value;
        this.dMin = dMin;
    }

    public Neuron() {
    }
}

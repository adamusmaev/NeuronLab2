package com;

import lombok.Data;

@Data
public class Synapse {
    private Neuron inputNeron;
    private Neuron outputNeuron;
    private Double synapseWeight;
}

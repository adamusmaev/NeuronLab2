package com;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Level {

    private List<Neuron> neuronList = new ArrayList<>();
}

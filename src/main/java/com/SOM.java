package com;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SOM {

    private Map<Integer, List<Double>> map = new HashMap<>();
    private Map<Neuron, Neuron> mapInputAndOutputNeuron = new HashMap<>();
    int x;
    int y;
    private Network network;

    public SOM(int x, int y, Network network) {
        int q = 0;
        for (int i = 0; i < y; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < x; j++) {
                map.get(i).add(j, 0.0);
                q++;
            }
        }
        this.x = x;
        this.y = y;
        this.network = network;
    }

    public void printSOM() {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                System.out.print(" " + map.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void addNeuronInSOM(Neuron neuron, Integer parameterNumber) {
        char neuronNumberChar = neuron.getName().charAt(neuron.getName().length() - 1);
        Integer neuronNumber = Integer.valueOf(String.valueOf(neuronNumberChar));
        int q = 0;
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (neuronNumber == q) {
                    Double parameterValue = network.getLevelList().get(0).getNeuronList().get(parameterNumber).getValue();
                    Double currentValue = map.get(i).get(j);
                    if (currentValue < parameterValue) {
                        map.get(i).set(j, parameterValue);
                    }
                }
                q++;
            }
        }

    }
}

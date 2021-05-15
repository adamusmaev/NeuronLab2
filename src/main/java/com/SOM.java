package com;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SOM {

    private Map<Integer, List<Double>> map = new HashMap<>();
    Network network;
    int x;
    int y;
    private List<Neuron> neuronList = new ArrayList<>();

    public SOM(int x, int y, Network network) {
        for (int i = 0; i < y; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < x; j++) {
                map.get(i).add(j, 0.0);
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

    public void addNeuronInSOM(Neuron neuron) {
        neuronList.add(neuron);
        System.out.println(neuronList);
        //Double dMin = neuron.getDMin();
        //char neuronName = neuron.getName().charAt(neuron.getName().length() - 1);
        //Integer clusterNumber = Integer.valueOf(String.valueOf(neuronName));
       // Double value = map.get(clusterNumber).get();
    }
}

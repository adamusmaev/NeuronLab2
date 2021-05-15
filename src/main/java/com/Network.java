package com;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;

@Data
public class Network {

    private List<Synapse> synapseList = new ArrayList<>();
    private List<Level> levelList = new ArrayList<>();
    //private List<List<>>

    public void addRandomWeightForSynapse() {
        Random r = new Random();
        for (int i = 0; i < levelList.get(0).getNeuronList().size(); i++) {
            for (int j = 0; j < levelList.get(1).getNeuronList().size(); j++) {
                Synapse synapse = new Synapse();
                synapse.setInputNeron(levelList.get(0).getNeuronList().get(i));
                synapse.setOutputNeuron(levelList.get(1).getNeuronList().get(j));
                synapse.setSynapseWeight((r.nextDouble() - 1) + 1);
                synapseList.add(synapse);
            }
        }
    }

    public void countDMin() {
        for (int i = 0; i < levelList.get(1).getNeuronList().size(); i++) {
            Neuron neuron = levelList.get(1).getNeuronList().get(i);
            Double dMin = 0.0;
            for (int j = 0; j < levelList.get(0).getNeuronList().size(); j++) {
                Synapse synapseTmp = findSynapseByNeurons(levelList.get(0).getNeuronList().get(j), neuron);
                dMin = dMin + Math.pow(levelList.get(0).getNeuronList().get(j).getValue() - synapseTmp.getSynapseWeight(), 2);
            }
            neuron.setDMin(Math.pow(dMin, 0.5));
        }
    }

    public Synapse findSynapseByNeurons(Neuron input, Neuron output) {
        for (int i = 0; i < synapseList.size(); i++) {
            Synapse synapseTmp = synapseList.get(i);
            if (synapseTmp.getInputNeron().equals(input) && synapseTmp.getOutputNeuron().equals(output))
                return synapseTmp;
        }
        throw new IllegalArgumentException("Synapse not found");
    }

    public Neuron training() {
        this.countDMin();
        List<Double> dMinList = new ArrayList<>();
        Neuron neuronWinner = getNeuronWinner();
        Double r = 0.0;
        Double radius = 0.5;
        for (int i = 1; i < 10; i++) {
            r = 0.1 / i;
            for (int j = 0; j < levelList.get(1).getNeuronList().size(); j++) {
                Neuron neuronTmp = levelList.get(1).getNeuronList().get(j);
                if (neuronTmp.equals(neuronWinner)) {
                    for (int q = 0; q < levelList.get(0).getNeuronList().size(); q++) {
                        Neuron neuronInput = levelList.get(0).getNeuronList().get(q);
                        Synapse synapse = findSynapseByNeurons(neuronInput, neuronTmp);
                        Double newWeightSynapse = r * (neuronInput.getValue() - synapse.getSynapseWeight()) + synapse.getSynapseWeight();
                        synapse.setSynapseWeight(newWeightSynapse);
                    }
                } else if (Math.abs(neuronWinner.getDMin() - neuronTmp.getDMin()) < radius) {
                    for (int q = 0; q < levelList.get(0).getNeuronList().size(); q++) {
                        Neuron neuronInput = levelList.get(0).getNeuronList().get(q);
                        Synapse synapse = findSynapseByNeurons(neuronInput, neuronTmp);
                        Double newWeightSynapse = r * (neuronInput.getValue() - synapse.getSynapseWeight()) + synapse.getSynapseWeight();
                        synapse.setSynapseWeight(newWeightSynapse);
                    }
                }
            }
            radius = radius - 0.5;
        }
        return neuronWinner;
    }

    public Neuron getNeuronWinner() {
        Neuron neuron = levelList.get(1).getNeuronList().get(0);
        for (int i = 1; i < levelList.get(1).getNeuronList().size(); i++) {
            Neuron neuronTmp = levelList.get(1).getNeuronList().get(i);
            if (neuron.getDMin() > neuronTmp.getDMin()) neuron = neuronTmp;
        }
        //System.out.println(neuron);
        return neuron;
    }
}

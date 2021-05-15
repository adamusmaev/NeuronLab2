package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Network network = new Network();

        Level level1 = new Level();
        List<Neuron> list1 = new ArrayList<>();
        level1.setNeuronList(list1);
        network.getLevelList().add(level1);
        for (int i = 0; i < 5; i++) {
            list1.add(new Neuron("Level1; " + i));
        }

        level1.getNeuronList().get(0).setValue(0.980);
        level1.getNeuronList().get(1).setValue(0.977);
        level1.getNeuronList().get(2).setValue(0.941);
        level1.getNeuronList().get(3).setValue(0.090);
        level1.getNeuronList().get(4).setValue(0.1);

        Level level2 = new Level();
        List<Neuron> list2 = new ArrayList<>();
        level2.setNeuronList(list2);
        network.getLevelList().add(level2);
        for (int i = 0; i < 16; i++) {
            list2.add(new Neuron("Level2; " + i));
        }

        network.addRandomWeightForSynapse();
        for (int i = 0; i < network.getSynapseList().size(); i++) {
            System.out.println(network.getSynapseList().get(i));
        }
        System.out.println("---------------------------------------");
        network.training();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        SOM som1 = new SOM(4,4, network);
        SOM som2 = new SOM(4,4, network);
        for (int i = 0; i < 10; i++) {
            level1.getNeuronList().get(0).setValue(0.980);
            level1.getNeuronList().get(1).setValue(0.977);
            level1.getNeuronList().get(2).setValue(0.941);
            level1.getNeuronList().get(3).setValue(0.090);
            level1.getNeuronList().get(4).setValue(0.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.05);
            level1.getNeuronList().get(1).setValue(0.02);
            level1.getNeuronList().get(2).setValue(0.058);
            level1.getNeuronList().get(3).setValue(0.93);
            level1.getNeuronList().get(4).setValue(1.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.27);
            level1.getNeuronList().get(1).setValue(0.36);
            level1.getNeuronList().get(2).setValue(0.41);
            level1.getNeuronList().get(3).setValue(0.5);
            level1.getNeuronList().get(4).setValue(1.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.9);
            level1.getNeuronList().get(1).setValue(0.7);
            level1.getNeuronList().get(2).setValue(0.8);
            level1.getNeuronList().get(3).setValue(0.12);
            level1.getNeuronList().get(4).setValue(0.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.1);
            level1.getNeuronList().get(1).setValue(0.08);
            level1.getNeuronList().get(2).setValue(0.058);
            level1.getNeuronList().get(3).setValue(0.873);
            level1.getNeuronList().get(4).setValue(1.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.47);
            level1.getNeuronList().get(1).setValue(0.26);
            level1.getNeuronList().get(2).setValue(0.41);
            level1.getNeuronList().get(3).setValue(0.5);
            level1.getNeuronList().get(4).setValue(1.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.950);
            level1.getNeuronList().get(1).setValue(0.9);
            level1.getNeuronList().get(2).setValue(0.921);
            level1.getNeuronList().get(3).setValue(0.10);
            level1.getNeuronList().get(4).setValue(0.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.05);
            level1.getNeuronList().get(1).setValue(0.02);
            level1.getNeuronList().get(2).setValue(0.18);
            level1.getNeuronList().get(3).setValue(0.83);
            level1.getNeuronList().get(4).setValue(1.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.17);
            level1.getNeuronList().get(1).setValue(0.56);
            level1.getNeuronList().get(2).setValue(0.61);
            level1.getNeuronList().get(3).setValue(0.45);
            level1.getNeuronList().get(4).setValue(1.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.95);
            level1.getNeuronList().get(1).setValue(0.8);
            level1.getNeuronList().get(2).setValue(0.84);
            level1.getNeuronList().get(3).setValue(0.22);
            level1.getNeuronList().get(4).setValue(0.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.15);
            level1.getNeuronList().get(1).setValue(0.03);
            level1.getNeuronList().get(2).setValue(0.088);
            level1.getNeuronList().get(3).setValue(0.923);
            level1.getNeuronList().get(4).setValue(1.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);

            level1.getNeuronList().get(0).setValue(0.4);
            level1.getNeuronList().get(1).setValue(0.32);
            level1.getNeuronList().get(2).setValue(0.46);
            level1.getNeuronList().get(3).setValue(0.45);
            level1.getNeuronList().get(4).setValue(1.0);
            System.out.println(network.training());
            som1.addNeuronInSOM(network.training(), 0);
            som2.addNeuronInSOM(network.training(), 1);
        }

        for (int i = 0; i < network.getSynapseList().size(); i++) {
            System.out.println(network.getSynapseList().get(i));
        }
        som1.printSOM();
        System.out.println();
        som2.printSOM();
        /*while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите размых крыльев");
            Double value1 = (in.nextDouble() - 10) / (35.5 - 10);

            System.out.println("Введите макс. взлётную массу");
            Double value2 = (in.nextDouble() - 27) / (72 - 27);

            System.out.println("Введите максимальная грузоподъёмность");
            Double value3 = (in.nextDouble() - 3) / (20 - 3);

            System.out.println("Введите максимальная скорость");
            Double value4 = (in.nextDouble() - 800) / (2400 - 800);

            System.out.println("Имеется ли оружие");
            Double value5 = in.nextDouble();

            level1.getNeuronList().get(0).setValue(value1);
            level1.getNeuronList().get(1).setValue(value2);
            level1.getNeuronList().get(2).setValue(value3);
            level1.getNeuronList().get(3).setValue(value4);
            level1.getNeuronList().get(4).setValue(value5);
            System.out.println(network.training());
        }*/
    }
}

package ru.job4j.ood.srp.sensor;

public interface Indications {

    Float getIndication();
    Float alignmentReadings(Float inducation);
    void print(Float inducation);
}

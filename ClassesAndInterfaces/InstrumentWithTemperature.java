package kz.ClassesAndInterfaces;

import java.util.List;

public abstract class InstrumentWithTemperature implements Instrument{
    private double temperature;
    public InstrumentWithTemperature(double temperature){
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }


    public void process(List<String> ingredients) {
        System.out.println(ingredients + " were processes with temperature "+temperature);
    }
}

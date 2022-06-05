package kz.ClassesAndInterfaces;

import java.util.List;

public class Oven extends InstrumentWithTemperature{
    private String model;
    public Oven(double temperature, String model) {
        super(temperature);
        this.model = model;
    }


    @Override
    public void process(List<String> ingredients) {
        super.process(ingredients);
        System.out.println("Processed by model: " + model);
        System.out.println("Processed by temperature: " + getTemperature());
    }
}

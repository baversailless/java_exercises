package kz.ClassesAndInterfaces;

public interface Instrument {
    default void process(Ingredient ingredient) {
        System.out.print(ingredient.getName() + " ");
    }
}


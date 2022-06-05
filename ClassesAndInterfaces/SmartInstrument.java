package kz.ClassesAndInterfaces;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface SmartInstrument {
    void process(Supplier<List<Ingredient>> ingredients, Predicate<Ingredient> ingredientPredicate);
}

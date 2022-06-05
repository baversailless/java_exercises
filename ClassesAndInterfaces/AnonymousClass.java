package kz.ClassesAndInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AnonymousClass{
    public static void main(String[] args) {
        Instrument shredder = new Instrument() {
            @Override
            public void process(Ingredient ingredient) {
                ingredient.setType(Type.SHREDDED);
            }
        };
        System.out.println("Using anonymous class: ");
        Ingredient i1 = new Ingredient("Egg", Type.BOILED);
        shredder.process(i1);
        System.out.println("The type of ingredient: " + i1.getType());

        System.out.println("Using lambda: ");
        Ingredient i2 = new Ingredient("Chicken", Type.FRIED);
        Ingredient i3 = new Ingredient("Shrimp", Type.RAW);
        Ingredient i4 = new Ingredient("Onion", Type.FRIED);
        Ingredient i5 = new Ingredient("Potato", Type.FRIED);
        Ingredient i6 = new Ingredient("Fish", Type.RAW);
        List<Ingredient> ingredients = new ArrayList<>(List.of(i2, i3, i4, i5, i6));
        Consumer<Ingredient> ingredientConsumer = ingredient -> ingredient.setType(Type.SHREDDED);
        ingredients.forEach(ingredientConsumer);
        System.out.println("The type of ingredient: " + i3.getType());

        System.out.println("Using references: ");
        Consumer<Ingredient> ingredientConsumer1 = Ingredient::setToShredder;
        ingredients.forEach(ingredientConsumer1);
        System.out.println("The type of ingredient: " + i2.getType());


        Predicate<Ingredient> rawOrShredded = ingredient -> ingredient.getType() == Type.RAW ||
                                                             ingredient.getType() == Type.SHREDDED;
        Predicate<Ingredient> onlyShredded = Ingredient::isShredded;

        Supplier<List<Ingredient>> supplier = new Supplier<List<Ingredient>>() {
            @Override
            public List<Ingredient> get() {
                return ingredients;
            }
        };

        SmartInstrument pot = new SmartInstrument() {
            @Override
            public void process(Supplier<List<Ingredient>> ingredients, Predicate<Ingredient> ingredientPredicate) {
                System.out.println("Pot will boil: ");
                for(Ingredient ingredient : ingredients.get()){
                    if(ingredientPredicate.test(ingredient))
                    {
                        System.out.print(ingredient.getName()+ ", ");
                    }
                }
            }
        };
        pot.process(supplier, rawOrShredded);

        SmartInstrument pan = new SmartInstrument() {
            @Override
            public void process(Supplier<List<Ingredient>> ingredients, Predicate<Ingredient> ingredientPredicate) {
                System.out.println();
                System.out.println("Pan will fry: ");
                for(Ingredient ingredient : ingredients.get()){
                    if(ingredientPredicate.test(ingredient)){
                        System.out.print(ingredient.getName() + ", ");
                    }
                }
            }
        };
        pan.process(supplier, onlyShredded);



    }
}


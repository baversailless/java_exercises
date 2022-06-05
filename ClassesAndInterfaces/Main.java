package kz.ClassesAndInterfaces;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> ingredients = Arrays.asList("Apple", "Meat", "Carrot", "Onion");

        Shredder shredder = new Shredder();
       // shredder.process(ingredients);
        Oven oven = new Oven(180, "LG");
        oven.process(ingredients);

        }
    }


package ru.home.validator;

import ru.home.model.RootVegetable;

public class RootVegetableValidator {

    public static boolean isValid(RootVegetable rootVegetable) {
        return isValidType(rootVegetable.getType()) &&
                isValidWeight(rootVegetable.getWeight()) &&
                isValidColor(rootVegetable.getColor());
    }

    private static boolean isValidType(String type) {
        return type != null && !type.isEmpty();
    }

    private static boolean isValidWeight(double weight) {
        return weight > 0;
    }

    private static boolean isValidColor(String color) {
        return color != null && !color.isEmpty();
    }
}
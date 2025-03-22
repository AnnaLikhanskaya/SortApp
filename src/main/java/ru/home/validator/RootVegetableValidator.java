package ru.home.validator;

import ru.home.model.RootVegetable;

public class RootVegetableValidator {

    public static boolean isValid(RootVegetable rootVegetable) {
        if (!isValidType(rootVegetable.getType())) {
            System.out.println("Ошибка: Некорректный тип корнеплода. Тип не должен быть пустым.");
            return false;
        }
        if (!isValidWeight(rootVegetable.getWeight())) {
            System.out.println("Ошибка: Некорректный вес корнеплода. Вес должен быть больше 0.");
            return false;
        }
        if (!isValidColor(rootVegetable.getColor())) {
            System.out.println("Ошибка: Некорректный цвет корнеплода. Цвет не должен быть пустым.");
            return false;
        }
        return true;
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

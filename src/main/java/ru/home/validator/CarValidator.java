package ru.home.validator;

import ru.home.model.Car;

public class CarValidator {

    public static boolean isValid(Car car) {
        return isValidPower(car.getPower()) &&
                isValidModel(car.getModel()) &&
                isValidYear(car.getYear());
    }

    private static boolean isValidPower(int power) {
        return power > 0 && power < 1001;
    }

    private static boolean isValidModel(String model) {
        return model != null && !model.isEmpty();
    }

    private static boolean isValidYear(int year) {
        return year > 1900 && year < 2026;
    }
}
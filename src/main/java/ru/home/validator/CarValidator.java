package ru.home.validator;

import ru.home.model.Car;

public class CarValidator {

    public static boolean isValid(Car car) {
        if (!isValidPower(car.getPower())) {
            System.out.println("Ошибка: Некорректная мощность автомобиля. " +
                    "Мощность должна быть в диапазоне от 1 до 1000.");
            return false;
        }
        if (!isValidModel(car.getModel())) {
            System.out.println("Ошибка: Некорректная модель автомобиля. " +
                    "Модель не должна быть пустой.");
            return false;
        }
        if (!isValidYear(car.getYear())) {
            System.out.println("Ошибка: Некорректный год выпуска автомобиля. " +
                    "Год должен быть в диапазоне от 1900 до 2025.");
            return false;
        }
        return true;
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

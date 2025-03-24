package ru.home.model;

import ru.home.validator.CarValidator;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private int power;
    private String model;
    private int year;

    private Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.year = builder.year;
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Car other) {
        int yearComparison = Integer.compare(this.year, other.year);
        if (yearComparison != 0) {
            return yearComparison;
        }
        int modelComparison = this.model.compareTo(other.model);
        if (modelComparison != 0) {
            return modelComparison;
        }
        return Integer.compare(this.power, other.power);
    }

    public static class Builder {
        private int power;
        private String model;
        private int year;

        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            if (CarValidator.isValid(new Car(this))) {
                return new Car(this);
            } else {
                throw new IllegalArgumentException("Неккоретные данные об автомобиле");
            }
        }
    }
}

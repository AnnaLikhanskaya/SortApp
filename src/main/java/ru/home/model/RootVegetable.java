package ru.home.model;

import ru.home.validator.RootVegetableValidator;

import java.util.Comparator;

public class RootVegetable implements Comparable<RootVegetable> {
    private String type;
    private double weight;
    private String color;

    private RootVegetable(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(RootVegetable other) {
        int typeComparison = this.type.compareTo(other.type);
        if (typeComparison != 0) {
            return typeComparison;
        }
        int colorComparison = this.color.compareTo(other.color);
        if (colorComparison != 0) {
            return colorComparison;
        }
        return Double.compare(this.weight, other.weight);
    }

//    public static class RootVegetableComparator implements Comparator<RootVegetable> {
//        @Override
//        public int compare(RootVegetable rv1, RootVegetable rv2) {
//            int typeComparison = rv1.getType().compareTo(rv2.getType());
//            if (typeComparison != 0) {
//                return typeComparison;
//            }
//            int colorComparison = rv1.getColor().compareTo(rv2.getColor());
//            if (colorComparison != 0) {
//                return colorComparison;
//            }
//            return Double.compare(rv1.getWeight(), rv2.getWeight());
//        }
//    }

    public static class Builder {
        private String type;
        private double weight;
        private String color;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public RootVegetable build() {
            if (RootVegetableValidator.isValid(new RootVegetable(this))) {
                return new RootVegetable(this);
            } else {
                throw new IllegalArgumentException("Неккоретные данные об корнеплоде");
            }
        }
    }
}

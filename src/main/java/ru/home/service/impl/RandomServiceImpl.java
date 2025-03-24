package ru.home.service.impl;

import ru.home.model.Book;
import ru.home.model.Car;
import ru.home.model.RootVegetable;
import ru.home.service.RandomService;

import java.util.Random;

public class RandomServiceImpl implements RandomService {
    private static final Random RANDOM = new Random();

    @Override
    public Car[] fillRandomCars(int size) {
        Car[] cars = new Car[size];
        for (int i = 0; i < size; i++) {
            int power = RANDOM.nextInt(100, 500);
            String model = "Model-" + RANDOM.nextInt(1000);
            int year = 1900 + RANDOM.nextInt(2026 - 1900);
            Car car = new Car.Builder().setPower(power).setModel(model).setYear(year).build();
            cars[i] = car;
        }
        return cars;
    }

    @Override
    public Book[] fillRandomBooks(int size) {
        Book[] books = new Book[size];
        for (int i = 0; i < size; i++) {
            String author = "Author-" + RANDOM.nextInt(1000);
            String title = "Title-" + RANDOM.nextInt(1000);
            int pages = RANDOM.nextInt(1, 1000);
            books[i] = new Book.Builder().setAuthor(author).setTitle(title).setPages(pages).build();
        }
        return books;
    }

    @Override
    public RootVegetable[] fillRandomRootVegetables(int size) {
        RootVegetable[] rootVegetables = new RootVegetable[size];
        for (int i = 0; i < size; i++) {
            String type = "Type-" + RANDOM.nextInt(1000);
            double weight = RANDOM.nextDouble(0.1, 5.0);
            String color = "Color-" + RANDOM.nextInt(1000);
            rootVegetables[i] = new RootVegetable.Builder().setType(type).setWeight(weight).setColor(color).build();
        }
        return rootVegetables;
    }
}

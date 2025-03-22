package ru.home.service.impl;

import ru.home.model.Book;
import ru.home.model.Car;
import ru.home.model.RootVegetable;
import ru.home.service.ManualService;
import ru.home.validator.BookValidator;
import ru.home.validator.CarValidator;
import ru.home.validator.RootVegetableValidator;

import java.util.Scanner;

public class ManualServiceImpl implements ManualService {
    @Override
    public Car[] fillManuallyCars(Scanner scanner, int size) {
        Car[] cars = new Car[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Введите данные для автомобиля " + (i + 1) + ":");

            System.out.print("Мощность: ");
            int power = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Модель: ");
            String model = scanner.nextLine().trim();

            System.out.print("Год: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            Car car = new Car.Builder()
                    .setPower(power)
                    .setModel(model)
                    .setYear(year)
                    .build();

            if (CarValidator.isValid(car)) {
                cars[i] = car;
            } else {
                System.out.println("Ошибка валидации данных для автомобиля " + (i + 1) + ". Попробуйте снова.");
                i--;
            }
        }
        return cars;
    }

    @Override
    public Book[] fillManuallyBooks(Scanner scanner, int size) {
        Book[] books = new Book[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Введите данные для книги " + (i + 1) + ":");

            System.out.print("Автор: ");
            String author = scanner.nextLine().trim();

            System.out.print("Название: ");
            String title = scanner.nextLine().trim();

            System.out.print("Количество страниц: ");
            int pages = scanner.nextInt();
            scanner.nextLine();

            Book book = new Book.Builder()
                    .setAuthor(author)
                    .setTitle(title)
                    .setPages(pages)
                    .build();

            if (BookValidator.isValid(book)) {
                books[i] = book;
            } else {
                System.out.println("Ошибка валидации данных для книги " + (i + 1) + ". Попробуйте снова.");
                i--;
            }
        }
        return books;
    }

    @Override
    public RootVegetable[] fillManuallyRootVegetables(Scanner scanner, int size) {
        RootVegetable[] rootVegetables = new RootVegetable[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Введите данные для корнеплода " + (i + 1) + ":");

            System.out.print("Тип: ");
            String type = scanner.nextLine().trim();

            System.out.print("Вес: ");
            double weight = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Цвет: ");
            String color = scanner.nextLine().trim();

            RootVegetable rootVegetable = new RootVegetable.Builder()
                    .setType(type)
                    .setWeight(weight)
                    .setColor(color)
                    .build();

            if (RootVegetableValidator.isValid(rootVegetable)) {
                rootVegetables[i] = rootVegetable;
            } else {
                System.out.println("Ошибка валидации данных для корнеплода " + (i + 1) + ". Попробуйте снова.");
                i--;
            }
        }
        return rootVegetables;
    }
}

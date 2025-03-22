package ru.home.service.impl;

import ru.home.model.Book;
import ru.home.model.Car;
import ru.home.model.RootVegetable;
import ru.home.service.FileService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public Car[] fillFromFileForCars(String fileName) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    int power = Integer.parseInt(values[0].trim());
                    String model = values[1].trim();
                    int year = Integer.parseInt(values[2].trim());
                    Car car = new Car.Builder().setPower(power).setModel(model).setYear(year).build();
                    cars.add(car);
                    System.out.println("Добавлен автомобиль: " + car.getModel()); // Отладочное сообщение
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars.toArray(new Car[0]);
    }


    @Override
    public Book[] fillFromFileForBooks(String fileName) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    String author = values[0].trim();
                    String title = values[1].trim();
                    int pages = Integer.parseInt(values[2].trim());
                    Book book = new Book.Builder().setAuthor(author).setTitle(title).setPages(pages).build();
                    books.add(book);
                    System.out.println("Добавлена книга: " + book.getTitle()); // Отладочное сообщение
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books.toArray(new Book[0]);
    }

    @Override
    public RootVegetable[] fillFromFileForRootVegetables(String fileName) {
        List<RootVegetable> rootVegetables = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    String type = values[0].trim();
                    double weight = Double.parseDouble(values[1].trim());
                    String color = values[2].trim();
                    RootVegetable rootVegetable = new RootVegetable.Builder().setType(type).setWeight(weight).setColor(color).build();
                    rootVegetables.add(rootVegetable);
                    System.out.println("Добавлен корнеплод: " + rootVegetable.getType()); // Отладочное сообщение
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rootVegetables.toArray(new RootVegetable[0]);
    }
}

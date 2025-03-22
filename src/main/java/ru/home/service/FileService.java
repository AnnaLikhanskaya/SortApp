package ru.home.service;

import ru.home.model.Book;
import ru.home.model.Car;
import ru.home.model.RootVegetable;

public interface FileService {
    Car[] fillFromFileForCars(String fileName);

    Book[] fillFromFileForBooks(String fileName);

    RootVegetable[] fillFromFileForRootVegetables(String fileName);
}

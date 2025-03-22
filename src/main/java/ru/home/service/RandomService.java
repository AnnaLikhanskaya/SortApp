package ru.home.service;

import ru.home.model.Book;
import ru.home.model.Car;
import ru.home.model.RootVegetable;

public interface RandomService {
    Car[] fillRandomCars(int size);

    Book[] fillRandomBooks(int size);

    RootVegetable[] fillRandomRootVegetables(int size);
}


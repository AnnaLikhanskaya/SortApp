package ru.home.service;

import ru.home.model.Book;
import ru.home.model.Car;
import ru.home.model.RootVegetable;

import java.util.Scanner;

public interface ManualService {
    Car[] fillManuallyCars(Scanner scanner, int size);

    Book[] fillManuallyBooks(Scanner scanner, int size);

    RootVegetable[] fillManuallyRootVegetables(Scanner scanner, int size);
}


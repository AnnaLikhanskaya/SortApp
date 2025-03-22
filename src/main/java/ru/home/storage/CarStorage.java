package ru.home.storage;

import ru.home.model.Car;
import ru.home.service.SortService;
import ru.home.util.CustomArrayList;

import java.util.Comparator;
import java.util.List;

public class CarStorage implements Storage<Car> {
    private CustomArrayList<Car> storage;
    private SortService<Car> sortService;

    public CarStorage() {
        this.storage = new CustomArrayList<>();
    }

    @Override
    public void add(Car item) {
        storage.add(item);
    }

    @Override
    public Car get(int index) {
        return storage.get(index);
    }

    @Override
    public List<Car> getAll() {
        return storage.getAll();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    public void sort(Comparator<? super Car> comparator) {
        storage.sort(comparator, sortService);
    }
}
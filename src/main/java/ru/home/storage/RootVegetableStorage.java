package ru.home.storage;

import ru.home.model.RootVegetable;
import ru.home.service.SortService;
import ru.home.util.CustomArrayList;

import java.util.Comparator;
import java.util.List;

public class RootVegetableStorage implements Storage<RootVegetable> {
    private CustomArrayList<RootVegetable> storage;
    private SortService<RootVegetable> sortService;

    public RootVegetableStorage() {
        this.storage = new CustomArrayList<>();
    }

    @Override
    public void add(RootVegetable item) {
        storage.add(item);
    }

    @Override
    public RootVegetable get(int index) {
        return storage.get(index);
    }

    @Override
    public List<RootVegetable> getAll() {
        return storage.getAll();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    public void sort(Comparator<? super RootVegetable> comparator) {
        storage.sort(comparator, sortService);
    }
}
package ru.home.storage;

import java.util.List;

public interface Storage<T> {
    void add(T item);

    T get(int index);

    List<T> getAll();

    void clear();
}
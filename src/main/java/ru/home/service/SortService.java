package ru.home.service;

import java.util.Comparator;

public interface SortService<T> {
    void sort(T[] array, Comparator<? super T> comparator);
}
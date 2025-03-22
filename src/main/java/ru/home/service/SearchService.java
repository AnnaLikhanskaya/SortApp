package ru.home.service;

import java.util.Comparator;

public interface SearchService<T> {
    int search(T[] array, T key, Comparator<? super T> comparator);
}
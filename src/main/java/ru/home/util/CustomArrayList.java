package ru.home.util;

import ru.home.service.SortService;
import ru.home.storage.Storage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomArrayList<T> implements Storage<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public CustomArrayList(int initSize) {
        elements = new Object[initSize];
        this.size = 0;
    }

    @Override
    public void add(T item) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    @Override
    public List<T> getAll() {
        return (List<T>) Arrays.asList(Arrays.copyOf(elements, size));
    }

    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public void sort(Comparator<? super T> comparator, SortService<T> sortStrategy) {
        T[] array = (T[]) Arrays.copyOf(elements, size);
        sortStrategy.sort(array, comparator);
        System.arraycopy(array, 0, elements, 0, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}

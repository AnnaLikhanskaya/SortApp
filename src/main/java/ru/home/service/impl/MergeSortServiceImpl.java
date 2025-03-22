package ru.home.service.impl;

import ru.home.service.SortService;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSortServiceImpl<T> implements SortService<T> {
    @Override
    public void sort(T[] array, Comparator<? super T> comparator) {
        if (array.length < 2) {
            return;
        }
        T[] aux = Arrays.copyOf(array, array.length);
        mergeSort(array, aux, comparator, 0, array.length);
    }

    private void mergeSort(T[] array, T[] aux, Comparator<? super T> comparator, int low, int high) {
        if (high - low < 2) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(aux, array, comparator, low, mid);
        mergeSort(aux, array, comparator, mid, high);
        merge(array, aux, comparator, low, mid, high);
    }

    private void merge(T[] array, T[] aux, Comparator<? super T> comparator, int low, int mid, int high) {
        int i = low, j = mid, k = low;
        while (i < mid && j < high) {
            if (comparator.compare(aux[i], aux[j]) <= 0) {
                array[k++] = aux[i++];
            } else {
                array[k++] = aux[j++];
            }
        }
        while (i < mid) {
            array[k++] = aux[i++];
        }
    }
}

package ru.home.service;

import java.util.Comparator;

public class BinarySearchService<T> implements SearchService<T> {
    @Override
    public int search(T[] array, T key, Comparator<? super T> comparator) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = comparator.compare(key, array[mid]);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
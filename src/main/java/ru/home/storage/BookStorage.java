package ru.home.storage;

import ru.home.model.Book;
import ru.home.service.SortService;
import ru.home.util.CustomArrayList;

import java.util.Comparator;
import java.util.List;

public class BookStorage implements Storage<Book> {
    private CustomArrayList<Book> storage;
    private SortService<Book> sortService;

    public BookStorage(SortService<Book> sortService) {
        this.storage = new CustomArrayList<>();
        this.sortService = sortService;
    }

    @Override
    public void add(Book item) {
        storage.add(item);
    }

    @Override
    public Book get(int index) {
        return storage.get(index);
    }

    @Override
    public List<Book> getAll() {
        return storage.getAll();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    public void sort(Comparator<? super Book> comparator) {
        storage.sort(comparator, sortService);
    }
}

package ru.home.validator;

import ru.home.model.Book;

public class BookValidator {

    public static boolean isValid(Book book) {
        return isValidAuthor(book.getAuthor()) &&
                isValidTitle(book.getTitle()) &&
                isValidPages(book.getPages());
    }

    private static boolean isValidAuthor(String author) {
        return author != null && !author.isEmpty();
    }

    private static boolean isValidTitle(String title) {
        return title != null && !title.isEmpty();
    }

    private static boolean isValidPages(int pages) {
        return pages > 0;
    }
}
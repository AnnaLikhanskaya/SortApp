package ru.home.validator;

import ru.home.model.Book;

public class BookValidator {

    public static boolean isValid(Book book) {
        if (!isValidAuthor(book.getAuthor())) {
            System.out.println("Ошибка: Некорректное имя автора. Имя автора не должно быть пустым.");
            return false;
        }
        if (!isValidTitle(book.getTitle())) {
            System.out.println("Ошибка: Некорректное название книги. Название книги не должно быть пустым.");
            return false;
        }
        if (!isValidPages(book.getPages())) {
            System.out.println("Ошибка: Некорректное количество страниц. Количество страниц должно быть больше 0.");
            return false;
        }
        return true;
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

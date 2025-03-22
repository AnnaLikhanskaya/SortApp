package ru.home.model;

import java.util.Comparator;
import ru.home.validator.BookValidator;

public class Book implements Comparable<Book> {
    private String author;
    private String title;
    private int pages;

    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pages = builder.pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public int compareTo(Book other) {
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) {
            return titleComparison;
        }
        int authorComparison = this.author.compareTo(other.author);
        if (authorComparison != 0) {
            return authorComparison;
        }
        return Integer.compare(this.pages, other.pages);
    }

    public static class BookComparator implements Comparator<Book> {
        @Override
        public int compare(Book b1, Book b2) {
            int titleComparison = b1.getTitle().compareTo(b2.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
            int authorComparison = b1.getAuthor().compareTo(b2.getAuthor());
            if (authorComparison != 0) {
                return authorComparison;
            }
            return Integer.compare(b1.getPages(), b2.getPages());
        }
    }

    public static class Builder {
        private String author;
        private String title;
        private int pages;

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            if (BookValidator.isValid(new Book(this))) {
                return new Book(this);
            } else {
                throw new IllegalArgumentException("Неккоретные данные об книге");
            }
        }
    }
}

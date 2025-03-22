package ru.home;

import ru.home.model.Book;
import ru.home.model.Car;
import ru.home.model.RootVegetable;
import ru.home.model.comparator.BookTitleComparator;
import ru.home.model.comparator.CarModelComparator;
import ru.home.model.comparator.RootVegetableTypeComparator;
import ru.home.service.*;
import ru.home.service.impl.FileServiceImpl;
import ru.home.service.impl.ManualServiceImpl;
import ru.home.service.impl.MergeSortServiceImpl;
import ru.home.service.impl.RandomServiceImpl;
import ru.home.storage.Storage;
import ru.home.util.CustomArrayList;
import ru.home.validator.BookValidator;
import ru.home.validator.CarValidator;
import ru.home.validator.RootVegetableValidator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileService fileService = new FileServiceImpl();
        RandomService randomService = new RandomServiceImpl();
        ManualService manualService = new ManualServiceImpl();
        SortService<Car> carSortService = new MergeSortServiceImpl<>();
        SortService<Book> bookSortService = new MergeSortServiceImpl<>();
        SortService<RootVegetable> rootVegetableSortService = new MergeSortServiceImpl<>();
        SearchService<Car> carSearchService = new BinarySearchService<>();
        SearchService<Book> bookSearchService = new BinarySearchService<>();
        SearchService<RootVegetable> rootVegetableSearchService = new BinarySearchService<>();

        Storage<Car> carStorage = new CustomArrayList<>();
        Storage<Book> bookStorage = new CustomArrayList<>();
        Storage<RootVegetable> rootVegetableStorage = new CustomArrayList<>();

        System.out.println("Добро пожаловать в приложение сортировки!");
        while (true) {
            System.out.println("Выберите тип объектов:");
            System.out.println("1. Автомобили");
            System.out.println("2. Книги");
            System.out.println("3. Корнеплоды");
            System.out.println("4. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleCarMenu(scanner, fileService, randomService, manualService, carSortService,
                            carStorage, carSearchService);
                    break;
                case 2:
                    handleBookMenu(scanner, fileService, randomService, manualService, bookSortService,
                            bookStorage, bookSearchService);
                    break;
                case 3:
                    handleRootVegetableMenu(scanner, fileService, randomService, manualService,
                            rootVegetableSortService, rootVegetableStorage, rootVegetableSearchService);
                    break;
                case 4:
                    System.out.println("Выход из программы. До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void handleCarMenu(Scanner scanner, FileService fileService, RandomService randomService,
                                      ManualService manualService, SortService<Car> sortService,
                                      Storage<Car> carStorage, SearchService<Car> carSearchService) {
        while (true) {
            System.out.println("Выберите действие для автомобилей:");
            System.out.println("1. Заполнить массив из файла");
            System.out.println("2. Заполнить массив случайными данными");
            System.out.println("3. Заполнить массив вручную");
            System.out.println("4. Бинарный поиск");
            System.out.println("5. Вернуться в главное меню");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Считываем оставшийся символ новой строки
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите число.");
                scanner.nextLine(); // Считываем оставшийся ввод, чтобы избежать бесконечного цикла
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Идет заполнение массива автомобилей из файла...");
                    Car[] cars = fileService.fillFromFileForCars("cars.txt");
                    for (Car car : cars) {
                        if (CarValidator.isValid(car)) {
                            carStorage.add(car);
                            System.out.println("Добавлен автомобиль: " + car.getModel());
                        } else {
                            System.out.println("Некорректные данные автомобиля. Пожалуйста, исправьте данные и попробуйте снова.");
                            return;
                        }
                    }
                    System.out.println("Данные из файла успешно загружены.");
                    break;
                case 2:
                    System.out.println("Идет заполнение массива автомобилей случайными данными...");
                    System.out.print("Введите количество автомобилей: ");
                    int size = 0;
                    try {
                        size = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите число.");
                        scanner.nextLine(); // Считываем оставшийся ввод, чтобы избежать бесконечного цикла
                        continue;
                    }
                    cars = randomService.fillRandomCars(size);
                    for (Car car : cars) {
                        if (CarValidator.isValid(car)) {
                            carStorage.add(car);
                            System.out.println("Добавлен автомобиль: " + car.getModel());
                        } else {
                            System.out.println("Некорректные данные автомобиля. Пожалуйста, исправьте данные и попробуйте снова.");
                            return;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Идет заполнение массива автомобилей вручную...");
                    System.out.print("Введите количество автомобилей: ");
                    try {
                        size = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите число.");
                        scanner.nextLine(); // Считываем оставшийся ввод, чтобы избежать бесконечного цикла
                        continue;
                    }
                    cars = manualService.fillManuallyCars(scanner, size);
                    for (Car car : cars) {
                        if (CarValidator.isValid(car)) {
                            carStorage.add(car);
                        } else {
                            System.out.println("Некорректные данные автомобиля. Пожалуйста, исправьте данные и попробуйте снова.");
                            return;
                        }
                    }
                    break;
                case 4:
                    if (carStorage.getAll().size() > 0) {
                        System.out.println("Идет выполнение бинарного поиска в массиве автомобилей...");
                        System.out.print("Введите модель автомобиля для поиска: ");
                        String model = scanner.nextLine();
                        Car[] carsArray = carStorage.getAll().toArray(new Car[0]);

                        sortService.sort(carsArray, new CarModelComparator());

                        Car searchKey = new Car.Builder().setModel(model).setPower(100).setYear(2000).build();

                        int index = carSearchService.search(carsArray, searchKey, new CarModelComparator());
                        if (index != -1) {
                            System.out.println("Автомобиль найден на позиции: " + index);
                        } else {
                            System.out.println("Автомобиль не найден.");
                        }
                    } else {
                        System.out.println("Массив автомобилей пуст. Пожалуйста, заполните его перед поиском.");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void handleBookMenu(Scanner scanner, FileService fileService, RandomService randomService, ManualService manualService, SortService<Book> sortService, Storage<Book> bookStorage, SearchService<Book> bookSearchService) {
        while (true) {
            System.out.println("Выберите действие для книг:");
            System.out.println("1. Заполнить массив из файла");
            System.out.println("2. Заполнить массив случайными данными");
            System.out.println("3. Заполнить массив вручную");
            System.out.println("4. Бинарный поиск по названию");
            System.out.println("5. Сортировка по названию, автору и количеству страниц");
            System.out.println("6. Сортировка по автору");
            System.out.println("7. Сортировка по количеству страниц");
            System.out.println("8. Вернуться в главное меню");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Считываем оставшийся символ новой строки
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите число.");
                scanner.nextLine(); // Считываем оставшийся ввод, чтобы избежать бесконечного цикла
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Идет заполнение массива книг из файла...");
                    Book[] books = fileService.fillFromFileForBooks("books.txt");
                    for (Book book : books) {
                        if (BookValidator.isValid(book)) {
                            bookStorage.add(book);
                            System.out.println("Добавлена книга: " + book.getTitle());
                        } else {
                            System.out.println("Некорректные данные книги. Пожалуйста, исправьте данные и попробуйте снова.");
                            return;
                        }
                    }
                    System.out.println("Данные из файла успешно загружены.");
                    break;
                case 2:
                    System.out.println("Идет заполнение массива книг случайными данными...");
                    System.out.print("Введите количество книг: ");
                    int size = 0;
                    try {
                        size = scanner.nextInt();
                        scanner.nextLine();
                        if (size <= 0) {
                            throw new IllegalArgumentException("Количество книг должно быть больше 0.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите число.");
                        scanner.nextLine(); // Считываем оставшийся ввод, чтобы избежать бесконечного цикла
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                        continue;
                    }
                    books = randomService.fillRandomBooks(size);
                    for (Book book : books) {
                        if (BookValidator.isValid(book)) {
                            bookStorage.add(book);
                            System.out.println("Добавлена книга: " + book.getTitle());
                        } else {
                            System.out.println("Некорректные данные книги. Пожалуйста, исправьте данные и попробуйте снова.");
                            return;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Идет заполнение массива книг вручную...");
                    System.out.print("Введите количество книг: ");
                    try {
                        size = scanner.nextInt();
                        scanner.nextLine();
                        if (size <= 0) {
                            throw new IllegalArgumentException("Количество книг должно быть больше 0.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите число.");
                        scanner.nextLine(); // Считываем оставшийся ввод, чтобы избежать бесконечного цикла
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                        continue;
                    }
                    books = manualService.fillManuallyBooks(scanner, size);
                    for (Book book : books) {
                        if (BookValidator.isValid(book)) {
                            bookStorage.add(book);
                        } else {
                            System.out.println("Некорректные данные книги. Пожалуйста, исправьте данные и попробуйте снова.");
                            return;
                        }
                    }
                    break;
                case 4:
                    if (bookStorage.getAll().size() > 0) {
                        System.out.println("Идет выполнение бинарного поиска в массиве книг...");
                        System.out.print("Введите название книги для поиска: ");
                        String title = scanner.nextLine();
                        Book[] booksArray = bookStorage.getAll().toArray(new Book[0]);

                        sortService.sort(booksArray, new BookTitleComparator());

                        Book searchKey = new Book.Builder().setTitle(title).setAuthor("Unknown").setPages(1).build();

                        int index = bookSearchService.search(booksArray, searchKey, new BookTitleComparator());
                        if (index != -1) {
                            System.out.println("Книга найдена на позиции: " + index);
                        } else {
                            System.out.println("Книга не найдена.");
                        }
                    } else {
                        System.out.println("Массив книг пуст. Пожалуйста, заполните его перед поиском.");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void handleRootVegetableMenu(Scanner scanner, FileService fileService, RandomService randomService, ManualService manualService, SortService<RootVegetable> sortService, Storage<RootVegetable> rootVegetableStorage, SearchService<RootVegetable> rootVegetableSearchService) {
        while (true) {
            System.out.println("Выберите действие для корнеплодов:");
            System.out.println("1. Заполнить массив из файла");
            System.out.println("2. Заполнить массив случайными данными");
            System.out.println("3. Заполнить массив вручную");
            System.out.println("4. Бинарный поиск по типу");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Считываем оставшийся символ новой строки
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите число.");
                scanner.nextLine(); // Считываем оставшийся ввод, чтобы избежать бесконечного цикла
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Идет заполнение массива корнеплодов из файла...");
                    RootVegetable[] rootVegetables = fileService.fillFromFileForRootVegetables("root_vegetables.txt");
                    for (RootVegetable rootVegetable : rootVegetables) {
                        if (RootVegetableValidator.isValid(rootVegetable)) {
                            rootVegetableStorage.add(rootVegetable);
                            System.out.println("Добавлен корнеплод: " + rootVegetable.getType());
                        } else {
                            System.out.println("Некорректные данные корнеплода. Пожалуйста, исправьте данные и попробуйте снова.");
                            return;
                        }
                    }
                    System.out.println("Данные из файла успешно загружены.");
                    break;
                case 2:
                    System.out.println("Идет заполнение массива корнеплодов случайными данными...");
                    System.out.print("Введите количество корнеплодов: ");
                    int size = 0;
                    try {
                        size = scanner.nextInt();
                        scanner.nextLine();
                        if (size <= 0) {
                            throw new IllegalArgumentException("Количество корнеплодов должно быть больше 0.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите число.");
                        scanner.nextLine(); // Считываем оставшийся ввод, чтобы избежать бесконечного цикла
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                        continue;
                    }
                    rootVegetables = randomService.fillRandomRootVegetables(size);
                    for (RootVegetable rootVegetable : rootVegetables) {
                        if (RootVegetableValidator.isValid(rootVegetable)) {
                            rootVegetableStorage.add(rootVegetable);
                            System.out.println("Добавлен корнеплод: " + rootVegetable.getType());
                        } else {
                            System.out.println("Некорректные данные корнеплода. Пожалуйста, исправьте данные и попробуйте снова.");
                            return;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Идет заполнение массива корнеплодов вручную...");
                    System.out.print("Введите количество корнеплодов: ");
                    try {
                        size = scanner.nextInt();
                        scanner.nextLine();
                        if (size <= 0) {
                            throw new IllegalArgumentException("Количество корнеплодов должно быть больше 0.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите число.");
                        scanner.nextLine(); // Считываем оставшийся ввод, чтобы избежать бесконечного цикла
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                        continue;
                    }
                    rootVegetables = manualService.fillManuallyRootVegetables(scanner, size);
                    for (RootVegetable rootVegetable : rootVegetables) {
                        if (RootVegetableValidator.isValid(rootVegetable)) {
                            rootVegetableStorage.add(rootVegetable);
                        } else {
                            System.out.println("Некорректные данные корнеплода. Пожалуйста, исправьте данные и попробуйте снова.");
                            return;
                        }
                    }
                    break;
                case 4:
                    if (rootVegetableStorage.getAll().size() > 0) {
                        System.out.println("Идет выполнение бинарного поиска в массиве корнеплодов...");
                        System.out.print("Введите тип корнеплода для поиска: ");
                        String type = scanner.nextLine();
                        RootVegetable[] rootVegetablesArray = rootVegetableStorage.getAll().toArray(new RootVegetable[0]);

                        sortService.sort(rootVegetablesArray, new RootVegetableTypeComparator());

                        RootVegetable searchKey = new RootVegetable.Builder().setType(type).setWeight(0.1).setColor("Unknown").build();

                        int index = rootVegetableSearchService.search(rootVegetablesArray, searchKey, new RootVegetableTypeComparator());
                        if (index != -1) {
                            System.out.println("Корнеплод найден на позиции: " + index);
                        } else {
                            System.out.println("Корнеплод не найден.");
                        }
                    } else {
                        System.out.println("Массив корнеплодов пуст. Пожалуйста, заполните его перед поиском.");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}
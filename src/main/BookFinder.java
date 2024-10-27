package main;

import java.util.*;
import java.util.stream.Collectors;

import static main.Author.Gender.FEMALE;
import static main.Author.Gender.MALE;

public class BookFinder {

    //find the age of the oldest author
    public static int exercise1(List<Book> books) {
        //write your code here;
        int i = books.stream()
                .mapToInt(a->a.getAuthor().getAge())
                .max()
                .orElse(0);
        return i;
    }

    //find the names of the 3 oldest authors, sorted by the length of the authors name, starting with the longest
    public static List<String> exercise2(List<Book> books) {
        //write your code here;
        List<String> x = books.stream()

                .map(Book::getAuthor)
                .sorted(Comparator.comparingInt(Author::getAge).reversed())
                .map(Author::getName)
                .distinct()
                .limit(3)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();

        List<String> q = books.stream()
                .map(Book::getAuthor)
                .sorted(Comparator.comparingInt(Author::getAge).reversed()
                        .thenComparing(author -> author.getName().length(), Comparator.reverseOrder()))
                .map(Author::getName)
                .distinct()
                .limit(3)
                .toList();


        return x;
    }

    //return 'true' if there are any male authors under 30 years old'
    public static boolean exercise3(List<Book> books) {
        //write your code here;
//        return books.stream()
//                .filter(q->q.getAuthor().getAge() <30 && q.getAuthor().getGender().equals(MALE))
//                .map(a->a.getAuthor().getName())
//                .toList();

        return books.stream()
                .anyMatch(q->q.getAuthor().getAge() <30 && q.getAuthor().getGender().equals(MALE));

    }

    //Get a map of the unique surnames and the author's ages, in uppercase of the first 5 authors that are 50 years or older
    public static Map<String, Integer> exercise4(List<Book> books) {
        Map<String, Integer> a = books.stream()
                .filter(q->q.getAuthor().getAge() >=50)
                .map(Book::getAuthor)
                .distinct()
               .limit(6)
                .collect(Collectors.toMap(x->x.getName().toUpperCase(), Author::getAge,
                        (existing, replacement) ->existing));

//        Map<String, Integer> surnameAgeMap = books.stream()
//                .map(Book::getAuthor) // Извлекаем авторов из книг
//                .filter(author -> author.getAge() >= 50) // Фильтруем по возрасту
//                .collect(Collectors.collectingAndThen(
//                        Collectors.toMap(
//                                author -> author.getName().toUpperCase(), // Фамилия в верхнем регистре
//                                Author::getAge, // Возраст автора
//                                (existingAge, newAge) -> existingAge // Оставляем существующий возраст при дубликате
//                        ),
//                        map -> map.entrySet().stream()
//                                .limit(5) // Ограничиваем количество
//                                .collect(Collectors.toMap(
//                                        Map.Entry::getKey,
//                                        Map.Entry::getValue
//                                ))
//                ));
        //write your code here
        return a;
    }

    //get the sum of all ages of all female authors under 25
    public static int exercise5(List<Book> books) {
        //write your code here;
        int i = books.stream()
                .filter(a->a.getAuthor().getAge()<25 && a.getAuthor().getGender().equals(FEMALE))
                .mapToInt(q->q.getAuthor().getAge())
                .sum();
        return i;
    }

}
    
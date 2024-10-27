package main;

import static main.Author.Gender;
import static main.Author.Gender.FEMALE;
import static main.Author.Gender.MALE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class BookFinderTest {

    List<Book> books;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        addBook("Irving", 50, FEMALE);
        addBook("George", 49, MALE);
        addBook("Johnson", 51, MALE);
        addBook("Manning", 25, FEMALE);
        addBook("George", 59, FEMALE);
        addBook("Nichols", 22, FEMALE);
        addBook("Beck", 67, FEMALE);
        addBook("Irving", 55, FEMALE);
        addBook("Charles", 14, MALE);
        addBook("Anderson", 25, MALE);
        addBook("Daniels", 98, FEMALE);
        addBook("Owen", 26, FEMALE);
        addBook("Pace", 21, FEMALE);
        addBook("Evans", 21, MALE);
        addBook("Daniels", 98, FEMALE);
        addBook("Evans", 21, MALE);
        addBook("Fielder", 66, FEMALE);
        addBook("Sharp", 76, FEMALE);
        addBook("Kearns", 88, FEMALE);
        addBook("Lee", 22, MALE);
        addBook("Richards", 19, FEMALE);
    }

    private void addBook(String surname, int age, Gender female) {
        books.add(new Book(new Author(age, surname, female)));
    }

    @Test
    public void exercise1() {
        int result = BookFinder.exercise1(books);
        System.out.println(result);
        assert(result == 98);
    }

    @Test
    public void exercise2() {
        List<String> result = BookFinder.exercise2(books);
        System.out.println(result);
        assert(result.size() == 3);
        assert(result.get(0).equals("Daniels"));
        assert(result.get(1).equals("Kearns"));
        assert(result.get(2).equals("Sharp"));
    }

    @Test
    public void exercise3a() {
        boolean result = BookFinder.exercise3(books);
        System.out.println(result);
        assert(result);
    }

    @Test
    public void exercise3b() {
        List<Book> shortBooks = new ArrayList<>();
        shortBooks.add(new Book(new Author(50, "Irving", FEMALE)));
        boolean result = BookFinder.exercise3(shortBooks);
        assert(!result);
    }

    @Test
    public void exercise4() {
        Map<String, Integer> result = BookFinder.exercise4(books);
        System.out.println(result);
        assert(result.size() == 5);
        assert(result.get("IRVING") == 50);
        assert(result.get("JOHNSON") == 51);
        assert(result.get("BECK") == 67);
        assert(result.get("DANIELS") == 98);
        assert(result.get("GEORGE") == 59);
    }

    @Test
    public void exercise5() {
        int result = BookFinder.exercise5(books);
        System.out.println(result);
        assert(result == 62);
    }

    @Test
    public void exercise6() {
        List<String> i =  Stream.of("Str", "kek", "lel", "lul", "erew")
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList());

        System.out.println(i);

    }

    @Test
    public void exercise7() {
        int i =  Stream.of(123, 3435, 212, 5655656, 44423421)
                .min(Integer::compare)
                .orElse(0);

        System.out.println(i);

    }
    @Test
    public void exercise8() {
        int i =  Stream.of(123, 3435, 212, 5655656, 44423421)
                .sorted()
                .distinct()
                .toList()
               .get(1);
        int s =  Stream.of(123, 3435, 212, 5655656, 44423421)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .toList()
                .get(1);
        System.out.println(i);
        System.out.println(s);

    }

    @Test
    public void name() {
        String s = "abba";
        String str = new StringBuilder(s)
                .reverse()
                .chars()
                .mapToObj(a -> String.valueOf((char) a))
                .collect(Collectors.joining());
        System.out.println(str);
        System.out.println(s.equals(str));
    }

//https://codefinity.com/courses/v2/190d2568-3d25-44d0-832f-da03468004c9/c0bcd017-ff39-46ec-bc93-acd569f3497d/d56d7f54-9992-491a-a50f-64ceee652f04
    @Test
    public void task1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers1 = numbers.stream()
                .map(a-> (int) Math.pow(a, 2))
                .toList();
        System.out.println(numbers1);
    }
    @Test
    public void task2() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        int i = names.stream()
                .map(String::length)
                .max(Integer::compare)
                        .orElse(0);
        System.out.println(i);
    }
    @Test
    public void task3() {
        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences."
        );
        List<String> i = sentences.stream()
                .flatMap(a->Arrays.stream(a.split("[\\s,.]+")))
                .map(String::toLowerCase)
                .distinct()
                        .toList();

        Long s = sentences.stream()
                .flatMap(a->Arrays.stream(a.split("[\\s,.]+")))
                .map(String::toLowerCase)
                .distinct()
                .count();
        System.out.println(i);
        System.out.println(s);

        long count = sentences.stream()
                .flatMap(e -> Arrays.stream(e.split(" ")))
                .distinct()
                .count();
        System.out.println(count);
    }

    @Test
    public void task4() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        String i = words.stream()
                .filter(a -> a.length() % 2 == 0)
                .limit(2)
                .collect(Collectors.joining());
        System.out.println(i);

    }

    @Test
    public void task5() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int i = numbers.stream()
                .filter(a -> a % 2 == 0)
                .mapToInt(a->a*a)
                .sum();

        System.out.println(i);

    }

    @Test
    public void task6() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        Map<Integer, List<String>> i = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(i);

    }

    public static void main(String[] args) {
        int s = (int) Stream.of("Str", "kek", "lel", "lul", "erew")
                        .filter(a->a.startsWith("l"))
                                .count();
        int i =  Stream.of("Str", "kek", "lel", "lul", "erew")
                .filter(a->a.matches("(?i)\\bL\\w*"))
                .mapToInt(a->1)
                .sum();
        System.out.println(i);

    }

}
package main;

import static main.Author.Gender;
import static main.Author.Gender.FEMALE;
import static main.Author.Gender.MALE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        assert(result == 98);
    }

    @Test
    public void exercise2() {
        List<String> result = BookFinder.exercise2(books);
        assert(result.size() == 3);
        assert(result.get(0).equals("Daniels"));
        assert(result.get(1).equals("Kearns"));
        assert(result.get(2).equals("Sharp"));
    }

    @Test
    public void exercise3a() {
        boolean result = BookFinder.exercise3(books);
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
        assert(result.size() == 5);
        assert(result.get("IRVING") == 50);
        assert(result.get("JOHNSON") == 51);
        assert(result.get("BECK") == 67);
        assert(result.get("DANIELS") == 98);
        assert(result.get("FIELDER") == 66);
    }

    @Test
    public void exercise5() {
        int result = BookFinder.exercise5(books);
        assert(result == 62);
    }
}
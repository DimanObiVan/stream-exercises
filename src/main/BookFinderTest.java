package main;

import static main.Author.Gender;
import static main.Author.Gender.FEMALE;
import static main.Author.Gender.MALE;

import java.util.ArrayList;
import java.util.List;

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
        addBook("Kearns", 88, FEMALE);
        addBook("Lee", 22, MALE);
        addBook("Richards", 19, FEMALE);
    }

    private void addBook(String surname, int age, Gender female) {
        books.add(new Book(new Author(age, surname, female)));
    }

    @Test
    public void exercise1() {
        List<String> result = BookFinder.exercise1(books);
        assert(result.size() == 5);
        assert(result.get(0).equals("IRVING"));
        assert(result.get(1).equals("JOHNSON"));
        assert(result.get(2).equals("BECK"));
        assert(result.get(3).equals("DANIELS"));
        assert(result.get(4).equals("FIELDER"));
    }

    //get the sum of all ages of all female authors under 25
    @Test
    public void exercise2() {
        int result = BookFinder.exercise2(books);
        assert(result == 62);
    }
}
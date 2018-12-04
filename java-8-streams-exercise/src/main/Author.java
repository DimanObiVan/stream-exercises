package main;

public class Author {

    private int age;
    private String name;
    private Gender gender;

    public Author(int age, String name, Gender gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    enum Gender {
        MALE, FEMALE;
    }

}

package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int id;
    private final String name;
    private final char sex;
    private final LocalDate birthDate;
    private final int postNumber;

    public ForumUser(int id, String name, char sex, int yearOfBirth, int mothOfBirth, int dayOfBirth, int postNumber) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthDate = LocalDate.of(yearOfBirth, mothOfBirth, dayOfBirth);
        this.postNumber = postNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostNumber() {
        return postNumber;
    }

    @Override
    public String toString() {
        return "User{'" + name + "', sex: '" + sex + '\'' +
        ", Birth Date: " + birthDate +
                ", Post Number: " + postNumber + '}';
    }
}

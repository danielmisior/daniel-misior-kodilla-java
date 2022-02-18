package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        //7.1.
        System.out.println("7.1.");
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("Poem Beautifier");
        poemBeautifier.beautify("An example of text", text -> "ABC " + text + " ABC");
        poemBeautifier.beautify("An example of text.", text -> text.toUpperCase());
        poemBeautifier.beautify("An example of text.", text -> "\"" +text + "\"");
        poemBeautifier.beautify("       example of text   ", text -> "An " + text.trim() + ".\n");

        //example
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n", "<<", ">>"));

        System.out.println(theResultStringOfBooks);

        //7.3.
        System.out.println("\n7.3.");
        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultMapOfUsers = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getBirthDate().getYear() <= 2002)
                .filter(forumUser -> forumUser.getPostNumber() > 0)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}

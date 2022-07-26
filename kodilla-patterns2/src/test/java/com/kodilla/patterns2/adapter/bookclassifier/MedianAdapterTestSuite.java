package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void medianPublicationYearTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> books = new HashSet<>();
        for (int i = 1; i <= 4; i++) {
            Book book = new Book("author" + i, "title" + i, 2000 + i, "XYZ" + i);
            books.add(book);
        }
        //When
        int result = medianAdapter.publicationYearMedian(books);
        //Then
        assertEquals(2002, result);
    }
}

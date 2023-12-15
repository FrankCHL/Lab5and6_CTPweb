package org.example;

import java.util.ArrayList;
import java.util.List;

public class BooksDao {

    //List<String> cars = new ArrayList<>();

    public void saveBooks(String book, int index) {
        List<String> books = new ArrayList<>();
        books.add(index, book);
    }

}

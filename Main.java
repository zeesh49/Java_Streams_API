package com.zeeshan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Book b1 = new Book("Harry Potter","J.K.Rowling",20.25);
        Book b2 = new Book("Harry Potter","J.K.Rowling",22.75);
        Book b3 = new Book("Harry Potter","J.K.Rowling",18.90);
        Book b4 = new Book("Harry Potter","J.K.Rowling",25.10);
        Book b5 = new Book("7 Habits","Stephen Covey",10.30);

        List<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(b1);
        listOfBooks.add(b2);
        listOfBooks.add(b3);
        listOfBooks.add(b4);
        listOfBooks.add(b5);

        List<Book> harryPotterBooks = new ArrayList<>();

        for (Book book:
             listOfBooks) {
            if (book.getTitle().equals("Harry Potter")){
                harryPotterBooks.add(book);
            }
        }

        harryPotterBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getPrice() > o2.getPrice()){
                    return 1;
                } else if(o1.getPrice() < o2.getPrice()){
                    return -1;
                }else return 0;
            }
        });

        System.out.println("Printing sorted Harry Potter books by price asc");

        for (Book book:
             harryPotterBooks) {
            System.out.println(book.toString());
        }

        harryPotterBooks = listOfBooks.stream()
                .filter(b -> b.getTitle() == "Harry Potter")
                .sorted(comparing(Book::getPrice))
                .collect(Collectors.toList());

        harryPotterBooks.forEach(System.out::println);
    }
}

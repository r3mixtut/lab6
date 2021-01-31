package com.example.students;

import java.util.ArrayList;
import java.util.Arrays;

public class Book {
    private String nameBook;
    private String author;
    public Book(String nameBook, String author){
        this.author = author;
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public String getNameBook() {
        return nameBook;
    }
     private  final  static ArrayList<Book> BOOKS = new ArrayList<Book>(
        Arrays.asList(
                new Book("Кристина", "Стивен Кинг"),
                new Book("Кладбище домашних животных","Стивен Кинг"),
                new Book("Оно", "Стивен Кинг"),
                new Book("Тёмная половина", "Стивен Кинг"),
                new Book("11/22/63", "Стивен Кинг"),
                new Book("История Лизи", "Стивен Кинг"),
                new Book("Дума Ки", "Стивен Кинг"),
                new Book("1408", "Стивен Кинг"),
                new Book("Страна радости", "Стивен Кинг"),
                new Book("Гарри Поттер и философский камень", "Джоан Роулинг"),
                new Book("Гарри Поттер и Тайная Комната","Джоан Роулинг"),
                new Book("Гарри Поттер и узник Азкабана", "Джоан Роулинг"),
                new Book("Гарри Поттер и Кубок Огня", "Джоан Роулинг"),
                new Book("Гарри Поттер и Орден Феникса", "Джоан Роулинг"),
                new Book("Гарри Поттер и Принц-Полукровка", "Джоан Роулинг"),
                new Book("Гарри Поттер и Дары Смерти", "Джоан Роулинг"),
                new Book("Гарри Поттер и проклятое дитя", "Джоан Роулинг"),
                new Book("Фантастические звери и места их обитания", "Джоан Роулинг"),
                new Book("Сказка о трех братьях", "Джоан Роулинг"),
                new Book("Моя жизнь. Мои достижения", "Генри Форд"),
                new Book("Кодекс миллиардера", "Генри Форд"),
                new Book("Время достижений", "Генри Форд"),
                new Book("Время – деньги", "Генри Форд"),
                new Book("Бизнес. Сегодня и завтра", "Генри Форд")



        )
     );
    public static  ArrayList<Book> getBooks (String author){
        ArrayList<Book> bookslist = new ArrayList<>();
        for(Book b : BOOKS){
            if(b.getAuthor().equals(author)){
                bookslist.add(b);
            }
        }
        return  bookslist;
    }

}

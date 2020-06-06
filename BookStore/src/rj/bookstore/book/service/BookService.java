package rj.bookstore.book.service;

import java.util.*;
import rj.bookstore.book.dao.BookDao;
import rj.bookstore.book.domain.Book;

public class BookService {

    private BookDao bookDao = new BookDao();


    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public List<Book> findByCategoryId(String id) {
        return bookDao.findByCategoryId(id);
    }

    public Book load(String bid) {
        return bookDao.findByBid(bid);
    }

    public void add(Book book) {
        bookDao.add(book);
    }

    public void delete(String bid) {
        bookDao.delete(bid);
    }

    public void edit(Book book) {
        bookDao.edit(book);
    }
}

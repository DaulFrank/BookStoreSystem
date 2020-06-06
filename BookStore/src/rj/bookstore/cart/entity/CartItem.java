package rj.bookstore.cart.entity;

import rj.bookstore.book.domain.Book;

import java.math.BigDecimal;

public class CartItem {

    private Book book;
    private int count;

    // 总计，处理了二进制误差问题
    public double getSubtotal(){

        BigDecimal d1 = new BigDecimal(book.getPrice());
        BigDecimal d2 = new BigDecimal(count);


        System.out.println(d1.multiply(d2).doubleValue());

        return d1.multiply(d2).doubleValue();
    }

    public CartItem(){}

    public CartItem(Book book, int count) {
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}

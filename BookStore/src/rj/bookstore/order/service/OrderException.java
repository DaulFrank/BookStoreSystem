package rj.bookstore.order.service;

public class OrderException extends Exception {
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }
}

package rj.bookstore.cart.web.servlet;

import cn.itcast.servlet.BaseServlet;
import rj.bookstore.book.domain.Book;
import rj.bookstore.book.service.BookService;
import rj.bookstore.cart.entity.Cart;
import rj.bookstore.cart.entity.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet(urlPatterns = "/CartServlet")
public class CartServlet extends BaseServlet {


    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        String bid = request.getParameter("bid");

        Book book = new BookService().load(bid);

        int count = Integer.parseInt(request.getParameter("count"));

        CartItem cartItem = new CartItem();

        System.out.println(book.getBid()+","+book.getBname());
        System.out.println(count);
        System.out.println("..................................................................................");

        cartItem.setBook(book);
        cartItem.setCount(count);

        cart.add(cartItem);

        return "f:jsps/cart/list.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.delete(request.getParameter("bid"));
        return "f:jsps/cart/list.jsp";
    }

    public String clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        return "f:jsps/cart/list.jsp";
    }
}

package rj.bookstore.book.web.servlet;

import cn.itcast.servlet.BaseServlet;
import rj.bookstore.book.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = "/BookServlet")
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookService();


    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("book",bookService.load(request.getParameter("bid")));
        return "f:jsps/book/desc.jsp";
    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("bookList",bookService.findAll());
        return "f:jsps/book/list.jsp";
    }


    public String findByCategoryId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("bookList",bookService.findByCategoryId(request.getParameter("cid")));;
        return "f:/jsps/book/list.jsp";
    }


}

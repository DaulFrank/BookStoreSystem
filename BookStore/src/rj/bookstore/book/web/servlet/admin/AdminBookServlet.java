package rj.bookstore.book.web.servlet.admin;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import rj.bookstore.book.domain.Book;
import rj.bookstore.book.service.BookService;
import rj.bookstore.category.domain.Category;
import rj.bookstore.category.servlce.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AdminBookServlet")
public class AdminBookServlet extends BaseServlet {

    private BookService bookService = new BookService();
    private CategoryService categoryService = new CategoryService();

    public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Book book = CommonUtils.toBean(request.getParameterMap(),Book.class);
       Category category = CommonUtils.toBean(request.getParameterMap(),Category.class);
       book.setCategory(category);
       bookService.edit(book);
       return findAll(request,response);
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookService.delete(request.getParameter("bid"));
        return findAll(request,response);
}

    public String addPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("categoryList",categoryService.findAll());
        return "f:adminjsps/admin/book/add.jsp";


    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("book",bookService.load(request.getParameter("bid")));
        request.setAttribute("category",categoryService.findAll());
        return "f:adminjsps/admin/book/desc.jsp";

    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("bookList",bookService.findAll());
        return "f:/adminjsps/admin/book/list.jsp";
    }
}

package rj.bookstore.category.web.servlet;

import cn.itcast.servlet.BaseServlet;
import rj.bookstore.category.servlce.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/CategoryServlet")
public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService = new CategoryService();


    public String findAll(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("categoryList",categoryService.findAll());

        return "f:/jsps/left.jsp";

    }
}

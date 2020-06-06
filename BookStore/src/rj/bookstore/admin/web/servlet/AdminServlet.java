package rj.bookstore.admin.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import rj.bookstore.admin.entity.Admin;
import rj.bookstore.admin.service.AdminService;
import rj.bookstore.cart.entity.Cart;
import rj.bookstore.user.domain.User;
import rj.bookstore.user.service.UserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(urlPatterns = "/AdminServlet")
public class AdminServlet extends BaseServlet {

    private AdminService adminService = new AdminService();


    public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        System.out.println(request.getParameter("username") + "," + request.getParameter("password"));
        Admin form = CommonUtils.toBean(request.getParameterMap(),Admin.class);

        try {
            Admin admin = adminService.login(form);
            request.getSession().setAttribute("session_admin",admin);
            return "r:/adminjsps/admin/main.jsp";
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.setAttribute("form",form);

            return "f:/adminjsps/login.jsp";
        }

    }

}

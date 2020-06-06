package rj.bookstore.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import rj.bookstore.cart.entity.Cart;
import rj.bookstore.user.domain.User;
import rj.bookstore.user.service.UserException;
import rj.bookstore.user.service.UserService;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@WebServlet(urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserService();

    public String quit(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        request.getSession().invalidate();

        return "r:/jsps/main.jsp";

    }

    public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        System.out.println(request.getParameter("username") + "," + request.getParameter("password"));
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);

        try {
            User user = userService.login(form);
            request.getSession().setAttribute("session_user",user);
            // 登录成功就发车
            request.getSession().setAttribute("cart",new Cart());
            return "r:/jsps/main.jsp";
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.setAttribute("form",form);

            return "f:/login.jsp";
        }

    }



    public String active(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("您激活了！");
        return null;
    }

    public String regist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,UserException {
        request.setCharacterEncoding("utf-8");
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);

        System.out.println(request.getParameter("username"));

        form.setUid(CommonUtils.uuid());
        form.setCode(CommonUtils.uuid() + CommonUtils.uuid());

        Map<String, String> errors = new HashMap<String, String>();

        String username = form.getUsername();
        if (username == null || username.trim().isEmpty()) {
            errors.put("username", "用户名不能为空！");
        } else if (username.length() < 3 || username.length() > 10) {
            errors.put("username", "用户名长度必须在3~10之间！");
        }

        String password = form.getPassword();
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空！");
        } else if (password.length() < 3 || password.length() > 10) {
            errors.put("password", "密码长度必须在3~10之间！");
        }

        String email = form.getEmail();
        if (email == null || email.trim().isEmpty()) {
            errors.put("email", "Email不能为空！");
        } else if (!email.matches("\\w+@\\w+\\.\\w+")) {
            errors.put("email", "Email格式错误！");
        }

        if (errors.size() > 0) {

            request.setAttribute("errors", errors);
            request.setAttribute("form", form);
            return "f:/regist.jsp";
        }

        /*
         * 调用service的regist()方法
         */
        try {
            userService.regist(form);
        } catch (UserException e) {
            /*
             * 1. 保存异常信息
             * 2. 保存form
             * 3. 转发到regist.jsp
             */
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("form", form);
            return "f:/regist.jsp";
        }


        request.setAttribute("msg", "恭喜，注册成功！");
        return "f:/jsps/msg.jsp";
    }
}

package rj.bookstore.filter;

import rj.bookstore.user.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/CartServlet")
public class Login1Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        User user = (User) httpServletRequest.getSession().getAttribute("session_user");

        if(user != null) {
            chain.doFilter(req, resp);
        } else {
            httpServletRequest.setAttribute("msg","您还没有登录哟!!!");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}

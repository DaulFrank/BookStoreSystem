package rj.bookstore.order.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import rj.bookstore.cart.entity.Cart;
import rj.bookstore.cart.entity.CartItem;
import rj.bookstore.order.entity.Order;
import rj.bookstore.order.entity.OrderItem;
import rj.bookstore.order.service.OrderException;
import rj.bookstore.order.service.OrderService;
import rj.bookstore.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

@WebServlet(urlPatterns = "/OrderServlet")
public class OrderServlet extends BaseServlet {
   private OrderService orderService = new OrderService();


    public String confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            orderService.confirm(request.getParameter("oid"));
            request.setAttribute("msg","成功了");
        } catch (OrderException e) {
//            e.printStackTrace();
            request.setAttribute("msg",e.getMessage());
        }
        return "f:/jsps/msg.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("order",orderService.load(request.getParameter("oid")));
        return "f:jsps/order/desc.jsp";
    }

    // 我的订单
    public String myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("session_user");
        List<Order> orderList = orderService.myOrders(user.getUid());
        request.setAttribute("orderList",orderList);
        return "f:jsps/order/list.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        Order order = new Order();
        order.setOid(CommonUtils.uuid());
        order.setOrdertime(new Date());
        order.setState(1);
        User user = (User) request.getSession().getAttribute("session_user");

        order.setOwner(user);
        order.setTotal(cart.getTotal());


        List<OrderItem> orderItemList = new ArrayList<OrderItem>();

        for(CartItem cartItem:cart.getCartItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setIid(CommonUtils.uuid());
            orderItem.setCount(cartItem.getCount());
            orderItem.setBook(cartItem.getBook());
            orderItem.setSubtotal(cartItem.getSubtotal());
            orderItem.setOrder(order);
            orderItemList.add(orderItem);
        }
       order.setOrderItemList(orderItemList);


        cart.clear();

        orderService.add(order);

        request.setAttribute("order",order);
        return "f:jsps/order/desc.jsp";

    }
}

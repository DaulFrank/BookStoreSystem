package rj.bookstore.order.service;

import cn.itcast.jdbc.JdbcUtils;
import rj.bookstore.order.dao.OrderDao;
import rj.bookstore.order.entity.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderDao orderDao = new OrderDao();

    public void add(Order order) {
        try{
            JdbcUtils.beginTransaction();
            orderDao.addOrder(order);
            orderDao.addOrderItem(order.getOrderItemList());
            JdbcUtils.commitTransaction();

        }catch (Exception e) {
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    public List<Order> myOrders(String uid) {
        return orderDao.findById(uid);
    }

    public Order load(String oid) {
        return orderDao.load(oid);
    }

    public void confirm(String oid) throws OrderException {
        int state = orderDao.getState(oid);
        if(state != 3) {
            throw new OrderException("订单确认失败!");
        }

        orderDao.updateState(oid,4);
    }

}

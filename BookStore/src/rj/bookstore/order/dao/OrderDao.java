package rj.bookstore.order.dao;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import rj.bookstore.book.domain.Book;
import rj.bookstore.order.entity.Order;
import rj.bookstore.order.entity.OrderItem;

import javax.print.attribute.standard.RequestingUserName;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class OrderDao {
    private QueryRunner qr = new TxQueryRunner();

    public void addOrder(Order order){
        try{

            String sql = "insert into orders values(?,?,?,?,?,?)";
            Timestamp timestamp = new Timestamp(order.getOrdertime().getTime());
            Object[] params = {order.getOid(),timestamp,order.getTotal(),
                            order.getState(),order.getOwner().getUid(),
                            order.getAddress()};

            qr.update(sql,params);


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 批处理
    public void addOrderItem(List<OrderItem> orderItemList){
        try{

            String sql = "insert into orderitem values(?,?,?,?,?)";
            Object[][] params = new Object[orderItemList.size()][];
            for(int i = 0; i < orderItemList.size(); i ++) {
                OrderItem item = orderItemList.get(i);
                params[i] = new Object[]{item.getIid(),item.getCount(),item.getSubtotal(),item
                .getOrder().getOid(),item.getBook().getBid()};
            }
           qr.batch(sql,params);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> findById(String uid) {
        try {
            String sql = "select * from orders where uid=?";
            List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class), uid);

            for(Order order : orderList) {
                loadOrderItems(order);      // 为 order 添加它的所有订单条目
            }

            return orderList;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void loadOrderItems(Order order) throws SQLException {

        String sql = "select * from orderitem i,book b where i.bid = b.bid and oid = ?";

        List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), order.getOid());

        List<OrderItem> orderItems = toOrderItemList(mapList);
        order.setOrderItemList(orderItems);

    }

    private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
        List<OrderItem> orderItemList = new ArrayList<>();
        for(Map<String,Object> map:mapList) {
            OrderItem item = toOrderItem(map);
            orderItemList.add(item);
        }
        return orderItemList;
    }

    private OrderItem toOrderItem(Map<String, Object> map) {
            OrderItem orderItem = CommonUtils.toBean(map,OrderItem.class);
            Book book = CommonUtils.toBean(map,Book.class);

            orderItem.setBook(book);
            return orderItem;

    }

    public Order load(String oid) {
        try{
            String sql = "select * from orders where oid = ?";
            Order order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);
            loadOrderItems(order);  // 代码重用
            return order;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getState(String oid) {
        try {
            String sql = "select state from orders where oid = ?";
            Number num = (Number) qr.query(sql,new ScalarHandler(),oid);
            return num.intValue();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String oid,int state) {
        try {

            String sql = "update orders set state = ? where oid = ?";
            qr.update(sql,state,oid);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

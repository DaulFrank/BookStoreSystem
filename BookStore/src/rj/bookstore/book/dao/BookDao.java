package rj.bookstore.book.dao;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

import java.sql.SQLException;
import java.util.*;

import com.sun.org.apache.bcel.internal.generic.ATHROW;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import rj.bookstore.book.domain.Book;
import rj.bookstore.category.domain.Category;

public class BookDao {

    private QueryRunner qr = new TxQueryRunner();

    public List<Book> findAll() {

        String sql = "select * from book where del = false";

        try {

           return qr.query(sql,new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> findByCategoryId(String id) {

        String sql = "select * from book where cid = ? and del = false";

        try {
            return qr.query(sql,new BeanListHandler<>(Book.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Book findByBid(String bid) {
        try {
            String sql = "select * from book where bid = ?";
            Map<String,Object> map = qr.query(sql,new MapHandler(),bid);
            Category category = CommonUtils.toBean(map,Category.class);
            Book book = CommonUtils.toBean(map,Book.class);

            book.setCategory(category);
            return book;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCountByCid(String cid) {
        String sql = "select count(*) from book where cid = ?";
        try {

            Number cnt = (Number) qr.query(sql,new ScalarHandler(),cid);
            return cnt.intValue();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Book book) {

        try{
            String sql = "insert into book values(?,?,?,?,?,?)";
            Object[] params = {book.getBid(),book.getBname(),book.getPrice(),book.getAuthor(),book.getImage(),book.getCategory().getCid()};
            qr.update(sql,params);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(String bid) {
        try{
            String sql = "update book set del=true where bid = ?";

            qr.update(sql,bid);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(Book book) {
        try{
            String sql = "update book set bname=?,price=?,author=?,image=?,cid=? where bid = ?";
            Object[] params = {book.getBname(),book.getPrice(),book.getAuthor(),book.getImage(),book.getCategory().getCid(),book.getBid()};
            qr.update(sql,params);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

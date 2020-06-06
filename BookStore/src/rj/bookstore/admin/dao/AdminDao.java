package rj.bookstore.admin.dao;

import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import rj.bookstore.admin.entity.Admin;
import rj.bookstore.user.domain.User;

import java.sql.SQLException;

public class AdminDao {
    private QueryRunner qr = new TxQueryRunner();

    /**
     *  通过姓名查找用户
     *
     * */

    public Admin findByUsername(String username) {
        try{
            String sql = "select * from adminuser where adminname = ?";
            return qr.query(sql,new BeanHandler<Admin>(Admin.class),username);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

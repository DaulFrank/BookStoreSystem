package rj.bookstore.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.TxQueryRunner;
import rj.bookstore.user.domain.User;

/**
 *  User 持久层
 *
 *
 * */

public class UserDao {

    private QueryRunner qr = new TxQueryRunner();

    /**
     *  通过姓名查找用户
     *
     * */

    public User findByUsername(String username) {
        try{
            String sql = "select * from tb_user where username = ?";
            return qr.query(sql,new BeanHandler<User>(User.class),username);
        }catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }


    /**
     *     通过 Email 查找
     * */
    public User findByEmail(String email) {
        try{
            String sql = "select * from tb_user where email = ?";
            return qr.query(sql,new BeanHandler<User>(User.class),email);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *   添加用户
     * */
    public void add1(User user) {
        try {
            String sql = "insert into tb_user values(?,?,?,?,?)";

            Object[] params = {user.getUid(), user.getUsername(), user.getPassword(), user.getEmail(), user.isState()};

            qr.update(sql, params);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(User user) {
        try {
            String sql = "insert into tb_user values(?,?,?,?,?,?)";
            Object[] params = {user.getUid(), user.getUsername(),
                    user.getPassword(), user.getEmail(), user.getCode(),
                    user.isState()};
            qr.update(sql, params);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }



}

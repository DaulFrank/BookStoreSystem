package rj.bookstore.user.service;

import rj.bookstore.user.dao.UserDao;
import rj.bookstore.user.domain.User;

/**
 *  业务逻辑层
 *
 *
 * */

public class UserService {

    UserDao userDao = new UserDao();

    /**
     *  注册功能
     *
     *
     * */

    public void regist(User form) throws UserException {
        User user = userDao.findByUsername(form.getUsername());
        if(user != null) throw new UserException("用户名已经被注册");

        user = userDao.findByEmail(form.getEmail());
        if(user != null) throw new UserException("Email 已经注册！");

        userDao.add(form);
    }

    public User login(User form) throws UserException {

        User user = userDao.findByUsername(form.getUsername());

        if(user == null) throw new UserException("用户名不存在");

        if(!user.getPassword().equals(form.getPassword())) {
            throw  new UserException("密码错误!");
        }

        return user;


    }
}

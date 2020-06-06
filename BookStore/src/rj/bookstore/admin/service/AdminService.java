package rj.bookstore.admin.service;

import rj.bookstore.admin.dao.AdminDao;
import rj.bookstore.admin.entity.Admin;
import rj.bookstore.user.domain.User;
import rj.bookstore.user.service.UserException;

public class AdminService {

    AdminDao adminDao = new AdminDao();
    public Admin login(Admin form) throws UserException {

        Admin admin = adminDao.findByUsername(form.getAdminname());

        if(admin == null) throw new UserException("用户名不存在");

        if(!admin.getPassword().equals(form.getPassword())) {
            throw  new UserException("密码错误!");
        }

        return admin;


    }
}

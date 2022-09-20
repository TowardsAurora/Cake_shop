package service;

import dao.UserDao;
import model.User;
import model.Page;
import java.util.List;
import java.sql.SQLException;

public class UserService {


    //定义private userDao成员
    private UserDao userDao = new UserDao();

    //判断用户是否已注册
    public boolean register(User user) {
        try {
            if(userDao.isUsernameExist(user.getUsername())) {
                return false;
            }
            if(userDao.isEmailExist(user.getEmail())) {
                return false;
            }
            userDao.addUser(user);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    //用户登录功能
    public User login(String ue,String password) {
        User user=null;
        try {
            user = userDao.selectByUsernamePassword(ue, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(user!=null) {
            return user;
        }
        try {
            user= userDao.selectByEmailPassword(ue, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(user!=null) {
            return user;
        }
        return null;
    }

    //根据用户id来选择用户
    public User selectById(int id) {
        User u=null;
        try {
            u = userDao.selectById(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return u;
    }

    //更新用户地址
    public void updateUserAddress(User user) {
        try {
            userDao.updateUserAddress(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //更新用户密码
    public void updatePwd(User user) {
        try {
            userDao.updatePwd(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //获取用户界面
    public Page getUserPage(int pageNumber) {
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int pageSize = 7;
        int totalCount = 0;
        try {
            totalCount = userDao.selectUserCount();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(pageSize, totalCount);
        List list=null;
        try {
            list = userDao.selectUserList( pageNumber, pageSize);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    //判断用户id是否被删除
    public boolean delete(int id ) {
        try {
            userDao.delete(id);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}

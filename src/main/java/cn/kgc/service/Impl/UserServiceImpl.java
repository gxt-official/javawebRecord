package cn.kgc.service.Impl;

import cn.kgc.dao.UserDao;
import cn.kgc.entity.User;
import cn.kgc.service.UserService;

import java.util.List;

/**
 * @author mr
 * @Date 2019/10/17 16:40
 */
public class UserServiceImpl implements UserService {
    @Override
    public void saveUserIntoDB(User user) {
        UserDao userDao = new UserDao ();
        userDao.insertUser (user.getUsername (),user.getPwd (),user.getSex (),user.getHobby ());
    }

    @Override
    public User getUserbyNameAndPwd(String name, String pwd) {
        //通过dao层获取数据库数据
        UserDao userDao = new UserDao ();
        List<User> users = userDao.selectUser (name, pwd);
        if (users != null && users.size () == 1) {
            return users.get (0);
        }
        return null;
    }

    @Override
    public User getUserbyID(String id) {
        UserDao userDao = new UserDao ();
        User user = new User ();
        user = userDao.selectUser (id).get (0);
        return user;
    }

    @Override
    public List<User> selectAllInfo() {
        UserDao userDao = new UserDao ();
        List<User> users = userDao.selectAllUser ();
        return users;
    }

    @Override
    public User updateUser() {
        return null;
    }
}

package cn.kgc.service;

import cn.kgc.entity.User;

import java.util.List;

/**
 * @author mr
 * @Date 2019/10/17 16:35
 */
public interface UserService {
    //把数据存到数据库(注册功能)
    void saveUserIntoDB(User user);

    //通过用户名和密码获得唯一的一个用户对象(验证登录)
    User getUserbyNameAndPwd(String name, String pwd);

    //通过id获得唯一的一个用户对象(修改)
    User getUserbyID(String id);

    //查询所有数据库数据(展示数据)
    List<User> selectAllInfo();

    //更新数据
    User updateUser();
}

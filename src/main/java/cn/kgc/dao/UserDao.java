package cn.kgc.dao;

import cn.kgc.entity.User;
import cn.kgc.util.JDBCUtil;
import com.mysql.jdbc.Driver;
import jdk.nashorn.internal.scripts.JD;

import javax.jws.soap.SOAPBinding;
import java.io.RandomAccessFile;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mr
 * @Date 2019/10/16 15:45
 */
public class UserDao {
    /**
     * 查询user所有数据
     */
    public List<User> selectAllUser() {
        Connection connection = JDBCUtil.getConnection ();
        List<User> users = new ArrayList<> ();
        //3、创建可以执行sql语句的对象
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement ();
            //4、执行sql语句
            String sql = "select * from user";
            resultSet = statement.executeQuery (sql);
            //5、处理结果集
            while (resultSet.next ()) {
                users.add (new User (resultSet.getString ("id"),resultSet.getString ("name"), resultSet.getString ("pwd"), resultSet.getString ("sex"), resultSet.getString ("hobby")));

                //可以通过列号获取
//                String string1 = resultSet.getString (1);
//                String string2 = resultSet.getString (2);
//                //也可以通过列名获取
//                String string3 = resultSet.getString ("pwd");
//                String string4 = resultSet.getString ("sex");
//                System.out.println (string1 + "\t" + string2 + "\t\t" + string3 + "\t\t" + string4);
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }finally {
            //6、释放资源
            JDBCUtil.release (connection,statement,resultSet);
        }
        return users;
    }

    /**
     * 带条件查询
     */
    public List<User> selectUser(String name, String pwd) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<User> users = new ArrayList<> ();
        try {
            connection = JDBCUtil.getConnection ();
            String sql = "select * from user where name=? and pwd=?";
            System.out.println (sql);
            preparedStatement = connection.prepareStatement (sql);
            preparedStatement.setString (1, name);
            preparedStatement.setString (2, pwd);

            resultSet = preparedStatement.executeQuery ();
            while (resultSet.next ()) {
                users.add (new User (resultSet.getString ("id"),resultSet.getString ("name"), resultSet.getString ("pwd"), resultSet.getString ("sex"), resultSet.getString ("hobby")));
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }finally {
            JDBCUtil.release (connection, preparedStatement, resultSet);
        }
        return users;
    }


    public List<User> selectUser(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<User> users = new ArrayList<> ();
        try {
            connection = JDBCUtil.getConnection ();
            String sql = "select * from user where id=?";
            System.out.println (sql);
            preparedStatement = connection.prepareStatement (sql);
            preparedStatement.setString (1, id);

            resultSet = preparedStatement.executeQuery ();
            while (resultSet.next ()) {
                users.add (new User (resultSet.getString ("id"),resultSet.getString ("name"), resultSet.getString ("pwd"), resultSet.getString ("sex"), resultSet.getString ("hobby")));
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }finally {
            JDBCUtil.release (connection, preparedStatement, resultSet);
        }
        return users;
    }

    /**
     * 更新user数据
     */
    public void updateUser(User user) {
        Connection connection = JDBCUtil.getConnection ();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "update user set name=?,pwd=?,sex=?,hobby=? where id=?";
            preparedStatement = connection.prepareStatement (sql);
            preparedStatement.setString (1, user.getUsername ());
            preparedStatement.setString (2, user.getPwd ());
            preparedStatement.setString (3, user.getSex ());
            preparedStatement.setString (4, user.getHobby ());
            preparedStatement.setString (5, user.getId ());

            int i = preparedStatement.executeUpdate ();
            System.out.println ("受影响的行数：" + i);
        } catch (SQLException e) {
            e.printStackTrace ();
        }finally {
            JDBCUtil.release (connection,preparedStatement);
        }
    }

    /**
     * 插入user数据
     */
    public void insertUser(String name,String pwd,String sex,String hobby) {
        Connection connection = JDBCUtil.getConnection ();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into user (name,pwd,sex,hobby) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement (sql);
            preparedStatement.setString (1, name);
            preparedStatement.setString (2, pwd);
            preparedStatement.setString (3, sex);
            preparedStatement.setString (4, hobby);

            int i = preparedStatement.executeUpdate ();
            System.out.println ("影响行数："+i);
        } catch (SQLException e) {
            e.printStackTrace ();
        }finally {
            JDBCUtil.release (connection,preparedStatement);
        }
    }

    /**
     * 删除user数据
     */
    public void deleteUser(String where) {
        Connection connection = JDBCUtil.getConnection ();
        Statement statement = null;
        try {
            statement = connection.createStatement ();
            String sql = "delete from user where "+where;
            int i = statement.executeUpdate (sql);
            System.out.println ("受影响的行数：" + i);
        } catch (SQLException e) {
            e.printStackTrace ();
        }finally {
            JDBCUtil.release (connection, statement);
        }
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao ();
        userDao.selectUser ("奥特曼","123");
    }
}

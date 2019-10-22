import cn.kgc.dao.UserDao;
import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.*;

/**
 * @author mr
 * @Date 2019/10/16 14:14
 */
public class TestUser {

    @Test
    public void test1() throws SQLException {
        //1、加载驱动
        DriverManager.registerDriver (new Driver ());
        //2、连接数据库
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection (url, user, password);
        //3、创建可以执行sql语句的对象
        Statement statement = connection.createStatement ();
        //4、执行sql语句
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery (sql);
        //5、处理结果集
        while (resultSet.next ()) {
            //可以通过列号获取
            String string1 = resultSet.getString (1);
            String string2 = resultSet.getString (2);
            //也可以通过列名获取
            String string3 = resultSet.getString ("pwd");
            String string4 = resultSet.getString ("sex");
            System.out.println (string1 + "\t" + string2 + "\t\t" + string3 + "\t\t" + string4);
        }
        //6、释放资源
        resultSet.close ();
        statement.close ();
        connection.close ();
    }

    @Test
    public void test2() throws SQLException, ClassNotFoundException {
//        DriverManager.registerDriver (new Driver ());
        Class.forName ("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection (url, user, password);
        Statement statement = connection.createStatement ();
        String sql = "update user set pwd='bcd' where name='奥特曼'";
        int i = statement.executeUpdate (sql);
        System.out.println ("受影响的行数：" + i);
        statement.close ();
        connection.close ();
    }

    @Test
    public void test3() throws SQLException {
        UserDao userDao = new UserDao ();
//        userDao.selectUser ();
    }

    @Test
    public void test4() throws SQLException {
        DriverManager.registerDriver (new Driver ());
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection (url, user, password);
        Statement statement = connection.createStatement ();
        String sql = "insert into user (name,pwd,sex) values('特曼','124','男')";
        int i = statement.executeUpdate (sql);
        System.out.println ("受影响的行数：" + i);
        statement.close ();
        connection.close ();
    }
}

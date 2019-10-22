package cn.kgc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author mr
 * @Date 2019/10/16 15:39
 */
public class JDBCUtil {
    static String driver = null;
    static String url = null;
    static String user = null;
    static String pwd = null;
    static {
        //加载配置信息，获取资源文件里的配置信息
        Properties properties = new Properties ();
        InputStream resourceAsStream = JDBCUtil.class.getClassLoader ().getResourceAsStream ("database.properties");
        try {
            properties.load (resourceAsStream);
            driver = properties.getProperty ("mysql.driver");
            url = properties.getProperty ("mysql.url");
            user = properties.getProperty ("mysql.username");
            pwd = properties.getProperty ("mysql.password");
        } catch (IOException e) {
            e.printStackTrace ();
        }finally {
            try {
                if (resourceAsStream != null) {
                    resourceAsStream.close ();
                }
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName (driver);
            connection = DriverManager.getConnection (url, user, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return connection;
    }

    public static void release(Connection connection, Statement statement,ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close ();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        release (connection,statement);
    }
    public static void release(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close ();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        try {
            if (connection != null) {
                connection.close ();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public static void release(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close ();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        try {
            if (connection != null) {
                connection.close ();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close ();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        release (connection, preparedStatement);

    }
}

package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 * @author te9uila
 * @since 2023/7/18
 */
public class DBUtil {
    private static final String USER_NAME = "root";

    private static final String PASSWORD = "zjc123456";

    private static final String URL = "jdbc:mysql://8.130.20.75:3306/Test?characterEncoding=utf8";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败！");
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (SQLException e) {
            System.out.println("连接获取失败！");
            return null;
        }
    }
}

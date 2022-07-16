import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-06-16 16:50:31
 */
public class JDBCUtils {
    private static final String dirver;
    private static final String url;
    private static final String username;
    private static final String password;


    static{
        Properties ps = new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("JDBC.properties");

        try {
            ps.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dirver = ps.getProperty("dirver");
        url = ps.getProperty("url");
        username = ps.getProperty("username");
        password = ps.getProperty("password");
    }

    // 连接数据库
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(dirver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

// 关闭连接


public static void closeConnection(Connection conn, PreparedStatement pst) {
        if (pst != null) {
            try {
                pst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement pst, ResultSet rs) {
        if (pst != null) {
            try {
                pst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }






}

package cn.ziroom.mybatis.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**   
 * @Title JDBCUtils.java 
 * @Package cn.ziroom.mybatis.jdbc 
 * @Description:JDBC工具类
 * @author dfx  
 * @date 2015-11-24 上午9:49:28 
 * @version V1.0   
 */
public class JDBCUtils {
	
	 //连接数据库的参数
    private static String url = null;		//url
    private static String user = null;		//用户名
    private static String driver = null;	//驱动
    private static String password = null;	//密码
	
	//私有构造方法
	private JDBCUtils(){
	}
	
	private static JDBCUtils instance = null;
	 
    public static JDBCUtils getInstance() {
        if (instance == null) {
            synchronized (JDBCUtils.class) {
                if (instance == null) {
                    instance = new JDBCUtils();
                }
            }
        }
        return instance;
    }
	
    //配置文件
    private static Properties prop = new Properties();
     
    //注册驱动
    static {
        try {
            //利用类加载器读取配置文件
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(is);
            url = prop.getProperty("jdbc.url");
            user = prop.getProperty("jdbc.username");
            driver = prop.getProperty("jdbc.driver");
            password = prop.getProperty("jdbc.password");
             
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * @Description:获取数据库连接
	 * @return Connection conn
	 */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    //================================BEGIN===============================
    
    /**
     * @Description:释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public void free(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
            	//释放结果集
                rs.close();
            } catch (SQLException e) {
                System.out.println("关闭ResultSet失败!");  
                e.printStackTrace();
            } finally {
                if (st != null) {
                    try {
                    	//释放Statement
                        st.close();
                    } catch (SQLException e) {
                        System.out.println("关闭Statement失败!"); 
                        e.printStackTrace();
                    } finally {
                        if (conn != null) {
                            try {
                            	//释放链接connection
                                conn.close();
                            } catch (SQLException e) {
                                 System.out.println("关闭Connection失败!"); 
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
    
    //================================END===============================
}

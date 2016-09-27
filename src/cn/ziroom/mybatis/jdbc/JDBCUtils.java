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
 * @Description:JDBC������
 * @author dfx  
 * @date 2015-11-24 ����9:49:28 
 * @version V1.0   
 */
public class JDBCUtils {
	
	 //�������ݿ�Ĳ���
    private static String url = null;		//url
    private static String user = null;		//�û���
    private static String driver = null;	//����
    private static String password = null;	//����
	
	//˽�й��췽��
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
	
    //�����ļ�
    private static Properties prop = new Properties();
     
    //ע������
    static {
        try {
            //�������������ȡ�����ļ�
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
	 * @Description:��ȡ���ݿ�����
	 * @return Connection conn
	 */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    //================================BEGIN===============================
    
    /**
     * @Description:�ͷ���Դ
     * @param conn
     * @param st
     * @param rs
     */
    public void free(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
            	//�ͷŽ����
                rs.close();
            } catch (SQLException e) {
                System.out.println("�ر�ResultSetʧ��!");  
                e.printStackTrace();
            } finally {
                if (st != null) {
                    try {
                    	//�ͷ�Statement
                        st.close();
                    } catch (SQLException e) {
                        System.out.println("�ر�Statementʧ��!"); 
                        e.printStackTrace();
                    } finally {
                        if (conn != null) {
                            try {
                            	//�ͷ�����connection
                                conn.close();
                            } catch (SQLException e) {
                                 System.out.println("�ر�Connectionʧ��!"); 
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

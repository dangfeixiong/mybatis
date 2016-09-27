package cn.ziroom.mybatis.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

/**   
 * @Title JDBCExample.java 
 * @Package cn.ziroom.mybatis.jdbc 
 * @Description:使用JDBC进行测试CRUD
 * @author dfx  
 * @date 2015-11-24 上午9:55:12 
 * @version V1.0   
 */
public class JDBCExample {

	/**
	 * 通过id查询
	 * @throws SQLException
	（1）  加载JDBC驱动
	（2）  建立并获取数据库连接
	（3）  创建 JDBC Statements 对象
	（4）  设置SQL语句的传入参数
	（5）  执行SQL语句并获得查询结果
	（6）  对查询结果进行转换处理并将处理结果返回
	（7）  释放相关资源（关闭Connection，关闭Statement，关闭ResultSet）
	 */
	
	JDBCUtils jdbcUtils = JDBCUtils.getInstance();
	
	@Test
	public void findUserById() throws SQLException{
		
		Connection conn = jdbcUtils.getConnection();
		String sql = "select * from t_user where id in(?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "1");
		statement.setString(2, "2");
		ResultSet query = statement.executeQuery();
		ResultSetMetaData data = query.getMetaData();
		int count = data.getColumnCount();
		
		while(query.next()){
		 for (int i = 1; i <= count; i++) {
                System.out.print(query.getString(i) + "\t");
                if ((i == 2) && (query.getString(i).length() < 8)) {
                    System.out.print("\t");
                }
             }
            System.out.println("");
		}
		
		//释放资源
		jdbcUtils.free(conn, statement, query);
	}
	
	/**
	 * 添加用户
	 * @throws SQLException
	 */
	@Test
	@SuppressWarnings("deprecation")
	public void insertUser() throws SQLException{
		//获取连接
		Connection conn = jdbcUtils.getConnection();
		String sql = "insert into t_user values (?,?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "3");
		statement.setString(2, "王五");
		statement.setString(3, "男");
		statement.setInt(4, 34);
		statement.setDate(5, new Date(2015, 11, 24));
		statement.setString(6, "北京朝阳区");
		int result = statement.executeUpdate();
		System.out.println("执行结果："+result);
		
		//释放资源
		jdbcUtils.free(conn, statement, null);
	}
	
	/**
	 * 根据条件修改用户
	 * @throws SQLException
	 */
	@Test
	public void updateUser() throws SQLException{
		//获取连接
		Connection conn = jdbcUtils.getConnection();
		String sql = "update t_user set name = ?, sex = ?,addr = ? where id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "燕双鹰");
		statement.setString(2, "未知");
		statement.setString(3, "大沙漠");
		statement.setString(4, "3");
		int result = statement.executeUpdate();
		System.out.println("执行结果："+result);
		
		//释放资源
		jdbcUtils.free(conn, statement, null);
	}
	
	/**
	 * 根据条件删除用户
	 * @throws SQLException
	 */
	@Test
	public void deleteUser() throws SQLException{
		//获取连接
		Connection conn = jdbcUtils.getConnection();
		String sql = "delete from t_user where id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "3");
		int result = statement.executeUpdate();
		System.out.println("执行结果："+result);
		
		//释放资源
		jdbcUtils.free(conn, statement, null);
	}
	
	/**
	 * 传统JDBC问题存在问题：
	（1） 使用数据库连接池对连接进行管理
	（2） SQL语句统一存放到配置文件
	（3） SQL语句变量和传入参数的映射以及动态SQL
	（4） 动态SQL语句的处理
	（5） 对数据库操作结果的映射和结果缓存
	（6） SQL语句的重复
	 */
}


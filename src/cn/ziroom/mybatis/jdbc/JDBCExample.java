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
 * @Description:ʹ��JDBC���в���CRUD
 * @author dfx  
 * @date 2015-11-24 ����9:55:12 
 * @version V1.0   
 */
public class JDBCExample {

	/**
	 * ͨ��id��ѯ
	 * @throws SQLException
	��1��  ����JDBC����
	��2��  ��������ȡ���ݿ�����
	��3��  ���� JDBC Statements ����
	��4��  ����SQL���Ĵ������
	��5��  ִ��SQL��䲢��ò�ѯ���
	��6��  �Բ�ѯ�������ת������������������
	��7��  �ͷ������Դ���ر�Connection���ر�Statement���ر�ResultSet��
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
		
		//�ͷ���Դ
		jdbcUtils.free(conn, statement, query);
	}
	
	/**
	 * ����û�
	 * @throws SQLException
	 */
	@Test
	@SuppressWarnings("deprecation")
	public void insertUser() throws SQLException{
		//��ȡ����
		Connection conn = jdbcUtils.getConnection();
		String sql = "insert into t_user values (?,?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "3");
		statement.setString(2, "����");
		statement.setString(3, "��");
		statement.setInt(4, 34);
		statement.setDate(5, new Date(2015, 11, 24));
		statement.setString(6, "����������");
		int result = statement.executeUpdate();
		System.out.println("ִ�н����"+result);
		
		//�ͷ���Դ
		jdbcUtils.free(conn, statement, null);
	}
	
	/**
	 * ���������޸��û�
	 * @throws SQLException
	 */
	@Test
	public void updateUser() throws SQLException{
		//��ȡ����
		Connection conn = jdbcUtils.getConnection();
		String sql = "update t_user set name = ?, sex = ?,addr = ? where id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "��˫ӥ");
		statement.setString(2, "δ֪");
		statement.setString(3, "��ɳĮ");
		statement.setString(4, "3");
		int result = statement.executeUpdate();
		System.out.println("ִ�н����"+result);
		
		//�ͷ���Դ
		jdbcUtils.free(conn, statement, null);
	}
	
	/**
	 * ��������ɾ���û�
	 * @throws SQLException
	 */
	@Test
	public void deleteUser() throws SQLException{
		//��ȡ����
		Connection conn = jdbcUtils.getConnection();
		String sql = "delete from t_user where id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "3");
		int result = statement.executeUpdate();
		System.out.println("ִ�н����"+result);
		
		//�ͷ���Դ
		jdbcUtils.free(conn, statement, null);
	}
	
	/**
	 * ��ͳJDBC����������⣺
	��1�� ʹ�����ݿ����ӳض����ӽ��й���
	��2�� SQL���ͳһ��ŵ������ļ�
	��3�� SQL�������ʹ��������ӳ���Լ���̬SQL
	��4�� ��̬SQL���Ĵ���
	��5�� �����ݿ���������ӳ��ͽ������
	��6�� SQL�����ظ�
	 */
}


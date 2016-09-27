package cn.ziroom.mybatis.userdao;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.ziroom.mybatis.pojo.User;

/**   
 * @Title UserMapperTest.java 
 * @Package cn.ziroom.mybatis.test 
 * @Description: ��ͳ��ʽʵ��dao�������
 * @author dfx  
 * @date 2015-11-24
 * @version V1.0   
 */
public class UserTest {

	private SqlSessionFactory factory ;
	
	@Before
	public void before() throws IOException{
		String sqlMapConfig = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(sqlMapConfig);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * @desc id��ѯ�û�
	 * @throws Exception
	 */
	@Test
	public void getUserById() throws Exception {
		IUserDao userDao = new UserDaoImpl(factory);
		User user = userDao.getUserById("1");
		System.out.println(user);
	}
	
	@Test
	public void insertUser() throws Exception{
		IUserDao userDao = new UserDaoImpl(factory);
		User user = new User();
		user.setName("����");
		user.setSex("1");
		user.setAge(23);
		user.setBirthday(new Date());
		user.setAddr("������ͬ");
		userDao.insertUaser(user);
	}
	
	@Test
	public void updateUser() throws Exception{
		IUserDao userDao = new UserDaoImpl(factory);
		User user = userDao.getUserById("d118f279-9261-11e5-8332-40f02fef381a");
		user.setName("����");
		user.setSex("2");
		user.setAge(24);
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1992-09-08"));
		user.setAddr("�����Ȫ����");
		userDao.updateUser(user);
	}
	
	@Test
	public void deleteUserById() throws Exception{
		IUserDao userDao = new UserDaoImpl(factory);
		String userId = "4";
		userDao.deleteUser(userId);
	}
	
}

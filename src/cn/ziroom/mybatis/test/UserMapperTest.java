package cn.ziroom.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.ziroom.mybatis.mapper.OrdersMapper;
import cn.ziroom.mybatis.mapper.UserMapper;
import cn.ziroom.mybatis.pojo.Orders;
import cn.ziroom.mybatis.pojo.User;
import cn.ziroom.mybatis.pojo.UserVO;

/**   
 * @Title UserMapperTest.java 
 * @Package cn.ziroom.mybatis.test 
 * @Description: 通过mapper方式测试User
 * @author dfx  
 * @date 2015-11-9 下午2:30:10 
 * @version V1.0   
 */
public class UserMapperTest {

	private SqlSessionFactory factory ;
	
	@Before
	public void before() throws IOException{
		String sqlMapConfig = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(sqlMapConfig);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * @desc id查询用户
	 * @throws Exception
	 */
	@Test
	public void getUserById() throws Exception {
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.getUserById("a3677f6c-86c2-11e5-9518-40f02fef381a");
		System.out.println(user);
		session.close();
	}
	
	@Test
	public void insertUser() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setName("张小三");
		user.setSex("未知");
		user.setAge(34);
		user.setBirthday(new Date());
		user.setAddr("甘肃兰州");
		mapper.insertUser(user);
		session.close();
	}
	
	/**
	 * 级联添加数据测试
	 * @throws Exception
	 */
	@Test
	public void insertUserAndOrder() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setName("张小三");
		user.setSex("未知");
		user.setAge(34);
		user.setBirthday(new Date());
		user.setAddr("甘肃兰州");
		//添加用户
		mapper.insertUser(user);
		
		//添加订单
		OrdersMapper mapper2 = session.getMapper(OrdersMapper.class);
		Orders order = new Orders();
		order.setName("天猫下单");
		order.setAddr("北京市天通苑");
		order.setOrder_date(new Date());
		order.setUserId(user.getId());
		mapper2.insertOrders(order);
		
		session.close();
	}
	
	@Test
	public void updateUser() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.getUserById("a3677f6c-86c2-11e5-9518-40f02fef381a");
		user.setName("张大三");
		user.setSex("2");
		user.setAge(24);
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1992-09-08"));
		user.setAddr("甘肃酒泉瓜州");
		mapper.updateUser(user);
		session.close();
	}
	
	@Test
	public void deleteUserById() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		String userId = "35b61b47-86c4-11e5-9518-40f02fef381a";
		mapper.deleteUserById(userId);
		session.close();
	}
	
	@Test
	public void getUserByfields() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserVO userVO = new UserVO();
		User user = new User();
		user.setName("%张%");
		user.setSex("男");
		userVO.setUser(user);
		List<User> list = mapper.getUserByfields(userVO);
		System.out.println(list.size());
		session.close();
	}
	
	@Test
	public void getUserByName() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<String> names = new ArrayList<String>();
		names.add("张三");
		names.add("张小三");
		names.add("张大三");
		List<User> list = mapper.getUserByName(names);
		System.out.println(list);
		session.close();
	}
	
}

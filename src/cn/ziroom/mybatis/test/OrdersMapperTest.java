package cn.ziroom.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

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

/**   
 * @Title OrdersMapperTest.java 
 * @Package cn.ziroom.mybatis.test 
 * @Description:������Ϣ���� 
 * @author dfx  
 * @date 2015-11-11 ����11:31:15 
 * @version V1.0   
 */
public class OrdersMapperTest {

private SqlSessionFactory factory ;
	
	@Before
	public void before() throws IOException{
		String sqlMapConfig = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(sqlMapConfig);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void insertOrders() throws Exception {
		SqlSession session = factory.openSession(true);
		OrdersMapper mapper1 = session.getMapper(OrdersMapper.class);
		UserMapper mapper2 = session.getMapper(UserMapper.class);
		//��ѯ�û���Ϣ
		User user = mapper2.getUserById("d118f279-9261-11e5-8332-40f02fef381a");
		Orders orders = new Orders();
		orders.setName("��è����");
		orders.setOrder_date(new Date());
		orders.setAddr("�������");
		orders.setUser(user);
		mapper1.insertOrders(orders);
	}

}

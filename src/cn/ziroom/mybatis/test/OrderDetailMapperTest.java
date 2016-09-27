package cn.ziroom.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.ziroom.mybatis.mapper.OrderDetailMapper;
import cn.ziroom.mybatis.pojo.OrderDetail;

/**   
 * @Title OrderDetailMapperTest.java 
 * @Package cn.ziroom.mybatis.test 
 * @Description: TODO 
 * @author dfx  
 * @date 2015-11-13 ÏÂÎç4:24:39 
 * @version V1.0   
 */
public class OrderDetailMapperTest {

private SqlSessionFactory factory ;
	
	@Before
	public void before() throws IOException{
		String sqlMapConfig = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(sqlMapConfig);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void getorderDetailById() throws Exception{
		SqlSession session = factory.openSession(true);
		OrderDetailMapper mapper = session.getMapper(OrderDetailMapper.class);
		OrderDetail orderDetail = mapper.getorderDetailById("69b88de2-89dc-11e5-ab72-40f02fef381a");
		System.out.println(orderDetail);
	}

}

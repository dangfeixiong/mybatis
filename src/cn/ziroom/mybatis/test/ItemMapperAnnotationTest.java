package cn.ziroom.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;





import cn.ziroom.mybatis.annotation.ItemMapper;
import cn.ziroom.mybatis.pojo.Item;

/**   
 * @Title ItemMapperAnnotationTest.java 
 * @Package cn.ziroom.mybatis.test 
 * @Description:注解测试类
 * @author dfx  
 * @date 2015-11-25 下午4:57:12 
 * @version V1.0   
 */
public class ItemMapperAnnotationTest {

private SqlSessionFactory factory ;
	
	@Before
	public void before() throws IOException{
		String sqlMapConfig = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(sqlMapConfig);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void findItemById() throws Exception{
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		//Item item = mapper.findItemById("01def8c1-97cd-11e5-9090-40f02fef381a","橘子");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", "01def8c1-97cd-11e5-9090-40f02fef381a");
		param.put("name", "橘子");
		Item item = mapper.findItemById(param);
		System.out.println(item);
		session.close();
	}
	
	@Test
	public void insertItem() throws Exception {
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		Item item = new Item();
		item.setName("可口可乐");
		item.setPrice(5.0);
		item.setItem_date(new Date());
		item.setAddr("made in china!");
		mapper.insertItem(item);
		session.close();
	}
	
/*
	@Test
	public void updatItem() throws Exception{
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		Item item = mapper.findItemById("22f10feb-9341-11e5-a56c-40f02fef381a");
		item.setPrice(34d);
		item.setAddr("北京将台测试");
		item.setItem_date(new Date());
		mapper.updatItem(item);
		session.close();
	}
	*/
	@Test
	public void deleteItem() throws Exception{
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		mapper.deleteItem("22f10feb-9341-11e5-a56c-40f02fef381a");
		session.close();
	}
}

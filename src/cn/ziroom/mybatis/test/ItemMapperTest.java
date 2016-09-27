package cn.ziroom.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.ziroom.mybatis.mapper.ItemMapper;
import cn.ziroom.mybatis.mapper.UserMapper;
import cn.ziroom.mybatis.pojo.Item;
import cn.ziroom.mybatis.pojo.User;

/**   
 * @Title ItemMapper.java 
 * @Package cn.ziroom.mybatis.test 
 * @Description:商品测试 
 * @author dfx  
 * @date 2015-11-10 上午11:54:34 
 * @version V1.0   
 */
public class ItemMapperTest {

	private SqlSessionFactory factory ;
	
	@Before
	public void before() throws IOException{
		String sqlMapConfig = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(sqlMapConfig);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
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
		item.setPacking(true);
		mapper.insertItem(item);
		session.close();
	}
	
	@Test
	public void findItemById() throws Exception{
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		Item item = mapper.findItemById("6923a286-bd8a-11e5-82be-40f02fef381a");
		System.out.println(item);
		session.close();
	}
	
	@Test
	public void findItemByName() throws Exception{
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		List<Item> items = mapper.findItemByName("%可口可乐%");	//like 查询[模糊查询]
		System.out.println(items.size());
	}
	
	@Test
	public void updatItem() throws Exception{
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		Item item = mapper.findItemById("c1fdca9e-8760-11e5-8a56-40f02fef381a");
		item.setPrice(34d);
		item.setAddr("北京将台");
		item.setItem_date(new Date());
		mapper.updatItem(item);
		session.close();
	}
	
	@Test
	public void deleteItem() throws Exception{
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		mapper.deleteItem("c1fdca9e-8760-11e5-8a56-40f02fef381a");
		session.close();
	}
	
	@Test
	/**
	 *  (1)	一级缓存: 基于PerpetualCache 的 HashMap本地缓存，其存储作用域为 Session,
	 *  	当 Session flush 或 close 之后，该Session中的所有 Cache 就将清空
	 *  (2)	一级缓存: 也就Session级的缓存(默认开启)
	 *  (3)	对于缓存数据更新机制，当某一个作用域(一级缓存Session/二级缓存Namespaces)的进行了 C/U/D 操作后，
	 *  	默认该作用域下<b>所有</b> select 中的缓存将被clear。
	 * @throws Exception
	 */
	
	//[一级缓存{mybatis自身实现}]注:一个session下,只要有C/U/D操作后,该session下的所有select都讲被clear
	public void firstCache() throws Exception{
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		//第一次查询
		Item item1 = mapper.findItemById("60d41166-9341-11e5-a56c-40f02fef381a");
		List<Item> list1 = mapper.findItemByName("%红%");
		System.out.println(item1);
		System.out.println(list1.size());
		
		//不同对象查询
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user1 = userMapper.getUserById("d118f279-9261-11e5-8332-40f02fef381a");
		System.out.println(user1);
		//session.clearCache();
		//修改数据更新一级缓存中的数据
		item1.setPrice(333.0);
		mapper.updatItem(item1);
		//第二次查询
		Item item2 = mapper.findItemById("60d41166-9341-11e5-a56c-40f02fef381a");
		List<Item> list2 = mapper.findItemByName("%红%");
		System.out.println(item2);
		System.out.println(list2.size());
		
		User user2 = userMapper.getUserById("d118f279-9261-11e5-8332-40f02fef381a");
		System.out.println(user2);
		
		session.close();
	}
	
	@Test
	/**
	 * 测试二级缓存
	 * (1).二级缓存的作用域是一个namespace(mapper)
	 * (2).mybatis支持二级缓存
	 * (3).如果开启了二级缓存，那么在关闭sqlsession后，会把该sqlsession一级缓存中的数据添加到namespace的二级缓存中
	 * (4).需要使用二级缓存的POJO类实现Serializable接口
	 */
	
	//[二级缓存{mybatis自身实现}]注:只要有C/U/D操作后,所有select都讲被clear
	public void secondCache() throws Exception{
		//第一个session缓存
		SqlSession session1 = factory.openSession(true);
		ItemMapper mapper1 = session1.getMapper(ItemMapper.class);
		Item item1 = mapper1.findItemById("60d41166-9341-11e5-a56c-40f02fef381a");
		session1.close();
		System.out.println(item1);
		//第二个session缓存
		SqlSession session2 = factory.openSession(true);
		ItemMapper mapper2 = session2.getMapper(ItemMapper.class);
		Item item2 = mapper2.findItemById("60d41166-9341-11e5-a56c-40f02fef381a");
		session2.close();
		System.out.println(item2);
		
	}

}

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
 * @Description:��Ʒ���� 
 * @author dfx  
 * @date 2015-11-10 ����11:54:34 
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
		item.setName("�ɿڿ���");
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
		List<Item> items = mapper.findItemByName("%�ɿڿ���%");	//like ��ѯ[ģ����ѯ]
		System.out.println(items.size());
	}
	
	@Test
	public void updatItem() throws Exception{
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		Item item = mapper.findItemById("c1fdca9e-8760-11e5-8a56-40f02fef381a");
		item.setPrice(34d);
		item.setAddr("������̨");
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
	 *  (1)	һ������: ����PerpetualCache �� HashMap���ػ��棬��洢������Ϊ Session,
	 *  	�� Session flush �� close ֮�󣬸�Session�е����� Cache �ͽ����
	 *  (2)	һ������: Ҳ��Session���Ļ���(Ĭ�Ͽ���)
	 *  (3)	���ڻ������ݸ��»��ƣ���ĳһ��������(һ������Session/��������Namespaces)�Ľ����� C/U/D ������
	 *  	Ĭ�ϸ���������<b>����</b> select �еĻ��潫��clear��
	 * @throws Exception
	 */
	
	//[һ������{mybatis����ʵ��}]ע:һ��session��,ֻҪ��C/U/D������,��session�µ�����select������clear
	public void firstCache() throws Exception{
		SqlSession session = factory.openSession(true);
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		//��һ�β�ѯ
		Item item1 = mapper.findItemById("60d41166-9341-11e5-a56c-40f02fef381a");
		List<Item> list1 = mapper.findItemByName("%��%");
		System.out.println(item1);
		System.out.println(list1.size());
		
		//��ͬ�����ѯ
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user1 = userMapper.getUserById("d118f279-9261-11e5-8332-40f02fef381a");
		System.out.println(user1);
		//session.clearCache();
		//�޸����ݸ���һ�������е�����
		item1.setPrice(333.0);
		mapper.updatItem(item1);
		//�ڶ��β�ѯ
		Item item2 = mapper.findItemById("60d41166-9341-11e5-a56c-40f02fef381a");
		List<Item> list2 = mapper.findItemByName("%��%");
		System.out.println(item2);
		System.out.println(list2.size());
		
		User user2 = userMapper.getUserById("d118f279-9261-11e5-8332-40f02fef381a");
		System.out.println(user2);
		
		session.close();
	}
	
	@Test
	/**
	 * ���Զ�������
	 * (1).�����������������һ��namespace(mapper)
	 * (2).mybatis֧�ֶ�������
	 * (3).��������˶������棬��ô�ڹر�sqlsession�󣬻�Ѹ�sqlsessionһ�������е�������ӵ�namespace�Ķ���������
	 * (4).��Ҫʹ�ö��������POJO��ʵ��Serializable�ӿ�
	 */
	
	//[��������{mybatis����ʵ��}]ע:ֻҪ��C/U/D������,����select������clear
	public void secondCache() throws Exception{
		//��һ��session����
		SqlSession session1 = factory.openSession(true);
		ItemMapper mapper1 = session1.getMapper(ItemMapper.class);
		Item item1 = mapper1.findItemById("60d41166-9341-11e5-a56c-40f02fef381a");
		session1.close();
		System.out.println(item1);
		//�ڶ���session����
		SqlSession session2 = factory.openSession(true);
		ItemMapper mapper2 = session2.getMapper(ItemMapper.class);
		Item item2 = mapper2.findItemById("60d41166-9341-11e5-a56c-40f02fef381a");
		session2.close();
		System.out.println(item2);
		
	}

}

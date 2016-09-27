package cn.ziroom.mybatis.mapper;

import java.util.List;

import cn.ziroom.mybatis.pojo.Item;

/**   
 * @Title ItemMapper.java 
 * @Package cn.ziroom.mybatis.mapper 
 * @Description:ItemDaoʵ��  
 * @author dfx  
 * @date 2015-11-10 ����11:46:39 
 * @version V1.0   
 */
public interface ItemMapper {

	/**
	 * �����Ʒ��Ϣ
	 */
	public void insertItem(Item item) throws Exception ;
	
	/**
	 * �޸���Ʒ��Ϣ
	 */
	public void updatItem(Item item) throws Exception ;
	
	/**
	 * ����Id��ѯ��Ʒ��Ϣ
	 */
	public Item findItemById(String id) throws Exception ;
	
	/**
	 * ������Ʒ���Ʋ�ѯ��Ʒ�б�
	 */
	public List<Item> findItemByName(String name) throws Exception ;
	
	/**
	 * ����Idɾ����Ʒ
	 */
	public void deleteItem(String id) throws Exception ;
}

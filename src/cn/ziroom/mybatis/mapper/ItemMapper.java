package cn.ziroom.mybatis.mapper;

import java.util.List;

import cn.ziroom.mybatis.pojo.Item;

/**   
 * @Title ItemMapper.java 
 * @Package cn.ziroom.mybatis.mapper 
 * @Description:ItemDao实体  
 * @author dfx  
 * @date 2015-11-10 上午11:46:39 
 * @version V1.0   
 */
public interface ItemMapper {

	/**
	 * 添加商品信息
	 */
	public void insertItem(Item item) throws Exception ;
	
	/**
	 * 修改商品信息
	 */
	public void updatItem(Item item) throws Exception ;
	
	/**
	 * 根据Id查询商品信息
	 */
	public Item findItemById(String id) throws Exception ;
	
	/**
	 * 根据商品名称查询商品列表
	 */
	public List<Item> findItemByName(String name) throws Exception ;
	
	/**
	 * 根据Id删除商品
	 */
	public void deleteItem(String id) throws Exception ;
}

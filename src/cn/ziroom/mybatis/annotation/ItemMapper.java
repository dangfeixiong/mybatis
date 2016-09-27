package cn.ziroom.mybatis.annotation;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import cn.ziroom.mybatis.pojo.Item;

/**   
 * @Title ItemMapper.java 
 * @Package cn.ziroom.mybatis.annotation 
 * @Description: TODO 
 * @author dfx  
 * @date 2015-11-25 下午4:47:25 
 * @version V1.0   
 */
public interface ItemMapper {

	/**
	 * 添加商品信息
	 */
	@Insert(value="insert into item(id,name,price,addr,item_date) values(#{id},#{name},#{price},#{addr},#{item_date})")
	@SelectKey(before=true,keyProperty="id",resultType=String.class,statement="select UUID()")
	public void insertItem(Item item) throws Exception ;
	
	/**
	 * 修改商品信息
	 */
	@Update(value="update item set price = #{price}, addr = #{addr}, item_date = #{item_date} where id = #{id}")
	public void updatItem(Item item) throws Exception ;
	
	
	/**
	 * 根据Id删除商品
	 */
	@Delete(value="delete from item where id = #{id}")
	public void deleteItem(String id) throws Exception ;
	
	/**
	 * 根据Id查询商品信息
	 */
	@Select(value="select * from item where id = #{id} and name=#{name}")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="name",column="name"),
		@Result(property="price",column="price"),
		@Result(property="addr",column="addr"),
		@Result(property="item_date",column="item_date")
	})
	//public Item findItemById(@Param("id")String id,@Param("name")String name) throws Exception ;
	
	//public Item findItemById(String id,String name) throws Exception ;//error
	
	
	public Item findItemById(Map<String,Object> param) throws Exception ;
}

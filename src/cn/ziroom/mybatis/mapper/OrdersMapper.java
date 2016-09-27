package cn.ziroom.mybatis.mapper;

import cn.ziroom.mybatis.pojo.Orders;

/**   
 * @Title OrdersMapper.java 
 * @Package cn.ziroom.mybatis.mapper 
 * @Description: 订单实体
 * @author dfx  
 * @date 2015-11-10 下午7:04:30 
 * @version V1.0   
 */
public interface OrdersMapper {

	/**
	 * 添加订单
	 */
	public void insertOrders(Orders orders) throws Exception ;
	
	/**
	 * 修改订单
	 */
	public void updateOrders(Orders orders) throws Exception ;
}

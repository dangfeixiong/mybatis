package cn.ziroom.mybatis.mapper;

import cn.ziroom.mybatis.pojo.OrderDetail;

/**   
 * @Title OrderDetailMapper.java 
 * @Package cn.ziroom.mybatis.mapper 
 * @Description:订单详情mapper 
 * @author dfx  
 * @date 2015-11-13 下午3:37:56 
 * @version V1.0   
 */
public interface OrderDetailMapper {

	/**
	 * 根据ID查询订单详情
	 * @param id
	 * @return OrderDetail
	 * @throws Exception
	 */
	public OrderDetail getorderDetailById(String id) throws Exception ;
	
	/**
	 * 添加订单详情信息
	 * @param orderDetail
	 * @throws Exception
	 */
	public void insertOrderDetail(OrderDetail orderDetail) throws Exception ;
	
	/**
	 * 修改订单详情信息
	 * @param orderDetail
	 * @throws Exception
	 */
	public void updateOrderDetail(OrderDetail orderDetail) throws Exception ;
	
	/**
	 * 通过订单id删除订单详情信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderDetailById(String id) throws Exception ;
}

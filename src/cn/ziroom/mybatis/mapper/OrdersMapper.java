package cn.ziroom.mybatis.mapper;

import cn.ziroom.mybatis.pojo.Orders;

/**   
 * @Title OrdersMapper.java 
 * @Package cn.ziroom.mybatis.mapper 
 * @Description: ����ʵ��
 * @author dfx  
 * @date 2015-11-10 ����7:04:30 
 * @version V1.0   
 */
public interface OrdersMapper {

	/**
	 * ��Ӷ���
	 */
	public void insertOrders(Orders orders) throws Exception ;
	
	/**
	 * �޸Ķ���
	 */
	public void updateOrders(Orders orders) throws Exception ;
}

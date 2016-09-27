package cn.ziroom.mybatis.mapper;

import cn.ziroom.mybatis.pojo.OrderDetail;

/**   
 * @Title OrderDetailMapper.java 
 * @Package cn.ziroom.mybatis.mapper 
 * @Description:��������mapper 
 * @author dfx  
 * @date 2015-11-13 ����3:37:56 
 * @version V1.0   
 */
public interface OrderDetailMapper {

	/**
	 * ����ID��ѯ��������
	 * @param id
	 * @return OrderDetail
	 * @throws Exception
	 */
	public OrderDetail getorderDetailById(String id) throws Exception ;
	
	/**
	 * ��Ӷ���������Ϣ
	 * @param orderDetail
	 * @throws Exception
	 */
	public void insertOrderDetail(OrderDetail orderDetail) throws Exception ;
	
	/**
	 * �޸Ķ���������Ϣ
	 * @param orderDetail
	 * @throws Exception
	 */
	public void updateOrderDetail(OrderDetail orderDetail) throws Exception ;
	
	/**
	 * ͨ������idɾ������������Ϣ
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderDetailById(String id) throws Exception ;
}

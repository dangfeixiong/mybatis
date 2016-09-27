package cn.ziroom.mybatis.pojo;

import java.util.Date;
import java.util.List;

/**
 * @Title Orders.java
 * @Package cn.ziroom.mybatis.pojo
 * @Description: 订单实体
 * @author dfx
 * @date 2015-11-10 上午11:37:35
 * @version V1.0
 */
public class Orders {

	private String id;		//订单id
	private String name;	//订单名称
	private String addr;	//订单发货地址
	private Date order_date;//下单时间
	private User user;		//所属用户
	
	private List<OrderDetail> orderDetail; //订单详情	[仅作演示使用]
	
	//关联实体改进
	private String userId;	//userId[与数据库中设计保持一致]

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}

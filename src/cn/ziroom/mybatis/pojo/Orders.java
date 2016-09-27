package cn.ziroom.mybatis.pojo;

import java.util.Date;
import java.util.List;

/**
 * @Title Orders.java
 * @Package cn.ziroom.mybatis.pojo
 * @Description: ����ʵ��
 * @author dfx
 * @date 2015-11-10 ����11:37:35
 * @version V1.0
 */
public class Orders {

	private String id;		//����id
	private String name;	//��������
	private String addr;	//����������ַ
	private Date order_date;//�µ�ʱ��
	private User user;		//�����û�
	
	private List<OrderDetail> orderDetail; //��������	[������ʾʹ��]
	
	//����ʵ��Ľ�
	private String userId;	//userId[�����ݿ�����Ʊ���һ��]

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

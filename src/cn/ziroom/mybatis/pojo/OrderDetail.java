package cn.ziroom.mybatis.pojo;

import java.util.Date;

/**
 * @Title OrderDetail.java
 * @Package cn.ziroom.mybatis.pojo
 * @Description:��������ʵ��
 * @author dfx
 * @date 2015-11-13 ����3:32:31
 * @version V1.0
 */
public class OrderDetail {

	private String id; // ����id
	private String note; // ������������
	private Date createDate;// ����ʱ��
	private Orders orders; // ����
	private Item item; // ��Ʒ [������ʾʹ��]

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}

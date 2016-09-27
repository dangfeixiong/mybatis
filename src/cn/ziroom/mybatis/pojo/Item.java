package cn.ziroom.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title Item.java
 * @Package cn.ziroom.mybatis.pojo
 * @Description: ��Ʒʵ����Ϣ
 * @author dfx
 * @date 2015-11-10 ����11:34:07
 * @version V1.0
 */
public class Item implements Serializable{

	private static final long serialVersionUID = 2090172910988731651L;
	
	private String id; 	//��Ʒid
	private String name; //��Ʒ����
	private Double price; //��Ʒ�۸�
	private String addr; //���̵�ַ
	private Date item_date; //��������
	private Boolean isPacking;//�����ֶ�
	

    public Boolean getPacking() {
        return isPacking;
    }

    public void setPacking(Boolean packing) {
        isPacking = packing;
    }
    
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getItem_date() {
		return item_date;
	}

	public void setItem_date(Date item_date) {
		this.item_date = item_date;
	}

}

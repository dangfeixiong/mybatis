package cn.ziroom.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title Item.java
 * @Package cn.ziroom.mybatis.pojo
 * @Description: 商品实体信息
 * @author dfx
 * @date 2015-11-10 上午11:34:07
 * @version V1.0
 */
public class Item implements Serializable{

	private static final long serialVersionUID = 2090172910988731651L;
	
	private String id; 	//商品id
	private String name; //商品名称
	private Double price; //商品价格
	private String addr; //厂商地址
	private Date item_date; //生产日期
	private Boolean isPacking;//测试字段
	

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

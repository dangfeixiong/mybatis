package cn.ziroom.mybatis.test;

import java.math.BigDecimal;

import org.junit.Test;

public class CompareToTest {

	@Test
	public void compareToTest(){
		BigDecimal a = new BigDecimal(3592.00);
		BigDecimal b = new BigDecimal(3642.00);
		System.out.println(a.compareTo(b));
	}
	
}

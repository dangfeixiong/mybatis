package cn.ziroom.mybatis.userdao;

import cn.ziroom.mybatis.pojo.User;

/**   
 * @Title UserDao.java 
 * @Package cn.ziroom.mybatis.userdao 
 * @Description:UserDao接口
 * @author dfx  
 * @date 2015-11-24 上午11:39:17 
 * @version V1.0   
 */
public interface IUserDao {
	//查询
	public User getUserById(String id) throws Exception;
	//添加
	public void insertUaser(User user) throws Exception;
	//修改
	public void updateUser(User user) throws Exception;
	//删除
	public void deleteUser(String id) throws Exception;
}

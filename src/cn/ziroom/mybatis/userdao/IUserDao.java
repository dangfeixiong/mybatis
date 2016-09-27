package cn.ziroom.mybatis.userdao;

import cn.ziroom.mybatis.pojo.User;

/**   
 * @Title UserDao.java 
 * @Package cn.ziroom.mybatis.userdao 
 * @Description:UserDao�ӿ�
 * @author dfx  
 * @date 2015-11-24 ����11:39:17 
 * @version V1.0   
 */
public interface IUserDao {
	//��ѯ
	public User getUserById(String id) throws Exception;
	//���
	public void insertUaser(User user) throws Exception;
	//�޸�
	public void updateUser(User user) throws Exception;
	//ɾ��
	public void deleteUser(String id) throws Exception;
}

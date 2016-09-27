package cn.ziroom.mybatis.userdao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;

import cn.ziroom.mybatis.pojo.User;

/**   
 * @Title UserDaoImpl.java 
 * @Package cn.ziroom.mybatis.userdao 
 * @Description:ʹ�ô�ͳ��ʽ����dao��
 * @author dfx  
 * @date 2015-11-24 ����11:41:27 
 * @version V1.0   
 */
public class UserDaoImpl implements IUserDao{

	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){  
        this.sqlSessionFactory = sqlSessionFactory;  
    } 
	
	@Override
	public User getUserById(String id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//����������뼶��
		sqlSessionFactory.openSession(TransactionIsolationLevel.NONE);
		User user = session.selectOne("test.getUserById", id);
		session.close();
		return user;
	}

	@Override
	public void insertUaser(User user) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("test.insertUser", user);
		session.commit();
		session.close();
	}

	@Override
	public void updateUser(User user) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("test.updateUser", user);
		session.commit();
		session.close();
	}

	@Override
	public void deleteUser(String id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("test.deleteUserById", id);
		session.commit();
		session.close();
	}

}

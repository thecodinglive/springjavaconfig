package info.thecodinglive.api.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

	 @Autowired
	 private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	@Cacheable(value="userListCache")
	public List selectAll() {
		UserDao userDao =  sqlSessionTemplate.getMapper(UserDao.class);
		List resultList = userDao.selectAll();
		
		return resultList;
	}

}

package cn.sxt.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.sxt.dao.T_userDao;
import cn.sxt.vo.T_user;
@Repository("t_userDao")
public class T_userDaoImpl extends SqlSessionDaoSupport implements T_userDao{
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<T_user> selectTuserByName(Map<String, Object> map) {
		System.out.println("dao");
		return getSqlSession().selectList("cn.sxt.vo.t_user.mapper.selectTuserByName",map);
	}

	@Override
	public List<T_user> list() {
		return getSqlSession().selectList("cn.sxt.vo.t_user.mapper.list",1);
	}

	@Override
	public int registerTuser(Map<String, Object> map) {
		System.out.println("service:"+map.size());
		return getSqlSession().insert("cn.sxt.vo.t_user.mapper.registerTuser",map);
	}

}

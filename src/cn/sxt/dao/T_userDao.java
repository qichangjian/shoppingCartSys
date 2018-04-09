package cn.sxt.dao;

import java.util.List;
import java.util.Map;

import cn.sxt.vo.T_user;

public interface T_userDao {
	// 根据name查询用户，登陆查询
	List<T_user> selectTuserByName(Map<String, Object> map);

	List<T_user> list();

	/** 注册用户 */
	int registerTuser(Map<String, Object> map);
}

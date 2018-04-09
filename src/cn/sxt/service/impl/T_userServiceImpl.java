package cn.sxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sxt.dao.T_userDao;
import cn.sxt.service.T_userService;
import cn.sxt.vo.T_user;

@Service("t_userService")
public class T_userServiceImpl implements T_userService {
	@Autowired
	private T_userDao t_userDao;

	@Override
	public List<T_user> selectTuserByName(Map<String, Object> map) {
		System.out.println("service");
		return t_userDao.selectTuserByName(map);
	}

	@Override
	public List<T_user> list() {
		return t_userDao.list();
	}

	@Override
	public int registerTuser(Map<String, Object> map) {
		System.out.println("service:" + map.size());
		return t_userDao.registerTuser(map);
	}

}

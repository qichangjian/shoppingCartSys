package cn.sxt.dao;

import java.util.List;
import java.util.Map;

import cn.sxt.vo.T_user;

public interface T_userDao {
	// ����name��ѯ�û�����½��ѯ
	List<T_user> selectTuserByName(Map<String, Object> map);

	List<T_user> list();

	/** ע���û� */
	int registerTuser(Map<String, Object> map);
}

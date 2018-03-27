package cn.sxt.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.sxt.dao.T_commodityDao;
import cn.sxt.vo.T_commodity;
import cn.sxt.vo.T_commoditypicture;
import cn.sxt.vo.T_picture;

@Repository("t_commodityDao")
public class T_commodityDaoImpl extends SqlSessionDaoSupport implements T_commodityDao{
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<T_commodity> selectManGategories(Map<String, Object> map) {
		return getSqlSession().selectList("cn.sxt.vo.t_commodity.mapper.selectManGategories",map);
	}

	@Override
	public List<T_commodity> selectAllCommodity(Map<String, Object> map) {		
		return getSqlSession().selectList("cn.sxt.vo.t_commodity.mapper.selectAllCommodity",map);
	}
	
	@Override
	public List<T_commoditypicture> selectAllCommoditytest(Map<String, Object> map) {
		return getSqlSession().selectList("cn.sxt.vo.t_commodity.mapper.selectAllCommoditytest",map);
	}
	
	
	
	@Override
	public List<T_commodity> selectAllCommodity2(Map<String, Object> map) {
		return getSqlSession().selectList("cn.sxt.vo.t_commodity.mapper.selectAllCommodity2",map);
	}
	@Override
	public List<T_commodity> selectAllCommodity3(Map<String, Object> map) {
		return getSqlSession().selectList("cn.sxt.vo.t_commodity.mapper.selectAllCommodity3",map);
	}
	@Override
	public List<T_commodity> selectAllCommodity4(Map<String, Object> map) {
		return getSqlSession().selectList("cn.sxt.vo.t_commodity.mapper.selectAllCommodity4",map);
	}

	@Override
	public int selectGategCount(Map<String, Object> map) {
		System.out.println("select gate Dao:"+map.get("commodityisman"));
		return getSqlSession().selectOne("cn.sxt.vo.t_commodity.mapper.selectGategCount", map);
	}
	@Override
	public int selectGategCount1(Map<String, Object> map) {
		System.out.println("1select gate Dao:"+map.get("commodityisman"));
		return getSqlSession().selectOne("cn.sxt.vo.t_commodity.mapper.selectGategCount1", map);
	}
	@Override
	public int selectGategCount2(Map<String, Object> map) {
		System.out.println("2select gate Dao:"+map.get("commodityisman"));
		return getSqlSession().selectOne("cn.sxt.vo.t_commodity.mapper.selectGategCount2", map);
	}

	@Override
	public List<T_picture> selectAllCommoditypicture(Map<String, Object> map) {
		return getSqlSession().selectList("cn.sxt.vo.t_commodity.mapper.selectAllCommoditypicture", map);
	}

	@Override
	public List<T_commoditypicture> selectCommoditypBycId(Map<String, Object> map) {
		System.out.println("dao÷–selectCommoditypBycId£∫"+map.get("commodityId"));
		return getSqlSession().selectList("cn.sxt.vo.t_commodity.mapper.selectCommoditypBycId", map);
	}

	@Override
	public int updateTcartListnumber(Map<String, Object> map) {
		return getSqlSession().update("cn.sxt.vo.t_cartList.mapper.updateTcartListnumber", map);
	}


}

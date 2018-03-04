package cn.sxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sxt.dao.T_commodityDao;
import cn.sxt.service.T_commodityService;
import cn.sxt.vo.T_commodity;
@Service("t_commodityService")
public class T_commodityServiceImpl implements T_commodityService{
	@Autowired
	private T_commodityDao t_commodityDao;

	@Override
	public List<T_commodity> selectManGategories(Map<String, Object> map) {	
		return t_commodityDao.selectManGategories(map);
	}

	@Override
	public List<T_commodity> selectAllCommodity(Map<String, Object> map) {
		//System.out.println(map.get(0));
		return t_commodityDao.selectAllCommodity(map);
	}
	@Override
	public List<T_commodity> selectAllCommodity2(Map<String, Object> map) {
		return t_commodityDao.selectAllCommodity2(map);
	}
	@Override
	public List<T_commodity> selectAllCommodity3(Map<String, Object> map) {
		return t_commodityDao.selectAllCommodity3(map);
	}
	@Override
	public List<T_commodity> selectAllCommodity4(Map<String, Object> map) {
		return t_commodityDao.selectAllCommodity4(map);
	}

	@Override
	public int selectGategCount(Map<String, Object> map) {
		System.out.println("service select gate:"+t_commodityDao.selectGategCount(map));
		return t_commodityDao.selectGategCount(map);
	}
	@Override
	public int selectGategCount1(Map<String, Object> map) {
		System.out.println("1service select gate:"+t_commodityDao.selectGategCount1(map));
		return t_commodityDao.selectGategCount(map);
	}
	@Override
	public int selectGategCount2(Map<String, Object> map) {
		System.out.println("2service select gate:"+t_commodityDao.selectGategCount2(map));
		return t_commodityDao.selectGategCount(map);
	}
	
	
}

package cn.sxt.dao;

import java.util.List;
import java.util.Map;

import cn.sxt.vo.T_commodity;

public interface T_commodityDao {
	//查询类型列表
	List<T_commodity> selectManGategories(Map<String,Object> map);
	
	//查询所有的商品
	List<T_commodity> selectAllCommodity(Map<String,Object> map);
	//查询所有的商品有价格范围
	List<T_commodity> selectAllCommodity2(Map<String,Object> map);
	//查询所有的商品有价格范围，有商品类型
	List<T_commodity> selectAllCommodity3(Map<String,Object> map);
	//查询所有的商品没有价格范围，有商品类型
	List<T_commodity> selectAllCommodity4(Map<String,Object> map);
	
	//查询商品个数
	int selectGategCount(Map<String,Object> map);
	//为了测试
	int selectGategCount1(Map<String,Object> map);
	int selectGategCount2(Map<String,Object> map);
}

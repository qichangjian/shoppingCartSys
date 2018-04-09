package cn.sxt.dao;

import java.util.List;
import java.util.Map;

import cn.sxt.vo.T_commodity;
import cn.sxt.vo.T_commodityComment;
import cn.sxt.vo.T_commoditypicture;
import cn.sxt.vo.T_picture;

public interface T_commodityDao {
	// 查询类型列表
	List<T_commodity> selectManGategories(Map<String, Object> map);

	// 查询商品以及路径
	List<T_commoditypicture> selectAllCommoditytest(Map<String, Object> map);

	// 查图片
	List<T_picture> selectAllCommoditypicture(Map<String, Object> map);

	// 查询所有的商品
	List<T_commodity> selectAllCommodity(Map<String, Object> map);

	// 查询所有的商品有价格范围
	List<T_commodity> selectAllCommodity2(Map<String, Object> map);

	// 查询所有的商品有价格范围，有商品类型
	List<T_commodity> selectAllCommodity3(Map<String, Object> map);

	// 查询所有的商品没有价格范围，有商品类型
	List<T_commodity> selectAllCommodity4(Map<String, Object> map);

	List<T_commodity> selectCommodity(Map<String, Object> map);

	// 查询商品个数
	int selectGategCount(Map<String, Object> map);

	// 查询评论个数
	int selectCommentCount(Map<String, Object> map);

	List<T_commodityComment> selectCommodityCommentById(Map<String, Object> map);

	// 为了测试
	int selectGategCount1(Map<String, Object> map);

	int selectGategCount2(Map<String, Object> map);

	// 根据id查询商品以及图片
	List<T_commoditypicture> selectCommoditypBycId(Map<String, Object> map);

	// 修改数量cartlist
	int updateTcartListnumber(Map<String, Object> map);

	// 留言
	int addContactUs(Map<String, Object> map);
}

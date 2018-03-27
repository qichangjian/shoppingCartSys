package cn.sxt.service;

import java.util.List;
import java.util.Map;

import cn.sxt.vo.T_commodity;
import cn.sxt.vo.T_commoditypicture;
import cn.sxt.vo.T_picture;

public interface T_commodityService {
	//��ѯ�����б�
	List<T_commodity> selectManGategories(Map<String,Object> map);
	
	//��ѯ��Ʒ�Լ�·��
	List<T_commoditypicture> selectAllCommoditytest(Map<String,Object> map);
	//��ͼƬ
	List<T_picture> selectAllCommoditypicture(Map<String,Object> map);
		
	//��ѯ���е���Ʒ
	List<T_commodity> selectAllCommodity(Map<String,Object> map);
	//��ѯ���е���Ʒ�м۸�Χ
	List<T_commodity> selectAllCommodity2(Map<String,Object> map);
	//��ѯ���е���Ʒ�м۸�Χ������Ʒ����
	List<T_commodity> selectAllCommodity3(Map<String,Object> map);
	//��ѯ���е���Ʒû�м۸�Χ������Ʒ����
	List<T_commodity> selectAllCommodity4(Map<String,Object> map);
	
	//��ѯ��Ʒ����
	int selectGategCount(Map<String,Object> map);
	//Ϊ�˲���
	int selectGategCount1(Map<String,Object> map);
	int selectGategCount2(Map<String,Object> map);
	
	//����id��ѯ��Ʒ�Լ�ͼƬ
	List<T_commoditypicture> selectCommoditypBycId(Map<String,Object> map);
	//�޸�����cartlist
	int updateTcartListnumber(Map<String,Object> map);
}

package cn.sxt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sxt.service.T_commodityService;
import cn.sxt.vo.T_commodity;
import cn.sxt.vo.T_commoditypicture;
import cn.sxt.vo.T_picture;

@Controller
public class T_commodityController {
	@Autowired
	private T_commodityService t_commodityService;
	
	
	
	public void setT_commodityService(T_commodityService t_commodityService) {
		this.t_commodityService = t_commodityService;
	}
	
	/*@RequestMapping("/shopCartClient/views/manGategories")
	public ModelAndView manGategories(HttpServletRequest request,HttpServletResponse response,ModelMap map1) {
		System.out.println("����manGategories");
		int pageSize = 6;//ûҳ������
		int GategCount = 0;//�ܲ�ѯ����
		int pageAll = 0;//һ����ҳ
		int currentPage = 0;//ǰ̨���������ǰҳ����int��
		ModelAndView mv = new ModelAndView();
		
		String commodityisman = request.getParameter("commodityisman");//�Ƿ���װ
		String currentPage1 = request.getParameter("currentPage");//��ǰҳ��
		currentPage = Integer.parseInt(currentPage1);
		System.out.println("ǰ̨currentPage:"+currentPage);
		
		String low1 = request.getParameter("low");//��ͼ۲�ѯ
		String high1 = request.getParameter("high");//��߼۲�ѯ
		String gategoriesName = request.getParameter("gategoriesName");//�������Ʒ����
		Integer low = Integer.parseInt(low1) ;
		Integer high = Integer.parseInt(high1);
		
		System.out.println("�Ƿ�������۸�"+low1+":"+high1);
		
		
		System.out.println("T_controller��"+commodityisman);
		Map<String,Object> map = new HashMap<String,Object>();
		if(low1 == "" || low1 == null) {
			map.put("commodityisman", commodityisman);
			GategCount = t_commodityService.selectGategCount(map);//����������
		}else {
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			GategCount = t_commodityService.selectGategCount(map);//����������
		}
		if(low1 == "" || low1 == null) {
			map.put("commodityisman", commodityisman);
			GategCount = t_commodityService.selectGategCount1(map);//����������
		}else {
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			GategCount = t_commodityService.selectGategCount2(map);//����������
		}
		
		*//**һ������ҳ*//*
		
		System.out.println(map.get("commodityisman")+":"+map.get("low")+"--++GategCount:"+GategCount+":gategoriesName="+gategoriesName);
		pageAll = GategCount/pageSize + 1;//����һ���м�ҳ

		System.out.println("�ж�֮ǰpageAll:"+pageAll);
		if(currentPage < 1) {
			System.out.println("����С��");
			currentPage = 1;
		}
		if(currentPage > pageAll) {
			System.out.println("�������");
			currentPage = pageAll;
		}
		List<T_commodity> ManGategoriesList = t_commodityService.selectManGategories(map);//��ѯ��������,���ص������Ͳ����û�
		*//***//*
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		List<T_commodity> commodityList;
		System.out.println("�����ж����֮ǰ�ĸ���������low1:"+low1+"gategoriesname:"+gategoriesName);
		
		if(low1=="") {
			low1 = null;
		}if(gategoriesName=="") {
			gategoriesName = null;
		}
		if(low1==null && gategoriesName==null) {
			System.out.println("��Ϊ��currentPage��"+currentPage);
			map2.put("startIndex", (currentPage-1)*pageSize);//����ҳ
			map2.put("pageSize", pageSize*currentPage);//ÿҳ����
			map2.put("commodityisman", commodityisman);
			System.out.println("��Ϊ��-----liebiao:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			commodityList = t_commodityService.selectAllCommodity(map2);
		}else if(low1==null && gategoriesName!=null) {
			map2.put("startIndex", (currentPage-1)*pageSize);//����ҳ
			map2.put("pageSize", pageSize*currentPage);//ÿҳ����
			map2.put("commodityisman", commodityisman);
			map2.put("gategoriesName",gategoriesName);
			System.out.println("û�м۸�-----liebiao3:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			commodityList = t_commodityService.selectAllCommodity4(map2);
			System.out.println("size:"+commodityList.size());
		}else if(low1 != null && gategoriesName==null){
			map2.put("startIndex", (currentPage-1)*pageSize);//����ҳ
			map2.put("pageSize", pageSize*currentPage);//ÿҳ����
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			map2.put("low", low);
			map2.put("high", high);
			System.out.println("û������-----liebiao2:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			commodityList = t_commodityService.selectAllCommodity2(map2);
			System.out.println("size:"+commodityList.size());
		}else {
			map2.put("startIndex", (currentPage-1)*pageSize);//����ҳ
			map2.put("pageSize", pageSize*currentPage);//ÿҳ����
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			System.out.println("else4:"+low+"high:"+high+":gategoriesName"+gategoriesName);
			map2.put("low", low);
			map2.put("high", high);
			map2.put("gategoriesName",gategoriesName);
			System.out.println("�м۸�������-----liebiao4:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			commodityList = t_commodityService.selectAllCommodity3(map2);
			System.out.println("size:"+commodityList.size());	
		}
		System.out.println("-----T_commodity"+commodityList.size());
			
		
		*//***//*
		//System.out.println("ManGategoriesListsize:"+ManGategoriesList.size()+":"+ManGategoriesList.get(0).getT_gategories().getGategoriesId());
		List<T_commodity> ManGategoriesLists = new ArrayList<T_commodity>();
		ManGategoriesLists.add(ManGategoriesList.get(0));
		String gname = ManGategoriesLists.get(0).getT_gategories().getGategoriesName();
		for (T_commodity t_commodity : ManGategoriesList) { 			
			if(gname.equals(t_commodity.getT_gategories().getGategoriesName())) {
				
			}else {
				ManGategoriesLists.add(t_commodity);
			}
			gname = t_commodity.getT_gategories().getGategoriesName();
		}
		//System.out.println("ɸѡ���ManGategoriesListsize:"+ManGategoriesLists.size());
		
		//���ò�ѯҳ��
		mv.addObject("commodityisman",commodityisman);
		mv.addObject("pageAll",pageAll);//��ǰ�ǵڼ�ҳ
		mv.addObject("pageNumberX",currentPage);//��ǰ�ǵڼ�ҳ
		mv.addObject("low",low1);//�۸�Χ����ǰ̨
		mv.addObject("high",high1);
		mv.addObject("gategoriesN",gategoriesName);
		request.getSession().setAttribute("ManGategoriesList", ManGategoriesLists);
		if(commodityisman.equals("��")) {
			System.out.println("��תmanǰ��");
			request.getSession().setAttribute("commodityList", commodityList);
			mv.setViewName("/shopCartClient/views/man.jsp");
		}else {
			System.out.println("��תwomanǰ��");
			request.getSession().setAttribute("commodityList", commodityList);
			mv.setViewName("/shopCartClient/views/woman.jsp");
		}
		return mv;
	}
	*/
	
	/**
	 * 1.�жϴ������ʲô��������ѯ�����Ƕ��������ݣ����һ����ҳ
	 * 2.��ѯ����Ʒ����б�
	 * 3.��ѯ���ڼ�ҳ���ڼ�ҳ��ͼƬ����
	 * */
	@RequestMapping("/shopCartClient/views/manGategories")
	public ModelAndView manGategories(HttpServletRequest request,HttpServletResponse response,ModelMap map1) {
		ModelAndView mv = new ModelAndView();
		//��ѯ��������
		Map<String,Object> map = new HashMap<String,Object>();
		
		//��װŮװrequest����
		String commodityisman = request.getParameter("commodityisman");//�Ƿ���װ
		
		String currentPage1 = request.getParameter("currentPage");//��ǰҳ��	
		//�۸��ѯrequest����
		String low1 = request.getParameter("low");//��ͼ۲�ѯ
		String high1 = request.getParameter("high");//��߼۲�ѯ
		String gategoriesName = request.getParameter("gategoriesName");//�������Ʒ����
		String gategoriesId1 = request.getParameter("gategoriesId");//��Ʒ����id
		//int gategoriesId = Integer.parseInt(gategoriesId1);
		
		//����������й�ҳ������
		int pageSize = 6;//ûҳ������
		int GategCount = 0;//�ܲ�ѯ����
		int pageAll = 0;//һ����ҳ
		int currentPage = 0;//ǰ̨���������ǰҳ����int��
		currentPage = Integer.parseInt(currentPage1);
		

		//���ݲ�ͬ��������ѯ���ж���������
		//1��ѯ������Ʒ��ʱ��2��ѯ��һ��Ʒ����������Ʒ3������Ʒ���۸��ѯ 4��һ��Ʒ������۸�Χ
		if(("" == low1 && "" == gategoriesName) || (null == low1 && "" == gategoriesName)) {
			map.put("commodityisman", commodityisman);
			GategCount = t_commodityService.selectGategCount(map);//����������
		}else if(("" == low1 && "" != gategoriesName) || (null == low1 && "" != gategoriesName)){
			map.put("commodityisman", commodityisman);
			map.put("gategoriesId", gategoriesId1);
			GategCount = t_commodityService.selectGategCount(map);//����������
		}else if(("" != low1 && "" == gategoriesName) || (null != low1 && "" == gategoriesName)){
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			GategCount = t_commodityService.selectGategCount(map);//����������
		}else{

			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			map.put("gategoriesId", gategoriesId1);
			GategCount = t_commodityService.selectGategCount(map);//����������
		}
		System.out.println("���ݲ�ͬ������ѯ����ͬ������GategCount��=---="+GategCount);
		//��ѯ�����б����ݣ����ظ���
		List<T_commodity> ManGategoriesList = t_commodityService.selectManGategories(map);//�����б���ѯ��������,���ص������Ͳ����û�
		
		/**һ������ҳ*/
		pageAll = (GategCount + pageSize -1 )/pageSize;//����һ���м�ҳ
		System.out.println("�ж�֮ǰpageAll:"+pageAll);
		//�жϲ�����һҳ������Χ
		if(currentPage < 1) {
			System.out.println("����С��");
			currentPage = 1;
		}
		if(currentPage > pageAll) {
			System.out.println("�������");
			currentPage = pageAll;
		}
		
		/***/	
		//�ڶ���map����
		Map<String,Object> map2 = new HashMap<String,Object>();
		//List<T_commodity> commodityList;
		List<T_commoditypicture> commoditypictureList = null;
		
		System.out.println("�����ж����֮ǰ�ĸ���������low1:"+low1+"gategoriesname:"+gategoriesName);
		
		if(low1=="") {
			low1 = null;
		}if(gategoriesName=="") {
			gategoriesName = null;
		}
		if(low1==null && gategoriesName==null) {
			System.out.println("��Ϊ��currentPage��"+currentPage);
			map2.put("startIndex", (currentPage-1)*pageSize);//����ҳ
			map2.put("pageSize", pageSize*currentPage);//ÿҳ����
			map2.put("commodityisman", commodityisman);
			System.out.println("��Ϊ��-----liebiao:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			//commodityList = t_commodityService.selectAllCommodity(map2);
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			//System.out.println("dddddddddddddd:" + commoditypictureList.get(0).getCommodityIsShelves() +commoditypictureList.get(0).getCpURL());
		}else if(low1==null && gategoriesName!=null) {
			map2.put("startIndex", (currentPage-1)*pageSize);//����ҳ
			map2.put("pageSize", pageSize*currentPage);//ÿҳ����
			map2.put("commodityisman", commodityisman);
			map2.put("gategoriesName",gategoriesName);
			map2.put("gategoriesId", gategoriesId1);
			System.out.println("û�м۸�-----liebiao3:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			//commodityList = t_commodityService.selectAllCommodity4(map2);
			//System.out.println("size:"+commodityList.size());
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			//System.out.println("dddddddddddddd:" + commoditypictureList.get(0).getCommodityIsShelves() +commoditypictureList.get(0).getCpURL());
		}else if(low1 != null && gategoriesName==null){
			map2.put("startIndex", (currentPage-1)*pageSize);//����ҳ
			map2.put("pageSize", pageSize*currentPage);//ÿҳ����
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			map2.put("low", low);
			map2.put("high", high);
			System.out.println("û������-----liebiao2:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			//commodityList = t_commodityService.selectAllCommodity2(map2);
			//System.out.println("size:"+commodityList.size());
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			System.out.println("dddddddddddddd:" + commoditypictureList.get(0).getCommodityIsShelves() +commoditypictureList.get(0).getCpURL());
		}else {
			map2.put("startIndex", (currentPage-1)*pageSize);//����ҳ
			map2.put("pageSize", pageSize*currentPage);//ÿҳ����
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			System.out.println("else4:"+low+"high:"+high+":gategoriesName"+gategoriesName);
			map2.put("low", low);
			map2.put("high", high);
			map2.put("gategoriesName",gategoriesName);
			map2.put("gategoriesId", gategoriesId1);
			System.out.println("�м۸�������-----liebiao4:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			//commodityList = t_commodityService.selectAllCommodity3(map2);
			//System.out.println("size:"+commodityList.size());	
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			System.out.println("dddddddddddddd:" + commoditypictureList.get(0).getCommodityIsShelves() +commoditypictureList.get(0).getCpURL());
		}
		//System.out.println("-----T_commodity"+commodityList.size());	
		//System.out.println("commodityList�ǣ�-------------"+ commodityList.get(0).getCommodityId());
		
		System.out.println("-----T_commoditypicture"+commoditypictureList.size());	
		//System.out.println("commoditypictureList�ǣ�-------------"+ commoditypictureList.get(0).getCommodityId());
		/***/
		//System.out.println(ManGategoriesList.get(0).getT_gategories().getGategoriesName()+"::"+ManGategoriesList.get(0).getT_gategories().getGategoriesId());
		//System.out.println("ManGategoriesListsize:"+ManGategoriesList.size()+":"+ManGategoriesList.get(0).getT_gategories().getGategoriesId());
		/*List<T_commodity> ManGategoriesLists = new ArrayList<T_commodity>();
		ManGategoriesLists.add(ManGategoriesList.get(0));
		//String gname = ManGategoriesLists.get(0).getT_gategories().getGategoriesName();
		String[] gname = new String[ManGategoriesList.size()];
		gname[0] = ManGategoriesLists.get(0).getT_gategories().getGategoriesName();//�����һ������ֵ
		System.out.println("gname getGategoriesName:-----------------------------------"+gname[0] + gname[1]);
		for (T_commodity t_commodity : ManGategoriesList) { 
			int center = 0;
			for(int i = 0; i < gname.length; i++){
				if(gname[i] == null){
					center = i;
					break;
				}
			}
			System.out.println("center�ǣ�"+center);
			for (int i = 0; i < gname.length; i++) {
				if(gname[i] != null){
					if(gname[i].equals(t_commodity.getT_gategories().getGategoriesName())) {
						System.out.println("for if zhong game "+gname);
					}else {
						//���ﲻ��
						
						System.out.println("��ȷ���ֵ�gname:"+gname);
						ManGategoriesLists.add(t_commodity);	
					}
				}		
			}
			gname[center] = t_commodity.getT_gategories().getGategoriesName();
			
			
			if(gname[0].equals(t_commodity.getT_gategories().getGategoriesName())) {
				System.out.println("for if zhong game "+gname);
			}else {
				System.out.println("��ȷ���ֵ�gname:"+gname);
				ManGategoriesLists.add(t_commodity);
			}
			gname[0] = t_commodity.getT_gategories().getGategoriesName();
			System.out.println("for �е�gname :"+gname);
		}
		System.out.println("ɸѡ���ManGategoriesList:"+ManGategoriesList.size());
		System.out.println("ɸѡ���ManGategoriesListsize:"+ManGategoriesLists.size());*/
		
		
		//--------
		for (int i = 0; i < ManGategoriesList.size()-1; i++) {
			for (int j =  ManGategoriesList.size()-1; j > i; j--) {
				if(ManGategoriesList.get(j).getT_gategories().getGategoriesName() == ManGategoriesList.get(i).getT_gategories().getGategoriesName()){
					 ManGategoriesList.remove(i);
				}
			}
		}
		System.out.println("ɸѡ���ManGategoriesList:"+ManGategoriesList.size());
		
		//���ò�ѯҳ��
		mv.addObject("commodityisman",commodityisman);
		mv.addObject("pageAll",pageAll);//��ǰ�ǵڼ�ҳ
		mv.addObject("pageNumberX",currentPage);//��ǰ�ǵڼ�ҳ
		mv.addObject("low",low1);//�۸�Χ����ǰ̨
		mv.addObject("high",high1);
		mv.addObject("gategoriesN",gategoriesName);
		//request.getSession().setAttribute("ManGategoriesList", ManGategoriesLists);
		request.getSession().setAttribute("ManGategoriesList", ManGategoriesList);
		if(commodityisman.equals("��")) {
			System.out.println("��תmanǰ��");
			//request.getSession().setAttribute("commodityList", commodityList);
			request.getSession().setAttribute("commoditypictureList", commoditypictureList);
			mv.setViewName("/shopCartClient/views/man.jsp");
		}else {
			System.out.println("��תwomanǰ��");
			//request.getSession().setAttribute("commodityList", commodityList);
			request.getSession().setAttribute("commoditypictureList", commoditypictureList);
			mv.setViewName("/shopCartClient/views/woman.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/shopCartClient/views/toSinglejsp")
	public ModelAndView toSinglejsp(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String commodityId = request.getParameter("commodityId");
		String commodityPrice = request.getParameter("commodityPrice");
		String commodityName = request.getParameter("commodityName");
		String cpURL = request.getParameter("cpURL");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("commodityId", commodityId);
		List<T_picture> pictureList = t_commodityService.selectAllCommoditypicture(map);
		//System.out.println("111111111111111111:"+pictureList.size()+pictureList.get(0).getCpURL()+pictureList.get(1).getCpURL());
		
		mv.addObject("commodityId",commodityId);
		mv.addObject("commodityPrice",commodityPrice);
		mv.addObject("commodityName",commodityName);
		mv.addObject("cpURL",cpURL);
		request.getSession(true).setAttribute("pictureList", pictureList);//ǰ̨һ��Ҫ����jstl��ǩ��
		mv.setViewName("/shopCartClient/views/single.jsp");
		return mv;
	}
}

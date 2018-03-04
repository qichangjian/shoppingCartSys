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

@Controller
public class T_commodityController {
	@Autowired
	private T_commodityService t_commodityService;
	
	
	
	public void setT_commodityService(T_commodityService t_commodityService) {
		this.t_commodityService = t_commodityService;
	}
	
	@RequestMapping("/shopCartClient/views/manGategories")
	public ModelAndView manGategories(HttpServletRequest request,HttpServletResponse response,ModelMap map1) {
		System.out.println("����manGategories");
		int pageSize = 6;//ûҳ������
		int GategCount = 0;//�ܲ�ѯ����
		int pageAll = 0;//һ����ҳ
		int currentPage = 0;//ǰ̨���������ǰҳ����int��
		ModelAndView mv = new ModelAndView();
		
		String commodityisman = request.getParameter("commodityisman");
		String currentPage1 = request.getParameter("currentPage");
		currentPage = Integer.parseInt(currentPage1);
		System.out.println("ǰ̨currentPage:"+currentPage);
		
		String low1 = request.getParameter("low");
		String high1 = request.getParameter("high");
		String gategoriesName = request.getParameter("gategoriesName");//���������
		/*Integer low = Integer.parseInt(low1) ;
		Integer high = Integer.parseInt(high1);*/
		
		System.out.println("�Ƿ�������۸�"+low1+":"+high1);
		
		
		System.out.println("T_controller��"+commodityisman);
		Map<String,Object> map = new HashMap<String,Object>();
		/*if(low1 == "" || low1 == null) {
			map.put("commodityisman", commodityisman);
			GategCount = t_commodityService.selectGategCount(map);//����������
		}else {
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			GategCount = t_commodityService.selectGategCount(map);//����������
		}*/
		if(low1 == "" || low1 == null) {
			map.put("commodityisman", commodityisman);
			GategCount = t_commodityService.selectGategCount1(map);//����������
		}else {
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			GategCount = t_commodityService.selectGategCount2(map);//����������
		}
		
		/**һ������ҳ*/
		
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
		/***/
		
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
			
		
		/***/
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
	
	
}

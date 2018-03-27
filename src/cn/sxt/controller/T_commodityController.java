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
		System.out.println("进入manGategories");
		int pageSize = 6;//没页多少条
		int GategCount = 0;//总查询条数
		int pageAll = 0;//一共几页
		int currentPage = 0;//前台传输过来当前页数（int）
		ModelAndView mv = new ModelAndView();
		
		String commodityisman = request.getParameter("commodityisman");//是否男装
		String currentPage1 = request.getParameter("currentPage");//当前页数
		currentPage = Integer.parseInt(currentPage1);
		System.out.println("前台currentPage:"+currentPage);
		
		String low1 = request.getParameter("low");//最低价查询
		String high1 = request.getParameter("high");//最高价查询
		String gategoriesName = request.getParameter("gategoriesName");//传入的商品类型
		Integer low = Integer.parseInt(low1) ;
		Integer high = Integer.parseInt(high1);
		
		System.out.println("是否传如参数价格："+low1+":"+high1);
		
		
		System.out.println("T_controller："+commodityisman);
		Map<String,Object> map = new HashMap<String,Object>();
		if(low1 == "" || low1 == null) {
			map.put("commodityisman", commodityisman);
			GategCount = t_commodityService.selectGategCount(map);//多少条数据
		}else {
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			GategCount = t_commodityService.selectGategCount(map);//多少条数据
		}
		if(low1 == "" || low1 == null) {
			map.put("commodityisman", commodityisman);
			GategCount = t_commodityService.selectGategCount1(map);//多少条数据
		}else {
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			GategCount = t_commodityService.selectGategCount2(map);//多少条数据
		}
		
		*//**一共多少页*//*
		
		System.out.println(map.get("commodityisman")+":"+map.get("low")+"--++GategCount:"+GategCount+":gategoriesName="+gategoriesName);
		pageAll = GategCount/pageSize + 1;//计算一共有几页

		System.out.println("判断之前pageAll:"+pageAll);
		if(currentPage < 1) {
			System.out.println("进入小于");
			currentPage = 1;
		}
		if(currentPage > pageAll) {
			System.out.println("进入大于");
			currentPage = pageAll;
		}
		List<T_commodity> ManGategoriesList = t_commodityService.selectManGategories(map);//查询男生类型,返回的是类型不是用户
		*//***//*
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		List<T_commodity> commodityList;
		System.out.println("进入判断语句之前的各个参数：low1:"+low1+"gategoriesname:"+gategoriesName);
		
		if(low1=="") {
			low1 = null;
		}if(gategoriesName=="") {
			gategoriesName = null;
		}
		if(low1==null && gategoriesName==null) {
			System.out.println("都为空currentPage："+currentPage);
			map2.put("startIndex", (currentPage-1)*pageSize);//多少页
			map2.put("pageSize", pageSize*currentPage);//每页多少
			map2.put("commodityisman", commodityisman);
			System.out.println("都为空-----liebiao:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			commodityList = t_commodityService.selectAllCommodity(map2);
		}else if(low1==null && gategoriesName!=null) {
			map2.put("startIndex", (currentPage-1)*pageSize);//多少页
			map2.put("pageSize", pageSize*currentPage);//每页多少
			map2.put("commodityisman", commodityisman);
			map2.put("gategoriesName",gategoriesName);
			System.out.println("没有价格-----liebiao3:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			commodityList = t_commodityService.selectAllCommodity4(map2);
			System.out.println("size:"+commodityList.size());
		}else if(low1 != null && gategoriesName==null){
			map2.put("startIndex", (currentPage-1)*pageSize);//多少页
			map2.put("pageSize", pageSize*currentPage);//每页多少
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			map2.put("low", low);
			map2.put("high", high);
			System.out.println("没有类型-----liebiao2:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			commodityList = t_commodityService.selectAllCommodity2(map2);
			System.out.println("size:"+commodityList.size());
		}else {
			map2.put("startIndex", (currentPage-1)*pageSize);//多少页
			map2.put("pageSize", pageSize*currentPage);//每页多少
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			System.out.println("else4:"+low+"high:"+high+":gategoriesName"+gategoriesName);
			map2.put("low", low);
			map2.put("high", high);
			map2.put("gategoriesName",gategoriesName);
			System.out.println("有价格，有类型-----liebiao4:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
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
		//System.out.println("筛选后的ManGategoriesListsize:"+ManGategoriesLists.size());
		
		//调用查询页面
		mv.addObject("commodityisman",commodityisman);
		mv.addObject("pageAll",pageAll);//当前是第几页
		mv.addObject("pageNumberX",currentPage);//当前是第几页
		mv.addObject("low",low1);//价格范围传回前台
		mv.addObject("high",high1);
		mv.addObject("gategoriesN",gategoriesName);
		request.getSession().setAttribute("ManGategoriesList", ManGategoriesLists);
		if(commodityisman.equals("男")) {
			System.out.println("跳转man前边");
			request.getSession().setAttribute("commodityList", commodityList);
			mv.setViewName("/shopCartClient/views/man.jsp");
		}else {
			System.out.println("跳转woman前边");
			request.getSession().setAttribute("commodityList", commodityList);
			mv.setViewName("/shopCartClient/views/woman.jsp");
		}
		return mv;
	}
	*/
	
	/**
	 * 1.判断传入的是什么参数。查询出来是多少条数据，算出一共几页
	 * 2.查询出商品类别列表
	 * 3.查询出第几页到第几页的图片数据
	 * */
	@RequestMapping("/shopCartClient/views/manGategories")
	public ModelAndView manGategories(HttpServletRequest request,HttpServletResponse response,ModelMap map1) {
		ModelAndView mv = new ModelAndView();
		//查询参数定义
		Map<String,Object> map = new HashMap<String,Object>();
		
		//男装女装request接收
		String commodityisman = request.getParameter("commodityisman");//是否男装
		
		String currentPage1 = request.getParameter("currentPage");//当前页数	
		//价格查询request接收
		String low1 = request.getParameter("low");//最低价查询
		String high1 = request.getParameter("high");//最高价查询
		String gategoriesName = request.getParameter("gategoriesName");//传入的商品类型
		String gategoriesId1 = request.getParameter("gategoriesId");//商品类型id
		//int gategoriesId = Integer.parseInt(gategoriesId1);
		
		//定义变量：有关页面数据
		int pageSize = 6;//没页多少条
		int GategCount = 0;//总查询条数
		int pageAll = 0;//一共几页
		int currentPage = 0;//前台传输过来当前页数（int）
		currentPage = Integer.parseInt(currentPage1);
		

		//根据不同的条件查询出有多少条数据
		//1查询所有商品的时候2查询单一商品种类所有商品3所有商品带价格查询 4单一商品种类带价格范围
		if(("" == low1 && "" == gategoriesName) || (null == low1 && "" == gategoriesName)) {
			map.put("commodityisman", commodityisman);
			GategCount = t_commodityService.selectGategCount(map);//多少条数据
		}else if(("" == low1 && "" != gategoriesName) || (null == low1 && "" != gategoriesName)){
			map.put("commodityisman", commodityisman);
			map.put("gategoriesId", gategoriesId1);
			GategCount = t_commodityService.selectGategCount(map);//多少条数据
		}else if(("" != low1 && "" == gategoriesName) || (null != low1 && "" == gategoriesName)){
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			GategCount = t_commodityService.selectGategCount(map);//多少条数据
		}else{

			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			map.put("gategoriesId", gategoriesId1);
			GategCount = t_commodityService.selectGategCount(map);//多少条数据
		}
		System.out.println("根据不同条件查询出不同的数据GategCount：=---="+GategCount);
		//查询返回列表数据：有重复的
		List<T_commodity> ManGategoriesList = t_commodityService.selectManGategories(map);//返回列表：查询男生类型,返回的是类型不是用户
		
		/**一共多少页*/
		pageAll = (GategCount + pageSize -1 )/pageSize;//计算一共有几页
		System.out.println("判断之前pageAll:"+pageAll);
		//判断不能下一页超出范围
		if(currentPage < 1) {
			System.out.println("进入小于");
			currentPage = 1;
		}
		if(currentPage > pageAll) {
			System.out.println("进入大于");
			currentPage = pageAll;
		}
		
		/***/	
		//第二个map参数
		Map<String,Object> map2 = new HashMap<String,Object>();
		//List<T_commodity> commodityList;
		List<T_commoditypicture> commoditypictureList = null;
		
		System.out.println("进入判断语句之前的各个参数：low1:"+low1+"gategoriesname:"+gategoriesName);
		
		if(low1=="") {
			low1 = null;
		}if(gategoriesName=="") {
			gategoriesName = null;
		}
		if(low1==null && gategoriesName==null) {
			System.out.println("都为空currentPage："+currentPage);
			map2.put("startIndex", (currentPage-1)*pageSize);//多少页
			map2.put("pageSize", pageSize*currentPage);//每页多少
			map2.put("commodityisman", commodityisman);
			System.out.println("都为空-----liebiao:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			//commodityList = t_commodityService.selectAllCommodity(map2);
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			//System.out.println("dddddddddddddd:" + commoditypictureList.get(0).getCommodityIsShelves() +commoditypictureList.get(0).getCpURL());
		}else if(low1==null && gategoriesName!=null) {
			map2.put("startIndex", (currentPage-1)*pageSize);//多少页
			map2.put("pageSize", pageSize*currentPage);//每页多少
			map2.put("commodityisman", commodityisman);
			map2.put("gategoriesName",gategoriesName);
			map2.put("gategoriesId", gategoriesId1);
			System.out.println("没有价格-----liebiao3:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			//commodityList = t_commodityService.selectAllCommodity4(map2);
			//System.out.println("size:"+commodityList.size());
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			//System.out.println("dddddddddddddd:" + commoditypictureList.get(0).getCommodityIsShelves() +commoditypictureList.get(0).getCpURL());
		}else if(low1 != null && gategoriesName==null){
			map2.put("startIndex", (currentPage-1)*pageSize);//多少页
			map2.put("pageSize", pageSize*currentPage);//每页多少
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			map2.put("low", low);
			map2.put("high", high);
			System.out.println("没有类型-----liebiao2:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			//commodityList = t_commodityService.selectAllCommodity2(map2);
			//System.out.println("size:"+commodityList.size());
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			System.out.println("dddddddddddddd:" + commoditypictureList.get(0).getCommodityIsShelves() +commoditypictureList.get(0).getCpURL());
		}else {
			map2.put("startIndex", (currentPage-1)*pageSize);//多少页
			map2.put("pageSize", pageSize*currentPage);//每页多少
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			System.out.println("else4:"+low+"high:"+high+":gategoriesName"+gategoriesName);
			map2.put("low", low);
			map2.put("high", high);
			map2.put("gategoriesName",gategoriesName);
			map2.put("gategoriesId", gategoriesId1);
			System.out.println("有价格，有类型-----liebiao4:"+(currentPage-1)*pageSize +":"+pageSize+":"+pageSize*currentPage);
			//commodityList = t_commodityService.selectAllCommodity3(map2);
			//System.out.println("size:"+commodityList.size());	
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			System.out.println("dddddddddddddd:" + commoditypictureList.get(0).getCommodityIsShelves() +commoditypictureList.get(0).getCpURL());
		}
		//System.out.println("-----T_commodity"+commodityList.size());	
		//System.out.println("commodityList是：-------------"+ commodityList.get(0).getCommodityId());
		
		System.out.println("-----T_commoditypicture"+commoditypictureList.size());	
		//System.out.println("commoditypictureList是：-------------"+ commoditypictureList.get(0).getCommodityId());
		/***/
		//System.out.println(ManGategoriesList.get(0).getT_gategories().getGategoriesName()+"::"+ManGategoriesList.get(0).getT_gategories().getGategoriesId());
		//System.out.println("ManGategoriesListsize:"+ManGategoriesList.size()+":"+ManGategoriesList.get(0).getT_gategories().getGategoriesId());
		/*List<T_commodity> ManGategoriesLists = new ArrayList<T_commodity>();
		ManGategoriesLists.add(ManGategoriesList.get(0));
		//String gname = ManGategoriesLists.get(0).getT_gategories().getGategoriesName();
		String[] gname = new String[ManGategoriesList.size()];
		gname[0] = ManGategoriesLists.get(0).getT_gategories().getGategoriesName();//数组第一个数赋值
		System.out.println("gname getGategoriesName:-----------------------------------"+gname[0] + gname[1]);
		for (T_commodity t_commodity : ManGategoriesList) { 
			int center = 0;
			for(int i = 0; i < gname.length; i++){
				if(gname[i] == null){
					center = i;
					break;
				}
			}
			System.out.println("center是："+center);
			for (int i = 0; i < gname.length; i++) {
				if(gname[i] != null){
					if(gname[i].equals(t_commodity.getT_gategories().getGategoriesName())) {
						System.out.println("for if zhong game "+gname);
					}else {
						//这里不对
						
						System.out.println("正确出现的gname:"+gname);
						ManGategoriesLists.add(t_commodity);	
					}
				}		
			}
			gname[center] = t_commodity.getT_gategories().getGategoriesName();
			
			
			if(gname[0].equals(t_commodity.getT_gategories().getGategoriesName())) {
				System.out.println("for if zhong game "+gname);
			}else {
				System.out.println("正确出现的gname:"+gname);
				ManGategoriesLists.add(t_commodity);
			}
			gname[0] = t_commodity.getT_gategories().getGategoriesName();
			System.out.println("for 中的gname :"+gname);
		}
		System.out.println("筛选后的ManGategoriesList:"+ManGategoriesList.size());
		System.out.println("筛选后的ManGategoriesListsize:"+ManGategoriesLists.size());*/
		
		
		//--------
		for (int i = 0; i < ManGategoriesList.size()-1; i++) {
			for (int j =  ManGategoriesList.size()-1; j > i; j--) {
				if(ManGategoriesList.get(j).getT_gategories().getGategoriesName() == ManGategoriesList.get(i).getT_gategories().getGategoriesName()){
					 ManGategoriesList.remove(i);
				}
			}
		}
		System.out.println("筛选后的ManGategoriesList:"+ManGategoriesList.size());
		
		//调用查询页面
		mv.addObject("commodityisman",commodityisman);
		mv.addObject("pageAll",pageAll);//当前是第几页
		mv.addObject("pageNumberX",currentPage);//当前是第几页
		mv.addObject("low",low1);//价格范围传回前台
		mv.addObject("high",high1);
		mv.addObject("gategoriesN",gategoriesName);
		//request.getSession().setAttribute("ManGategoriesList", ManGategoriesLists);
		request.getSession().setAttribute("ManGategoriesList", ManGategoriesList);
		if(commodityisman.equals("男")) {
			System.out.println("跳转man前边");
			//request.getSession().setAttribute("commodityList", commodityList);
			request.getSession().setAttribute("commoditypictureList", commoditypictureList);
			mv.setViewName("/shopCartClient/views/man.jsp");
		}else {
			System.out.println("跳转woman前边");
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
		request.getSession(true).setAttribute("pictureList", pictureList);//前台一定要导入jstl标签库
		mv.setViewName("/shopCartClient/views/single.jsp");
		return mv;
	}
}

package cn.sxt.controller;

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
import cn.sxt.vo.T_commodityComment;
import cn.sxt.vo.T_commoditypicture;
import cn.sxt.vo.T_picture;

@Controller
public class T_commodityController {
	@Autowired
	private T_commodityService t_commodityService;

	public void setT_commodityService(T_commodityService t_commodityService) {
		this.t_commodityService = t_commodityService;
	}

	/**
	 * 1.判断传入的是什么参数。查询出来是多少条数据，算出一共几页 2.查询出商品类别列表 3.查询出第几页到第几页的图片数据
	 */
	@RequestMapping("/shopCartClient/views/manGategories")
	public ModelAndView manGategories(HttpServletRequest request, HttpServletResponse response, ModelMap map1) {
		ModelAndView mv = new ModelAndView();
		// 查询参数定义
		Map<String, Object> map = new HashMap<String, Object>();

		// 男装女装request接收
		String commodityisman = request.getParameter("commodityisman");// 是否男装

		String currentPage1 = request.getParameter("currentPage");// 当前页数
		// 价格查询request接收
		String low1 = request.getParameter("low");// 最低价查询
		String high1 = request.getParameter("high");// 最高价查询
		String gategoriesName = request.getParameter("gategoriesName");// 传入的商品类型
		System.out.println("gategoriesName" + gategoriesName);
		String gategoriesId1 = request.getParameter("gategoriesId");// 商品类型id
		// int gategoriesId = Integer.parseInt(gategoriesId1);

		// 定义变量：有关页面数据
		int pageSize = 6;// 没页多少条
		int GategCount = 0;// 总查询条数
		int pageAll = 0;// 一共几页
		int currentPage = 0;// 前台传输过来当前页数（int）
		currentPage = Integer.parseInt(currentPage1);

		// 根据不同的条件查询出有多少条数据
		// 1查询所有商品的时候2查询单一商品种类所有商品3所有商品带价格查询 4单一商品种类带价格范围
		if (("" == low1 && "" == gategoriesName) || (null == low1 && "" == gategoriesName)
				|| ("" == low1 && null == gategoriesName) || (null == low1 && null == gategoriesName)) {
			System.out.println("--------------------------------------1");
			map.put("commodityisman", commodityisman);
			GategCount = t_commodityService.selectGategCount(map);// 多少条数据
		} else if (("" == low1 && "" != gategoriesName) || (null == low1 && "" != gategoriesName)
				|| ("" == low1 && null != gategoriesName) || (null == low1 && null != gategoriesName)) {
			System.out.println("--------------------------------------2");
			map.put("commodityisman", commodityisman);
			map.put("gategoriesId", gategoriesId1);
			GategCount = t_commodityService.selectGategCount(map);// 多少条数据
		} else if (("" != low1 && "" == gategoriesName) || (null != low1 && "" == gategoriesName)
				|| ("" != low1 && null == gategoriesName) || (null != low1 && null == gategoriesName)) {
			System.out.println("--------------------------------------3");
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			GategCount = t_commodityService.selectGategCount(map);// 多少条数据
		} else {
			System.out.println("--------------------------------------4");
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			map.put("gategoriesId", gategoriesId1);
			GategCount = t_commodityService.selectGategCount(map);// 多少条数据
		}
		System.out.println("根据不同条件查询出不同的数据GategCount：=---=" + GategCount);
		// 查询返回列表数据：有重复的
		List<T_commodity> ManGategoriesList = t_commodityService.selectManGategories(map);// 返回列表：查询男生类型,返回的是类型不是用户

		/** 一共多少页 */
		pageAll = (GategCount + pageSize - 1) / pageSize;// 计算一共有几页
		System.out.println("判断之前pageAll:" + pageAll);
		// 判断不能下一页超出范围
		if (currentPage < 1) {
			System.out.println("进入小于");
			currentPage = 1;
		}
		if (currentPage > pageAll) {
			System.out.println("进入大于");
			currentPage = pageAll;
		}

		/***/
		// 第二个map参数
		Map<String, Object> map2 = new HashMap<String, Object>();
		// List<T_commodity> commodityList;
		List<T_commoditypicture> commoditypictureList = null;
		// System.out.println("进入判断语句之前的各个参数：low1:"+low1+"gategoriesname:"+gategoriesName);

		if (low1 == "") {
			low1 = null;
		}
		if (gategoriesName == "") {
			gategoriesName = null;
		}
		if (low1 == null && gategoriesName == null) {
			System.out.println("都为空currentPage：" + currentPage);
			map2.put("startIndex", (currentPage - 1) * pageSize);// 多少页
			map2.put("pageSize", pageSize * currentPage);// 每页多少
			map2.put("commodityisman", commodityisman);
			// System.out.println("都为空-----liebiao:"+(currentPage-1)*pageSize
			// +":"+pageSize+":"+pageSize*currentPage);
			// commodityList = t_commodityService.selectAllCommodity(map2);
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			// System.out.println("dddddddddddddd:" +
			// commoditypictureList.get(0).getCommodityIsShelves()
			// +commoditypictureList.get(0).getCpURL());
		} else if (low1 == null && gategoriesName != null) {
			map2.put("startIndex", (currentPage - 1) * pageSize);// 多少页
			map2.put("pageSize", pageSize * currentPage);// 每页多少
			map2.put("commodityisman", commodityisman);
			map2.put("gategoriesName", gategoriesName);
			map2.put("gategoriesId", gategoriesId1);
			// System.out.println("没有价格-----liebiao3:"+(currentPage-1)*pageSize
			// +":"+pageSize+":"+pageSize*currentPage);
			// commodityList = t_commodityService.selectAllCommodity4(map2);
			// System.out.println("size:"+commodityList.size());
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			// System.out.println("dddddddddddddd:" +
			// commoditypictureList.get(0).getCommodityIsShelves()
			// +commoditypictureList.get(0).getCpURL());
		} else if (low1 != null && gategoriesName == null) {
			map2.put("startIndex", (currentPage - 1) * pageSize);// 多少页
			map2.put("pageSize", pageSize * currentPage);// 每页多少
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			map2.put("low", low);
			map2.put("high", high);
			System.out.println("没有类型-----liebiao2:" + (currentPage - 1) * pageSize + ":" + pageSize + ":"
					+ pageSize * currentPage);
			// commodityList = t_commodityService.selectAllCommodity2(map2);
			// System.out.println("size:"+commodityList.size());
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			// System.out.println("dddddddddddddd:" +
			// commoditypictureList.get(0).getCommodityIsShelves()
			// +commoditypictureList.get(0).getCpURL());
		} else {
			map2.put("startIndex", (currentPage - 1) * pageSize);// 多少页
			map2.put("pageSize", pageSize * currentPage);// 每页多少
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			// System.out.println("else4:"+low+"high:"+high+":gategoriesName"+gategoriesName);
			map2.put("low", low);
			map2.put("high", high);
			map2.put("gategoriesName", gategoriesName);
			map2.put("gategoriesId", gategoriesId1);
			// System.out.println("有价格，有类型-----liebiao4:"+(currentPage-1)*pageSize
			// +":"+pageSize+":"+pageSize*currentPage);
			// commodityList = t_commodityService.selectAllCommodity3(map2);
			// System.out.println("size:"+commodityList.size());
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			// System.out.println("dddddddddddddd:" +
			// commoditypictureList.get(0).getCommodityIsShelves()
			// +commoditypictureList.get(0).getCpURL());
		}
		// System.out.println("-----T_commodity"+commodityList.size());
		// System.out.println("commodityList是：-------------"+
		// commodityList.get(0).getCommodityId());
		// System.out.println("-----T_commoditypicture"+commoditypictureList.size());
		// System.out.println("commoditypictureList是：-------------"+
		// commoditypictureList.get(0).getCommodityId());
		/***/

		// --------
		for (int i = 0; i < ManGategoriesList.size() - 1; i++) {
			for (int j = ManGategoriesList.size() - 1; j > i; j--) {
				if (ManGategoriesList.get(j).getT_gategories().getGategoriesName() == ManGategoriesList.get(i)
						.getT_gategories().getGategoriesName()) {
					ManGategoriesList.remove(i);
				}
			}
		}
		// System.out.println("筛选后的ManGategoriesList:"+ManGategoriesList.size());

		// 调用查询页面
		mv.addObject("commodityisman", commodityisman);
		mv.addObject("pageAll", pageAll);// 当前是第几页
		mv.addObject("pageNumberX", currentPage);// 当前是第几页
		mv.addObject("low", low1);// 价格范围传回前台
		mv.addObject("high", high1);
		mv.addObject("gategoriesN", gategoriesName);
		mv.addObject("gategoriesI", gategoriesId1);
		// request.getSession().setAttribute("ManGategoriesList",
		// ManGategoriesLists);
		request.getSession().setAttribute("ManGategoriesList", ManGategoriesList);
		if (commodityisman.equals("男")) {
			System.out.println("跳转man前边");
			// request.getSession().setAttribute("commodityList",
			// commodityList);
			request.getSession().setAttribute("commoditypictureList", commoditypictureList);
			mv.setViewName("/shopCartClient/views/man.jsp");
		} else {
			System.out.println("跳转woman前边");
			// request.getSession().setAttribute("commodityList",
			// commodityList);
			request.getSession().setAttribute("commoditypictureList", commoditypictureList);
			mv.setViewName("/shopCartClient/views/woman.jsp");
		}
		return mv;
	}

	@RequestMapping("/shopCartClient/views/toSinglejsp")
	public ModelAndView toSinglejsp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String commodityId = request.getParameter("commodityId");
		String commodityPrice = request.getParameter("commodityPrice");
		String commodityName = request.getParameter("commodityName");
		String cpURL = request.getParameter("cpURL");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commodityId", commodityId);
		List<T_picture> pictureList = t_commodityService.selectAllCommoditypicture(map);

		// System.out.println("111111111111111111:"+pictureList.size()+pictureList.get(0).getCpURL()+pictureList.get(1).getCpURL());

		mv.addObject("commodityId", commodityId);
		mv.addObject("commodityPrice", commodityPrice);
		mv.addObject("commodityName", commodityName);
		mv.addObject("cpURL", cpURL);
		request.getSession(true).setAttribute("pictureList", pictureList);// 前台一定要导入jstl标签库
		mv.setViewName("/shopCartClient/views/single.jsp");
		return mv;
	}

	@RequestMapping("/shopCartClient/views/toCommodityComment")
	public ModelAndView toCommodityComment(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String currentPage1 = request.getParameter("currentPage");// 当前页数
		String commodityId = request.getParameter("commodityId");
		// 定义变量：有关页面数据
		int pageSize = 10;// 没页多少条
		int GategCount = 0;// 总查询条数
		int pageAll = 0;// 一共几页
		int currentPage = 0;// 前台传输过来当前页数（int）
		currentPage = Integer.parseInt(currentPage1);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commodityId", commodityId);
		GategCount = t_commodityService.selectCommentCount(map);// 多少条数据
		System.out.println("GategCount:" + GategCount);
		/** 一共多少页 */
		pageAll = (GategCount + pageSize - 1) / pageSize;// 计算一共有几页
		System.out.println(pageAll + ":" + currentPage);
		// 判断不能下一页超出范围
		if (currentPage < 1) {
			System.out.println("进入小于");
			currentPage = 1;
		}
		if (currentPage > pageAll) {
			System.out.println("进入大于");
			currentPage = pageAll;
		}
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("commodityId", commodityId);
		map1.put("startIndex", (currentPage - 1) * pageSize);// 多少页
		map1.put("pageSize", pageSize * currentPage);// 每页多少
		List<T_commodityComment> commodityCommentList = t_commodityService.selectCommodityCommentById(map1);
		mv.addObject("commodityId", commodityId);
		mv.addObject("pageAll", pageAll);// 当前是第几页
		mv.addObject("pageNumberX", currentPage);// 当前是第几页
		request.getSession(true).setAttribute("commodityCommentList", commodityCommentList);// 前台一定要导入jstl标签库
		if(commodityCommentList.size() == 0){
			mv.addObject("commodityCommentListTip", "当前商品没有评论");// 当前是第几页
		}
		mv.setViewName("/shopCartClient/views/commodityComment.jsp");
		return mv;
	}

	@RequestMapping(value = "/shopCartClient/views/addContactUs", produces = "text/plain;charset=utf-8")
	public ModelAndView addContactUs(HttpServletRequest request, HttpServletResponse response, ModelMap map1) {
		ModelAndView mv = new ModelAndView();
		String userId1 = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String contactusSubject = request.getParameter("contactusSubject");
		String contactusContent = request.getParameter("contactusContent");
		System.out.println("1前台传输过来的 数据" + contactusSubject);
		if (null == userId1 || "" == userId1) {
			String userNameisNull = "请先登录";
			mv.addObject("userNameisNull", userNameisNull);
			mv.setViewName("/shopCartClient/views/login.jsp");
			return mv;
		} else {
			int userId = Integer.parseInt(userId1);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", userId);
			map.put("userName", userName);
			map.put("contactusSubject", contactusSubject);
			map.put("contactusContent", contactusContent);
			int isaddContactUs = t_commodityService.addContactUs(map);
			if (isaddContactUs == 1) {
				mv.addObject("contactusTip", "留言成功");
				mv.setViewName("/shopCartClient/views/contactUs.jsp");
			} else {
				mv.addObject("contactusTip", "留言失败");
				mv.setViewName("/shopCartClient/views/contactUs.jsp");
			}
		}
		return mv;
	}
}

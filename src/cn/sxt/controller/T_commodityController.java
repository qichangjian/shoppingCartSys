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
	 * 1.�жϴ������ʲô��������ѯ�����Ƕ��������ݣ����һ����ҳ 2.��ѯ����Ʒ����б� 3.��ѯ���ڼ�ҳ���ڼ�ҳ��ͼƬ����
	 */
	@RequestMapping("/shopCartClient/views/manGategories")
	public ModelAndView manGategories(HttpServletRequest request, HttpServletResponse response, ModelMap map1) {
		ModelAndView mv = new ModelAndView();
		// ��ѯ��������
		Map<String, Object> map = new HashMap<String, Object>();

		// ��װŮװrequest����
		String commodityisman = request.getParameter("commodityisman");// �Ƿ���װ

		String currentPage1 = request.getParameter("currentPage");// ��ǰҳ��
		// �۸��ѯrequest����
		String low1 = request.getParameter("low");// ��ͼ۲�ѯ
		String high1 = request.getParameter("high");// ��߼۲�ѯ
		String gategoriesName = request.getParameter("gategoriesName");// �������Ʒ����
		System.out.println("gategoriesName" + gategoriesName);
		String gategoriesId1 = request.getParameter("gategoriesId");// ��Ʒ����id
		// int gategoriesId = Integer.parseInt(gategoriesId1);

		// ����������й�ҳ������
		int pageSize = 6;// ûҳ������
		int GategCount = 0;// �ܲ�ѯ����
		int pageAll = 0;// һ����ҳ
		int currentPage = 0;// ǰ̨���������ǰҳ����int��
		currentPage = Integer.parseInt(currentPage1);

		// ���ݲ�ͬ��������ѯ���ж���������
		// 1��ѯ������Ʒ��ʱ��2��ѯ��һ��Ʒ����������Ʒ3������Ʒ���۸��ѯ 4��һ��Ʒ������۸�Χ
		if (("" == low1 && "" == gategoriesName) || (null == low1 && "" == gategoriesName)
				|| ("" == low1 && null == gategoriesName) || (null == low1 && null == gategoriesName)) {
			System.out.println("--------------------------------------1");
			map.put("commodityisman", commodityisman);
			GategCount = t_commodityService.selectGategCount(map);// ����������
		} else if (("" == low1 && "" != gategoriesName) || (null == low1 && "" != gategoriesName)
				|| ("" == low1 && null != gategoriesName) || (null == low1 && null != gategoriesName)) {
			System.out.println("--------------------------------------2");
			map.put("commodityisman", commodityisman);
			map.put("gategoriesId", gategoriesId1);
			GategCount = t_commodityService.selectGategCount(map);// ����������
		} else if (("" != low1 && "" == gategoriesName) || (null != low1 && "" == gategoriesName)
				|| ("" != low1 && null == gategoriesName) || (null != low1 && null == gategoriesName)) {
			System.out.println("--------------------------------------3");
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			GategCount = t_commodityService.selectGategCount(map);// ����������
		} else {
			System.out.println("--------------------------------------4");
			map.put("commodityisman", commodityisman);
			map.put("low", low1);
			map.put("high", high1);
			map.put("gategoriesId", gategoriesId1);
			GategCount = t_commodityService.selectGategCount(map);// ����������
		}
		System.out.println("���ݲ�ͬ������ѯ����ͬ������GategCount��=---=" + GategCount);
		// ��ѯ�����б����ݣ����ظ���
		List<T_commodity> ManGategoriesList = t_commodityService.selectManGategories(map);// �����б���ѯ��������,���ص������Ͳ����û�

		/** һ������ҳ */
		pageAll = (GategCount + pageSize - 1) / pageSize;// ����һ���м�ҳ
		System.out.println("�ж�֮ǰpageAll:" + pageAll);
		// �жϲ�����һҳ������Χ
		if (currentPage < 1) {
			System.out.println("����С��");
			currentPage = 1;
		}
		if (currentPage > pageAll) {
			System.out.println("�������");
			currentPage = pageAll;
		}

		/***/
		// �ڶ���map����
		Map<String, Object> map2 = new HashMap<String, Object>();
		// List<T_commodity> commodityList;
		List<T_commoditypicture> commoditypictureList = null;
		// System.out.println("�����ж����֮ǰ�ĸ���������low1:"+low1+"gategoriesname:"+gategoriesName);

		if (low1 == "") {
			low1 = null;
		}
		if (gategoriesName == "") {
			gategoriesName = null;
		}
		if (low1 == null && gategoriesName == null) {
			System.out.println("��Ϊ��currentPage��" + currentPage);
			map2.put("startIndex", (currentPage - 1) * pageSize);// ����ҳ
			map2.put("pageSize", pageSize * currentPage);// ÿҳ����
			map2.put("commodityisman", commodityisman);
			// System.out.println("��Ϊ��-----liebiao:"+(currentPage-1)*pageSize
			// +":"+pageSize+":"+pageSize*currentPage);
			// commodityList = t_commodityService.selectAllCommodity(map2);
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			// System.out.println("dddddddddddddd:" +
			// commoditypictureList.get(0).getCommodityIsShelves()
			// +commoditypictureList.get(0).getCpURL());
		} else if (low1 == null && gategoriesName != null) {
			map2.put("startIndex", (currentPage - 1) * pageSize);// ����ҳ
			map2.put("pageSize", pageSize * currentPage);// ÿҳ����
			map2.put("commodityisman", commodityisman);
			map2.put("gategoriesName", gategoriesName);
			map2.put("gategoriesId", gategoriesId1);
			// System.out.println("û�м۸�-----liebiao3:"+(currentPage-1)*pageSize
			// +":"+pageSize+":"+pageSize*currentPage);
			// commodityList = t_commodityService.selectAllCommodity4(map2);
			// System.out.println("size:"+commodityList.size());
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			// System.out.println("dddddddddddddd:" +
			// commoditypictureList.get(0).getCommodityIsShelves()
			// +commoditypictureList.get(0).getCpURL());
		} else if (low1 != null && gategoriesName == null) {
			map2.put("startIndex", (currentPage - 1) * pageSize);// ����ҳ
			map2.put("pageSize", pageSize * currentPage);// ÿҳ����
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			map2.put("low", low);
			map2.put("high", high);
			System.out.println("û������-----liebiao2:" + (currentPage - 1) * pageSize + ":" + pageSize + ":"
					+ pageSize * currentPage);
			// commodityList = t_commodityService.selectAllCommodity2(map2);
			// System.out.println("size:"+commodityList.size());
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			// System.out.println("dddddddddddddd:" +
			// commoditypictureList.get(0).getCommodityIsShelves()
			// +commoditypictureList.get(0).getCpURL());
		} else {
			map2.put("startIndex", (currentPage - 1) * pageSize);// ����ҳ
			map2.put("pageSize", pageSize * currentPage);// ÿҳ����
			map2.put("commodityisman", commodityisman);
			int low = Integer.parseInt(low1);
			int high = Integer.parseInt(high1);
			// System.out.println("else4:"+low+"high:"+high+":gategoriesName"+gategoriesName);
			map2.put("low", low);
			map2.put("high", high);
			map2.put("gategoriesName", gategoriesName);
			map2.put("gategoriesId", gategoriesId1);
			// System.out.println("�м۸�������-----liebiao4:"+(currentPage-1)*pageSize
			// +":"+pageSize+":"+pageSize*currentPage);
			// commodityList = t_commodityService.selectAllCommodity3(map2);
			// System.out.println("size:"+commodityList.size());
			commoditypictureList = t_commodityService.selectAllCommoditytest(map2);
			// System.out.println("dddddddddddddd:" +
			// commoditypictureList.get(0).getCommodityIsShelves()
			// +commoditypictureList.get(0).getCpURL());
		}
		// System.out.println("-----T_commodity"+commodityList.size());
		// System.out.println("commodityList�ǣ�-------------"+
		// commodityList.get(0).getCommodityId());
		// System.out.println("-----T_commoditypicture"+commoditypictureList.size());
		// System.out.println("commoditypictureList�ǣ�-------------"+
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
		// System.out.println("ɸѡ���ManGategoriesList:"+ManGategoriesList.size());

		// ���ò�ѯҳ��
		mv.addObject("commodityisman", commodityisman);
		mv.addObject("pageAll", pageAll);// ��ǰ�ǵڼ�ҳ
		mv.addObject("pageNumberX", currentPage);// ��ǰ�ǵڼ�ҳ
		mv.addObject("low", low1);// �۸�Χ����ǰ̨
		mv.addObject("high", high1);
		mv.addObject("gategoriesN", gategoriesName);
		mv.addObject("gategoriesI", gategoriesId1);
		// request.getSession().setAttribute("ManGategoriesList",
		// ManGategoriesLists);
		request.getSession().setAttribute("ManGategoriesList", ManGategoriesList);
		if (commodityisman.equals("��")) {
			System.out.println("��תmanǰ��");
			// request.getSession().setAttribute("commodityList",
			// commodityList);
			request.getSession().setAttribute("commoditypictureList", commoditypictureList);
			mv.setViewName("/shopCartClient/views/man.jsp");
		} else {
			System.out.println("��תwomanǰ��");
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
		request.getSession(true).setAttribute("pictureList", pictureList);// ǰ̨һ��Ҫ����jstl��ǩ��
		mv.setViewName("/shopCartClient/views/single.jsp");
		return mv;
	}

	@RequestMapping("/shopCartClient/views/toCommodityComment")
	public ModelAndView toCommodityComment(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String currentPage1 = request.getParameter("currentPage");// ��ǰҳ��
		String commodityId = request.getParameter("commodityId");
		// ����������й�ҳ������
		int pageSize = 10;// ûҳ������
		int GategCount = 0;// �ܲ�ѯ����
		int pageAll = 0;// һ����ҳ
		int currentPage = 0;// ǰ̨���������ǰҳ����int��
		currentPage = Integer.parseInt(currentPage1);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commodityId", commodityId);
		GategCount = t_commodityService.selectCommentCount(map);// ����������
		System.out.println("GategCount:" + GategCount);
		/** һ������ҳ */
		pageAll = (GategCount + pageSize - 1) / pageSize;// ����һ���м�ҳ
		System.out.println(pageAll + ":" + currentPage);
		// �жϲ�����һҳ������Χ
		if (currentPage < 1) {
			System.out.println("����С��");
			currentPage = 1;
		}
		if (currentPage > pageAll) {
			System.out.println("�������");
			currentPage = pageAll;
		}
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("commodityId", commodityId);
		map1.put("startIndex", (currentPage - 1) * pageSize);// ����ҳ
		map1.put("pageSize", pageSize * currentPage);// ÿҳ����
		List<T_commodityComment> commodityCommentList = t_commodityService.selectCommodityCommentById(map1);
		mv.addObject("commodityId", commodityId);
		mv.addObject("pageAll", pageAll);// ��ǰ�ǵڼ�ҳ
		mv.addObject("pageNumberX", currentPage);// ��ǰ�ǵڼ�ҳ
		request.getSession(true).setAttribute("commodityCommentList", commodityCommentList);// ǰ̨һ��Ҫ����jstl��ǩ��
		if(commodityCommentList.size() == 0){
			mv.addObject("commodityCommentListTip", "��ǰ��Ʒû������");// ��ǰ�ǵڼ�ҳ
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
		System.out.println("1ǰ̨��������� ����" + contactusSubject);
		if (null == userId1 || "" == userId1) {
			String userNameisNull = "���ȵ�¼";
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
				mv.addObject("contactusTip", "���Գɹ�");
				mv.setViewName("/shopCartClient/views/contactUs.jsp");
			} else {
				mv.addObject("contactusTip", "����ʧ��");
				mv.setViewName("/shopCartClient/views/contactUs.jsp");
			}
		}
		return mv;
	}
}

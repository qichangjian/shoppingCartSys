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

import cn.sxt.service.T_userService;
import cn.sxt.vo.T_user;


@Controller
public class T_userController {
	@Autowired
	private T_userService t_userService;
	
	public void setT_userService(T_userService t_userService) {
		this.t_userService = t_userService;
	}
	
	@RequestMapping("/list")
	public String list(ModelMap map) {
		System.out.println("list.do controller");
		map.addAttribute("list",t_userService.list());
		return "/list.jsp";//ת��
	}
	
	//·�ɷ�ʽ����
	@RequestMapping("/shopCartClient/views/doLogin")
	public ModelAndView doLogin(HttpServletRequest request,HttpServletResponse response,ModelMap map1) {
		System.out.println("����doLogin");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		System.out.println("T_controller��"+userName+",userPassword:"+userPassword);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", userName);
		map.put("userPassword", userPassword);
		List<T_user> tuserlist = t_userService.selectTuserByName(map);
		ModelAndView mv = new ModelAndView();
		System.out.println("size="+tuserlist.size()+"id"+ tuserlist.get(0));
		//���ò�ѯҳ�� 
		//map1.addAttribute("list",tuserService.list());
		request.getSession().setAttribute("tuserlist", tuserlist.get(0));
		System.out.println("��תǰ��");
		mv.setViewName("/shopCartClient/views/indexShop.jsp");
		return mv;
	}
	
	@RequestMapping("/shopCartClient/views/doRegistration")
	public ModelAndView doRegistration(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("����doRegistration");
		ModelAndView mv = new ModelAndView();
		String userNameFirst = request.getParameter("userNameFirst");
		String userNameLast = request.getParameter("userNameLast");
		String userName = userNameFirst + userNameLast;
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String ruserPassword = request.getParameter("ruserPassword");
		String userPhone = request.getParameter("userPhone");
		if(userPassword.equals(ruserPassword)) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userName", userName);
			map.put("userEmail", userEmail);
			map.put("userPassword", userPassword);
			map.put("userPhone",userPhone);
			System.out.println("���������ӡ��"+userName+",pwd:"+userPassword+",Email:"+userEmail+",phone:"+userPhone);
			int result = t_userService.registerTuser(map);
			if(result == 1) {
				System.out.println("����ɹ�");
				String registerSuccess = "����ɹ�";
				mv.addObject("registerSuccess",registerSuccess);
				mv.setViewName("/shopCartClient/views/registration.jsp");
			}else {
				String registerfail = "����ʧ��";
				mv.addObject("registerfail",registerfail);
				mv.setViewName("/shopCartClient/views/registration.jsp");
			}
			return mv;
		}else {
			String twoPasswordError = "�������벻һ�£�";
			mv.addObject("twoPasswordError",twoPasswordError);
			mv.setViewName("/shopCartClient/views/registration.jsp");
			return mv;
		}
	}
	
	@RequestMapping("/shopCartClient/views/toSinglejsp")
	public ModelAndView toSinglejsp(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String commodityId = request.getParameter("commodityId");
		String commodityPrice = request.getParameter("commodityPrice");
		String commodityName = request.getParameter("commodityName");
		String commodityURL = request.getParameter("commodityURL");
		mv.addObject("commodityId",commodityId);
		mv.addObject("commodityPrice",commodityPrice);
		mv.addObject("commodityName",commodityName);
		mv.addObject("commodityURL",commodityURL);
		mv.setViewName("/shopCartClient/views/single.jsp");
		return mv;
	}
	
}
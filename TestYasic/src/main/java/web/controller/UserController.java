package web.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import biz.service.UserService;
import biz.vo.CheckVO;
import biz.vo.FriendVO;
import biz.vo.MailVO;
import biz.vo.UserVO;
import web.validator.UserValidator;

@Controller 
public class UserController { 
	@Autowired
	UserService service;
	
	@RequestMapping("/index.do")
	public String indexProc(HttpServletRequest request) { 
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		request.setAttribute("myview", service.getView(user.getId()));
		request.setAttribute("users", service.getFriendViewList(user.getId()));
		return "index";
	}
	

	@RequestMapping(value = "/report.do", method = RequestMethod.GET)
	public String form() {
		return "reportForm";
	}
	
	//@RequestMapping(value = "/report.do", method = RequestMethod.POST)
	public void upload(MultipartFile file , 
			                 HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		String path = request.getRealPath("/upload/");
		System.out.println(path);
		if(!file.isEmpty()) {
			File f = new File(path+fileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("imgname", fileName);
		
	}
	
	
	@RequestMapping(value = "/add.do",method = RequestMethod.GET)
	public String addUser() {
		return "add";
	}
	 
	@RequestMapping(value = "/add.do",method = RequestMethod.POST)
	public String addUserProc(@ModelAttribute("user") UserVO vo ,
			@RequestParam("file") MultipartFile file,
			                  HttpServletRequest request,
			                  BindingResult errors) {
		new UserValidator().validate(vo, errors);
		int row = 0 ;
		if(errors.hasErrors()) {
			return "add";
		}

		vo.setImg(file.getOriginalFilename());
		System.out.println(vo);
		row = service.addUser(vo);
		
		System.out.println("회원가입 : "+row);
		upload(file, request);
		return "redirect:/index.do";
		
	}
	
	@RequestMapping("/mypage.do")
	public String toMypage(HttpServletRequest request) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		CheckVO check = service.getCheckContent(user.getId());
		request.setAttribute("user", user);
		request.setAttribute("check", check);
		return "mypage";
	}
	
	@RequestMapping("/yourpage.do")
	public String toYourpage(HttpServletRequest request,String id) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		
		CheckVO check = service.getCheckContent(id);
		request.setAttribute("user", user);
		request.setAttribute("check", check);
		return "yourpage";
	}
	
	@RequestMapping(value = "/checkbox.do",method = RequestMethod.GET)
	   public String addCheck() {
	      return "checkbox";
	   }
	   	
	@RequestMapping(value = "/checkbox.do",method = RequestMethod.POST)
	   public String addCheckProc(@ModelAttribute("checkbox") CheckVO vo , 
	                           HttpServletRequest request,
	                           BindingResult errors) {
	      //new UserValidator().validate(vo, errors);
	       int row = 0 ;
	      if(errors.hasErrors()) {
	         return "checkbox";
	      }
	      row = service.addCheckContent(vo);
	      return "redirect:/index.do";
	   }
	
	@RequestMapping("/mailbox.do")
	public ModelAndView toMailBox(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		mav.addObject("user", user);
		mav.setViewName("mailbox");
		return mav;
	}
	
	@RequestMapping("/search.do")
	public String doSearch(HttpServletRequest request, String condition) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		request.setAttribute("myview", service.getView(user.getId()));
		request.setAttribute("users", service.searchFriends(user.getId(), condition));
		return "index";
	}
	
	@RequestMapping("/fix.do")
	public String doFix(HttpServletRequest request) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		request.setAttribute("user", user);
		return "fix";
	}
	
	@RequestMapping(value = "/fadd.do", method = RequestMethod.GET)
	public String toAddFriendPage(HttpServletRequest request) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		request.setAttribute("user", user);
		return "fadd";
	}
	
	@RequestMapping(value = "/fadd.do", method = RequestMethod.POST)
	public String addFriend(HttpServletRequest request, String fid) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		
		System.out.println("add");
		
		MailVO mail = new MailVO();
		mail.setId(fid);
		mail.setFid(user.getId());
		mail.setWhy("f");
		service.sendMail(mail);
		/*transaction 필요*/
//		String id = user.getId();
//		service.addFriend(id, fid);
//		service.addFriend(fid, id);
		/*===============*/
		System.out.println("end");
		
		request.setAttribute("user", user);
		request.setAttribute("msg", "친구추가가 완료 되었습니다.");
		return "fadd";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/remove.do")
	public String remove(HttpServletRequest request) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		service.removeUser(user.getId());
		return "redirect:/index.do";
	}
	
	@RequestMapping("/user/modify.do")
	public ModelAndView modify(@RequestParam("userid") String id) {
		ModelAndView mav = new ModelAndView();
        mav.addObject("user", service.getUser(id));
		mav.setViewName("user/user_modify");
		return mav;
	}
	
	@RequestMapping("/user/update.do")
	//public ModelAndView update(@ModelAttribute("user") UserVO vo) {
	public ModelAndView update(UserVO vo) {
		System.out.println(vo);
		ModelAndView mav = new ModelAndView();
		service.updateUser(vo);
		
		mav.addObject("user",service.getUser(vo.getId()));
		mav.setViewName("user/user_view");
		return mav;
	}
	
	/*
	 * @RequestMapping("/user/search.do") public ModelAndView search(String
	 * searchCondition, String searchKeyword) { ModelAndView mav = new
	 * ModelAndView(); mav.addObject("users", service.search(searchCondition,
	 * searchKeyword)); mav.setViewName("user/user_list"); return mav; }
	 */
	
	
	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		model.addAttribute("exception", exception);
		return "error";
	}
	
	
}

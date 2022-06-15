package com.springlec.base0802;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springlec.base0802.command.BCommand;
import com.springlec.base0802.command.BListCommand;
import com.springlec.base0802.dao.IDao;

import jdk.internal.module.IllegalAccessLogger.Mode;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// servlet-context.xml에서 정의한 SqlSession 이용
	@Autowired
	private SqlSession SqlSession;
	
	BCommand command = null;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//리스트 페이지로 이동
	@RequestMapping("/list")
	public String list(Model model) {
//		// BListCommand 없이 하기
//		IDao dao = SqlSession.getMapper(IDao.class);
//		model.addAttribute("list", dao.listDao());
		
		
		// BListCommand 사용
		command = new BListCommand();
		command.execute(SqlSession, model);		
		
		return "list";
	}
	
	//글작성 페이지로 이동
	@RequestMapping("/write_view")
	public String write_view() {
		return "write_view"; // jsp 이동
	}
		
	//글작성
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		// request로 받아 model로 전달
		IDao dao = SqlSession.getMapper(IDao.class);
		dao.writeDao(request.getParameter("name"), request.getParameter("tel"), 
				request.getParameter("address"), request.getParameter("email"), request.getParameter("relation")); // jsp로 값을 전송
		return "redirect:list"; // 메소드 내용 처리 후 list로 이동
	}
	
	//글내용보기 및 수정 페이지로 이동
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		IDao dao = SqlSession.getMapper(IDao.class);
		model.addAttribute("ContentDto", dao.contentViewDao(Integer.parseInt(request.getParameter("seq")))); // jsp로 값을 전송
//		dao.contentViewDao(request.getParameter("seq"));
		
		return "content_view"; // jsp 이동
	}
	
	//글수정 버튼 눌렀을 시
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		IDao dao = SqlSession.getMapper(IDao.class);
		model.addAttribute("ContentDto", dao.editDao(Integer.parseInt(request.getParameter("seq")), request.getParameter("name"), 
				request.getParameter("tel"), request.getParameter("address"), request.getParameter("email"), request.getParameter("relation")));
		
	return "redirect:list"; // 메소드 내용 처리 후 list로 이동 
	}
	
	
	// 글삭제 버튼 눌렀을 시
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		// request로 받아 model로 전달
		IDao dao = SqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("seq"));
		return "redirect:list"; // 메소드 내용 처리 후 list로 이동
	}
	
	
	
	// 검색
	@RequestMapping("/listQuery")
	public String listQuery(HttpServletRequest request, Model model) {
		IDao dao = SqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listQuery(request.getParameter("query"), request.getParameter("content")));
		return "/list";
	}
	
	
}

package com.springlec.base0801;

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

import com.springlec.base0801.dao.IDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// servlet-context.xml에서 정의한 SqlSession 이용
	@Autowired
	private SqlSession SqlSession;
	
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
		IDao dao = SqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
		
		return "list";
	}
	
	
	// 글작성 페이지로 이동
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm"; // jsp 이동
	}
	
	
	// 글작성 버튼 눌렀을 시
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		// request로 받아 model로 전달
		IDao dao = SqlSession.getMapper(IDao.class);
		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		return "redirect:list"; // 메소드 내용 처리 후 list로 이동
	}
	
	// 글삭제 버튼 눌렀을 시
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		// request로 받아 model로 전달
		IDao dao = SqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("mId"));
		return "redirect:list"; // 메소드 내용 처리 후 list로 이동
	}
	
}

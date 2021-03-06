package com.springlec.base0301;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
	
	//verson 4방식----------------------------
	@RequestMapping("board/view")
	public String view() { // return 값은 String
		return "board/view"; // board 폴더 내의 view.jsp
		// switch case문으로 나눴던 것을 메소드로 분리 시킴
	}
	
	@RequestMapping("board/view2")
	public String view2() {
		return "board/view2"; // board 폴더 내의 view.jsp
		// switch case문으로 나눴던 것을 메소드로 분리 시킴
	}
	
	@RequestMapping("board/content")
	public String content(Model model) {
		model.addAttribute("id", 30); // jsp로 값을 전달
		return "board/content"; // board 폴더 내의 content.jsp
	}
	
	
	//verson 3방식--------------------------
	@RequestMapping("board/reply")
	public ModelAndView reply() { // 자료형이 ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", 30); // jsp로 값을 전달
		modelAndView.setViewName("board/reply");
		return modelAndView;
	}
	
}

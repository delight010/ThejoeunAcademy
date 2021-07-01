package com.springlec.s0302;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//개인 컨트롤러 만들기
@Controller
@RequestMapping("test")
public class myController {

	@RequestMapping("/view1")
	public String view1() {
		return "test/view1";
	}
}

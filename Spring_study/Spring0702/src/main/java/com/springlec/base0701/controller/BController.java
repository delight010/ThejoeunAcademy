package com.springlec.base0701.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0701.command.BCommand;
import com.springlec.base0701.command.BContentViewCommand;
import com.springlec.base0701.command.BDeleteCommand;
import com.springlec.base0701.command.BListCommand;
import com.springlec.base0701.command.BUpdateCommand;
import com.springlec.base0701.command.BWriteCommand;
import com.springlec.base0701.utill.Constant;

@Controller
public class BController {

	BCommand command = null;
	
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", httpServletRequest);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", httpServletRequest);
		command = new BContentViewCommand();
		command.execute(model);
		
		return "content_view";
	}
	@RequestMapping("/delete")
	public String content(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", httpServletRequest);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("/update_view")
	public String update_view(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("update_view()");
		
		model.addAttribute("request", httpServletRequest);
		command = new BContentViewCommand();
		command.execute(model);
		
		return "update_view";
	}
	@RequestMapping("/update")
	public String update(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("update()");
		
		model.addAttribute("request", httpServletRequest);
		command = new BUpdateCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}

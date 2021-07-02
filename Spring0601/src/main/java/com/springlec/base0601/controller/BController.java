package com.springlec.base0601.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0601.command.BCommand;
import com.springlec.base0601.command.BContentCommand;
import com.springlec.base0601.command.BDeleteCommand;
import com.springlec.base0601.command.BEditCommand;
import com.springlec.base0601.command.BListCommand;
import com.springlec.base0601.command.BWriteCommand;

//------------------------------------------

@Controller
public class BController {
	
	BCommand command = null;
	
	//리스트 페이지 보기
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	//게시글 작성
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	
	//게시글 보기
		@RequestMapping("/content_view")
		public String content_view(HttpServletRequest request, Model model) {
			model.addAttribute("request",request); // get& post 방식
			command = new BContentCommand();	
			command.execute(model);
			System.out.println("content_view()");
			
			return "content_view";
		}
	
	
	//글 작성
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request); // BDao의 request를 받아옴.
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	
	//글 수정
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		System.out.println("edit()");
		
		model.addAttribute("request", request); // BDao의 request를 받아옴.
		command = new BEditCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	
	//글 삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request); // BDao의 request를 받아옴.
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}

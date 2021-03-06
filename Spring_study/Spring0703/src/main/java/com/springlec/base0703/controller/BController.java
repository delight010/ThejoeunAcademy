package com.springlec.base0703.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0703.command.BCommand;
import com.springlec.base0703.command.BListCommand;

@Controller
public class BController {
	
	//-----------------------------------------------
	// 생성자를 안쓰기 위함
	//-----------------------------------------------
	
	BCommand command = null;
	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand contentCommand = null;
	private BCommand editCommand = null;
	private BCommand deleteCommand = null;
	
	
	// 자동연결, servlet-context.xml에 있는 Bean에서 가져다 씀
	@Autowired
	public void auto(BCommand list, BCommand write, BCommand context, BCommand edit, BCommand delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.contentCommand = context;
		this.editCommand = edit;
		this.deleteCommand = delete;
	}
	
	//----------------------------------------------
	
	
	// 리스트 페이지 보기
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		return "list"; // list.jsp로 이동
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
		contentCommand.execute(model);
		System.out.println("content_view()");
		
		return "content_view"; // jsp로 이동
	}
	
	
	//글 작성
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request); // BDao의 request를 받아옴.
		writeCommand.execute(model);
		
		return "redirect:list"; // jsp로 이동
	}
	
	
	//글 수정
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		System.out.println("edit()");
		
		model.addAttribute("request", request); // BDao의 request를 받아옴.
		editCommand.execute(model);
		
		return "redirect:list"; // jsp로 이동
	}
	
	
	//글 삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
	
		model.addAttribute("request", request); // BDao의 request를 받아옴.
		deleteCommand.execute(model);
		
	return "redirect:list"; // jsp로 이동
	}
		
}

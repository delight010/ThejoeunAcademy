package com.springlec.base0602.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0602.command.BCommand;
import com.springlec.base0602.command.BContentCommand;
import com.springlec.base0602.command.BDeleteCommand;
import com.springlec.base0602.command.BEditCommand;
import com.springlec.base0602.command.BListCommand;
import com.springlec.base0602.command.BWriteCommand;

//------------------------------------------

@Controller
public class BController {
	
	//--------------------------------------------
	// 생성자를 안쓰기 위함
	//--------------------------------------------
	
	BCommand command = null;
	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand contentCommand = null;
	private BCommand editCommand = null;
	private BCommand deleteCommand = null;
	
	// 자동연결, servlet-context.xml에 있는 Bean에서 가져다 씀
	@Autowired
	public void auto(BCommand list, BCommand write, BCommand content, BCommand edit, BCommand delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.contentCommand = content;
		this.editCommand = edit;
		this.deleteCommand = delete;
	}
	
	//--------------------------------------------
	
	//리스트 페이지 보기
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		listCommand.execute(model);
//		command = new BListCommand();
//		command.execute(model);
		
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
			contentCommand.execute(model);
//			command = new BContentCommand();	
//			command.execute(model);
			System.out.println("content_view()");
			
			return "content_view";
		}
	
	
	//글 작성
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request); // BDao의 request를 받아옴.
		writeCommand.execute(model);
//		command = new BWriteCommand();
//		command.execute(model);
		
		return "redirect:list";
	}
	
	
	//글 수정
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		System.out.println("edit()");
		
		model.addAttribute("request", request); // BDao의 request를 받아옴.
		editCommand.execute(model);
//		command = new BEditCommand();
//		command.execute(model);
		
		return "redirect:list";
	}
	
	
	//글 삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request); // BDao의 request를 받아옴.
		deleteCommand.execute(model);
//		command = new BDeleteCommand();
//		command.execute(model);
		
		return "redirect:list";
	}
	
}

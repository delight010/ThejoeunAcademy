package com.springlec.base0602.command;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0602.dao.BDao;
import com.springlec.base0602.dto.BDto;

public class BListCommand implements BCommand {
	
	//--------------------------------------------
	// 생성자를 안쓰기 위함
	//--------------------------------------------
	
	private BDao dao = null;
	
	@Autowired
	public void setDao(BDao dao) {
		this.dao = dao;
	}
	
	//--------------------------------------------

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
//		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}

}

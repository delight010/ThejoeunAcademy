package com.springlec.base0703.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0703.dao.BDao;

public class BEditCommand implements BCommand {
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
		
		Map<String, Object> map = model.asMap(); 
		// 숫자 혹은 문자가 올 수 있기 때문에 Object
		// model -> asMap으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
	
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		dao.edit(bId, bName, bTitle, bContent); // BDao로 전송

	}

}

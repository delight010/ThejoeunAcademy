package com.springlec.base0602.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0602.dao.BDao;
import com.springlec.base0602.dto.BDto;

public class BContentCommand implements BCommand {

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
		
		String bId = request.getParameter("bId");
	
/**		BDao dao = new BDao(); // sql 연결 **/
		BDto dto = dao.contentView(bId); 
		
		model.addAttribute("content_view", dto);

	}

}

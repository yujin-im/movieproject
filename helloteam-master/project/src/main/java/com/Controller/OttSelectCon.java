package com.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.OttDAO;
import com.MainController.Command;
import com.VO.OttDTO;



public class OttSelectCon implements Command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("OttSelectCon");

		String video_type = request.getParameter("video_type");
		String video_ott = request.getParameter("video_ott");

		//video_type과 video_ott에 저장된 변수 값 리턴

		OttDAO dao = new OttDAO();
		// OttDAO를 호출하여 입력한 값을 Ott테이블에 저장

		ArrayList<OttDTO> list = new ArrayList<OttDTO>();
		OttDTO vo = new OttDTO(video_type, video_ott);

		list = dao.select(vo);
	
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		
	
		// OttDTO를 리스트로 

		

		
		return "../OTT/movieMain.jsp";

	}
	
}

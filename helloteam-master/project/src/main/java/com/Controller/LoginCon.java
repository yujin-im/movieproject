package com.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BoardDAO;
import com.DAO.MemberDAO;
import com.MainController.Command;
import com.VO.BoardVO;
import com.VO.MemberDTO;
import com.VO.OttDTO;

public class LoginCon implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDTO vo = new MemberDTO(id,pw);     //vo 안에 id,pw
		
		MemberDAO dao = new MemberDAO();
		MemberDTO info = dao.login(vo);		//vo가 있다면 info에 멤버 전체값 받아옴
		String gen = dao.gen(vo.getMb_id());  //gen 에 선호장르 값 가져오기
		


		
		if(info!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("vo",info);
			session.setAttribute("gen", gen);
			
			return "../../../OTT/index.jsp"; 
		
			}else {
			System.out.println("로그인 실패");
			return "login.jsp";
			}
			
	
	}

}

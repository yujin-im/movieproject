package com.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BoardDAO;
import com.MainController.Command;
import com.VO.BoardVO;
import com.VO.MemberDTO;


public class BoardUpdateCon implements Command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response)  {
		
		
		String title = request.getParameter("Utitle");
		String content = request.getParameter("Ucontent");
		int seq = Integer.parseInt(request.getParameter("id")) ;
		System.out.println(title);
		System.out.println(content);
		System.out.println(seq);
		BoardDAO dao = new BoardDAO();
		int cnt = dao.Update(title, content, seq);
	
	     
		
		//게시판 다시 불러오기
		ArrayList<BoardVO> Bod = new ArrayList<BoardVO>();
		Bod = dao.select();
		HttpSession session = request.getSession();
		if(cnt>0) {
			session.setAttribute("Bod", Bod);
		
		
			
			
			
			System.out.println("글 수정성공");
		} else {
			System.out.println("수정실패");
		}
		
		return "board.jsp";

	}

}

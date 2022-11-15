package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BoardDAO;
import com.MainController.Command;
import com.VO.BoardVO;
import com.VO.MemberDTO;


public class BoardWriteCon implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response)  {

		String title = request.getParameter("Wtitle");
		String content = request.getParameter("Wcontent");
		HttpSession session = request.getSession();
		MemberDTO vo = (MemberDTO)session.getAttribute("vo");
		String id = vo.getMb_id();
		
		BoardVO vo1 = new BoardVO(title, content,id);
		
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.write(vo1);
		if(cnt >0) {
			// 글쓰기 후 게시판 다시 불러오기
			ArrayList<BoardVO> Bod = new ArrayList<BoardVO>();
			BoardDAO Bd = new BoardDAO();
			Bod = Bd.select();
			System.out.println("글쓰기 성공");
			session.setAttribute("Bod", Bod);
		}else {
			System.out.println("글쓰기 실패");
		}
		
		return "board.jsp" ;
	}
	
}

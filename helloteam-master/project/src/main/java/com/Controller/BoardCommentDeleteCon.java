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


public class BoardCommentDeleteCon implements Command{

	public String execute(HttpServletRequest request, HttpServletResponse response)  {
	
		

	
	int commentid = Integer.parseInt(request.getParameter("commentID"));

	BoardDAO dao = new BoardDAO();
	int cnt = dao.commentDel(commentid);

	if (cnt > 0) {
		ArrayList<BoardVO> Bod = new ArrayList<BoardVO>();
		Bod = dao.select();
		HttpSession session = request.getSession();
		session.setAttribute("Bod", Bod);
		System.out.println("글 삭제 성공");
	} else {
		System.out.println("글 삭제 실패");
	}
		
		
	return "View.jsp";	
	}
	

}

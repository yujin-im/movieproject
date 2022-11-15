package com.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BoardDAO;
import com.MainController.Command;
import com.VO.BoardVO;

public class BoardDeleteCon implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		int seq = Integer.parseInt(request.getParameter("id"));

		BoardDAO dao = new BoardDAO();
		int cnt = dao.delete(seq);

		if (cnt > 0) {
			ArrayList<BoardVO> Bod = new ArrayList<BoardVO>();
			Bod = dao.select();
			HttpSession session = request.getSession();
			session.setAttribute("Bod", Bod);
			System.out.println("글 삭제 성공");
		} else {
			System.out.println("글 삭제 실패");
		}
		return "board.jsp";
	}

}

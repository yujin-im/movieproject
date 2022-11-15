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
import com.VO.CommentVO;


public class BoardCommentCon implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

	// 댓글 작성하고 다시 불러오는 영역
		
		BoardDAO dao = new BoardDAO();
		String article = request.getParameter("article_seq");
		ArrayList<BoardVO> vo = dao.view(article);

		int article_seq =Integer.parseInt(request.getParameter("article_seq")); //글번호,내용,아이디 불러오기
		String comment_content = request.getParameter("commentText");
		String mb_id = request.getParameter("userID");

		int cnt = dao.Commentwrite(article_seq,comment_content, mb_id);
		
		if(vo!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("title1",vo.get(0).getArticle_title());
			session.setAttribute("name1",vo.get(0).getMb_id());
			session.setAttribute("date1",vo.get(0).getArticle_date());
			session.setAttribute("content1",vo.get(0).getArticle_content());
			session.setAttribute("seq1", vo.get(0).getArticle_seq());
			
			System.out.println("글 불러오기 성공");
			System.out.println("댓글 업데이트 성공");
			
			
			
			}else {
			System.out.println("글 불러오기 실패");
			}
		return "View.jsp";
	}

}

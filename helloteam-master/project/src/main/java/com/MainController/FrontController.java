package com.MainController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Controller.BoardCommentCon;
import com.Controller.BoardCommentDeleteCon;
import com.Controller.BoardCon;
import com.Controller.BoardDeleteCon;
import com.Controller.BoardUpdateCon;
import com.Controller.BoardWriteCon;
import com.Controller.JoinCon;
import com.Controller.LoginCon;
import com.Controller.LogoutCon;
import com.Controller.OttDetailCon;
import com.Controller.OttSelectCon;
import com.Controller.UpdateCon;


@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		System.out.println("front controller Run");

		// Client가 요청한 URI주소 가져와서 Con값만 자르기
		String requestURI = request.getRequestURI();
		String[] url = request.getRequestURI().split("/");
		String fileName = url[url.length-1];
	
	
		System.out.println("url >>" + fileName);
		request.setCharacterEncoding("utf-8");
	
		
		
		Command command = null;

		if (fileName.equals("LoginCon.do")) {
			System.out.println("로그인 요청");

			command = new LoginCon();

		} else if (fileName.equals("JoinCon.do")) {
			System.out.println("회원가입 요청");

			command = new JoinCon();

		} else if (fileName.equals("UpdateCon.do")) {
			System.out.println("회원정보수정 요청");

			command = new UpdateCon();// UpdateCon으로

		} else if (fileName.equals("LogoutCon.do")) {
			System.out.println("로그아웃 요청");
			//System.out.println(fileName);
			command = new LogoutCon();// LogoutCon으로

		} else if (fileName.equals("OttSelectCon.do")) {
			System.out.println("상영예정 요청");
			command = new OttSelectCon();
			
		} else if (fileName.equals("OttSelectCon.do")) {
			System.out.println("종료예정 요청");
			command = new OttSelectCon();
		} else if (fileName.equals("OttDetailCon.do")) {
			System.out.println("디테일");
			command = new OttDetailCon();
		}else if (fileName.equals("BoardCon.do")) {
			System.out.println("게시판 상세페이지");
			command = new BoardCon();
		}else if (fileName.equals("BoardWriteCon.do")) {
			System.out.println("게시판 글쓰기");
			command = new BoardWriteCon();
		}else if (fileName.equals("BoardUpdateCon.do")) {
			System.out.println("게시판 글 수정하기");
			command = new BoardUpdateCon();
		}else if (fileName.equals("BoardDeleteCon.do")) {
			System.out.println("게시글 삭제하기");
			command = new BoardDeleteCon();
		}else if (fileName.equals("BoardCommentCon.do")) {
			System.out.println("댓글 작성하기");
			command = new BoardCommentCon();
		}else if (fileName.equals("BoardCommentDeleteCon.do")) {
			System.out.println("댓글 삭제하기");
			command = new BoardCommentDeleteCon();
		}
		// selectMember.jsp
				String moveUrl = command.execute(request, response);
				
				if(moveUrl.equals("selectMember.jsp")) {
					RequestDispatcher rd = request.getRequestDispatcher("selectMember.jsp");
					rd.forward(request, response);
				}else {
					response.sendRedirect(moveUrl);
				}
				

		
		
	}

}

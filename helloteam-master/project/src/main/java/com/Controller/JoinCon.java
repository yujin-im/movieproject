package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MemberDAO;
import com.MainController.Command;
import com.VO.MemberDTO;

public class JoinCon implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birthdate = request.getParameter("birthdate");
		String gender = request.getParameter("gender");

		// 장르 가져와서 문자열 join
		String[] genr = null;

		String genre = null;
		MemberDTO vo = new MemberDTO(id, pw, name, birthdate, gender);

		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(vo);
		
		if (request.getParameterValues("genere") != null) {
			genr = request.getParameterValues("genere");
			genre = String.join(",", genr);

			
		}
		dao.joinGen(id, genre);    // 회원 장르 테이블 입력

		if (cnt > 0) {

			System.out.println("회원가입 성공");

			// System.out.println(genre);
			return "../../../OTT/index.jsp";
		} else {
			System.out.println("입력실패");
			return "register.jsp";
		}

	}

}

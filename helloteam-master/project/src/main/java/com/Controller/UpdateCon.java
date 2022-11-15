package com.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MemberDAO;
import com.MainController.Command;
import com.VO.MemberDTO;


public class UpdateCon implements Command{
	
	public String execute(HttpServletRequest request, HttpServletResponse response)  {
	
		HttpSession session = request.getSession();
		MemberDTO vo = (MemberDTO)session.getAttribute("vo");
		
		String id = vo.getMb_id();
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		
		
		MemberDTO vo2 = new MemberDTO(id,pw,name);
		MemberDAO dao = new MemberDAO();
		
		System.out.println("장르값 미선택시 null값 입력");
		String[] genere = null;
		String gener = null;
		if(request.getParameterValues("genere")!=null) {
			genere = request.getParameterValues("genere");
			gener = String.join(",", genere);
		}
		

		//session.getAttribute("gen");
		//session.removeAttribute("gen");	

		int cnt = dao.Update(vo2);	//회원 정보 수정
		int cntt = dao.upgen(gener,id);       // 넣는 순서 잘 생각하기 장르수정
		if(cnt>0 & cntt>0) {
		
			session.setAttribute("vo",vo2 );
			session.setAttribute("gen", gener);
			
		
			System.out.println("성공");
		} else {
			System.out.println("수정실패");
		}
		
		return "../../../OTT/index.jsp";
		
	}	
		
	}



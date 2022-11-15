package com.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MainController.Command;
import com.VO.OttDTO;


public class LogoutCon implements Command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		//session.getAttribute("vo");
			
		session.removeAttribute("vo");
		return "../OTT/index.jsp";
		

		
	}

}

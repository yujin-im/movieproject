package com.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.OttDAO;
import com.MainController.Command;
import com.VO.OttDTO;


public class OttDetailCon implements Command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response)  {
		String id = request.getParameter("id");
		String video_type = request.getParameter("video_type");
		String video_ott = request.getParameter("video_ott");
		System.out.println("ott Detail : " + id);
		System.out.println("ott video_type : " + video_type);
		System.out.println("ott Detail : " + video_ott);
		
		ArrayList<OttDTO> list = new ArrayList<OttDTO>();
		OttDTO vo = new OttDTO(video_type, video_ott);
		OttDAO dao = new OttDAO();
		list = dao.detailSelect(vo,id);
		System.out.println(id);
		
		System.out.println(list.get(0).getVideo_title());
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		
		
		return "startmovie.jsp";
		
		
		
	}

}

package by.htp.eduard.mvc.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class IndexCommand {
	
	public String showIndexPage(HttpServletRequest request) {
		HttpSession session = request.getSession();	
		Object successRegistr = session.getAttribute("successRegistr");
		session.removeAttribute("successRegistr");
		
		request.setAttribute("successRegistr", successRegistr);
		
		return "/WEB-INF/pages/index2.jsp";
//		return "/WEB-INF/pages/index.jsp";
	}

}

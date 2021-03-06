package by.htp.eduard.mvc.commands;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.eduard.entities.Authentication;
import by.htp.eduard.entities.User;
import by.htp.eduard.service.AuthenticationService;
import by.htp.eduard.service.ServiceProvider;
import by.htp.eduard.service.UserService;
import by.htp.eduard.utils.HttpUtils;

public class AuthenticationCommands {
	
	private final AuthenticationService authenticationService;
	private final UserService userService;

	public AuthenticationCommands() {
		authenticationService = ServiceProvider.getInstance().getAuthenticationService();
		userService = ServiceProvider.getInstance().getUserService();
	}
	
	public String authorization(HttpServletRequest request) {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Authentication authentication = new Authentication();
		authentication.setLogin(login);
		authentication.setPassword(password);
		
		User user = authenticationService.signIn(authentication);
		if(user==null) {
			ServletContext context = request.getServletContext();
			String contextPath = context.getContextPath();
			return "redirect:" + contextPath;
		}
		request.setAttribute("user", user);
		
		return "/WEB-INF/pages/users/user-edit.jsp";
	}
	
	public String registrationNewUser(HttpServletRequest request) {
		return "/WEB-INF/pages/users/registration-new-user.jsp";
	}
	
	public String saveNewUser(HttpServletRequest request) {
		HttpSession session = request.getSession();	
		if(!request.getParameter("password").equals(request.getParameter("password2"))) {
			String response = "Password1 And Password2 Don't Match!";
			session.setAttribute("response", response);
			return "redirect:registration";
		}
		
		Integer id = HttpUtils.getIntParam("id", request);
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		Integer roleId = HttpUtils.getIntParam("roleId", request);
		String passportSeries = request.getParameter("passportSeries");
		String passportId = request.getParameter("passportId");
		String codeWord = request.getParameter("codeWord");
		String phoneNumber = request.getParameter("phoneNumber");
		String residenceRegistr = request.getParameter("residenceRegistr");
		
		User user = new User();
		user.setId(id);
		user.setLogin(login);
		user.setPassword(password);
		user.setName(name);
		user.setSurname(surname);
		user.setAddress(address);
		user.setRoleId(roleId);
		user.setPassportSeries(passportSeries);
		user.setPassportId(passportId);
		user.setCodeWord(codeWord);
		user.setPhoneNumber(phoneNumber);
		user.setResidenceRegistr(residenceRegistr);
		
		userService.saveUser(user);
		
		String response = "Registration Was Successful";
		session.setAttribute("successRegistr", response);
		ServletContext context = request.getServletContext();
		String contextPath = context.getContextPath();
		return "redirect:" + contextPath;
		
//		String response = "Registration Was Successful!";
//		request.setAttribute("response", response);
//		return "/WEB-INF/pages/index2.jsp";
	}
	
	public String forgetPassword(HttpServletRequest request) {
		return "/WEB-INF/pages/authentication/forget-password.jsp";
	}

	public String getForgetPassword(HttpServletRequest request) {
		String passportSeries = request.getParameter("passportSeries");
		String passportId = request.getParameter("passportId");
		String codeWord = request.getParameter("codeWord");
		
		Authentication authentication = new Authentication();
		authentication.setPassportSeries(passportSeries);
		authentication.setPassportId(passportId);
		authentication.setCodeWord(codeWord);
		
		User user = authenticationService.forgetPassword(authentication);
		
//		String response = "Your login = '" + user.getLogin() + "', your password = '" + user.getPassword() + "'";
		request.setAttribute("user", user);
//		return "redirect:forget-password";
		return "/WEB-INF/pages/authentication/forget-password.jsp";
	}
	
}

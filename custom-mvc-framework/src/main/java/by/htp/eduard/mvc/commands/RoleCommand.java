package by.htp.eduard.mvc.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.eduard.dto.RoleDto;
import by.htp.eduard.service.RoleService;
import by.htp.eduard.service.ServiceProvider;
import by.htp.eduard.utils.HttpUtils;

public class RoleCommand {
	
	private final RoleService roleService;

	public RoleCommand() {
		roleService = ServiceProvider.getInstance().getRoleService();
	}
	
	public String showAllRoles(HttpServletRequest request) {
		List<RoleDto> allRoles = roleService.getAllRoles();
		request.setAttribute("allRoles", allRoles);
		
		return "/WEB-INF/pages/roles/roles-list.jsp";
	}
	
	public String addRole(HttpServletRequest request) {		
		return "/WEB-INF/pages/roles/role-details.jsp";
	}
	
	public String saveRole(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("id", request);
		String name = request.getParameter("newRole");
		
		RoleDto role = new RoleDto();
		role.setId(id);
		role.setRoleName(name);
		
		roleService.saveRole(role);
		
		return "redirect:roles-list";
	}

	public String editRole(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("roleId", request);
		RoleDto role = roleService.getNameRoleById(id);
		request.setAttribute("role", role);
		return "/WEB-INF/pages/roles/role-details.jsp";
	}
	
	public String deleteRole(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("roleId", request);
		roleService.deleteRole(id);
		return "redirect:roles-list";
	}
}

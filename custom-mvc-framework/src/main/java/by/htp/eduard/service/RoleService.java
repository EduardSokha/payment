package by.htp.eduard.service;

import java.util.List;

import by.htp.eduard.dto.RoleDto;
import by.htp.eduard.entities.Role;

public interface RoleService {

	List<Role> getAllRoles();
	RoleDto getNameRoleById(Integer id);
	Role saveRole(Role role);
	void deleteRole(Integer id);

}

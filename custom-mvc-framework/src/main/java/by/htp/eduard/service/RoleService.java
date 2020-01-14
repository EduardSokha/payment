package by.htp.eduard.service;

import java.util.List;

import by.htp.eduard.dto.RoleDto;

public interface RoleService {

	List<RoleDto> getAllRoles();
	RoleDto getNameRoleById(Integer id);
	RoleDto saveRole(RoleDto roleDto);
	void deleteRole(Integer id);

}

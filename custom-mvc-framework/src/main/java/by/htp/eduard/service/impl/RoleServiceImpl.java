package by.htp.eduard.service.impl;

import java.util.List;

import by.htp.eduard.dao.RoleDao;
import by.htp.eduard.dao.mysql.provider.DaoProvider;
import by.htp.eduard.dto.RoleDto;
import by.htp.eduard.entities.Role;
import by.htp.eduard.service.EntityDtoConverter;
import by.htp.eduard.service.RoleService;
import by.htp.eduard.service.ServiceProvider;

public class RoleServiceImpl implements RoleService{
	
	private final RoleDao roleDao;
	
	private EntityDtoConverter converter;

	public RoleServiceImpl() {
		roleDao = DaoProvider.getInstance().getRoleDao();
		converter = ServiceProvider.getInstance().getEntityDtoConverter();
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

	@Override
	public RoleDto getNameRoleById(Integer id) {
		Role roleEntity = roleDao.getNameRoleById(id);
		RoleDto roleDto = converter.convertToDto(roleEntity, RoleDto.class);
		return roleDto;
	}

	@Override
	public Role saveRole(Role role) {
		if(role.getId() == null) {
			return roleDao.saveRole(role);
		}
		
		return roleDao.updateNameRole(role);
	}

	@Override
	public void deleteRole(Integer id) {
		roleDao.deleteRole(id);
	}
}

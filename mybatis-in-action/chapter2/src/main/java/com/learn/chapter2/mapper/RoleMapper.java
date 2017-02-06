package com.learn.chapter2.mapper;

import org.apache.ibatis.annotations.Select;

import com.learn.chapter2.po.Role;

public interface RoleMapper {

	public int insertRole(Role role);

	public Role getRole(Long id);

	public int deleteRole(Long id);

	@Select(value = "select id, role_name as roleName, note from t_role where id = #{id}")
	public Role getRole2(Long id);
}

package com.zr.mapper;

import com.zr.pojo.Role;

import java.util.List;

public interface RoleMapper {
    public int insertRole(Role role);
    public int deleteRole(Long id);
    public int updateRole(Role role);
    public Role getRole(int id);
    public List<Role> findRoles(String roleName);

}

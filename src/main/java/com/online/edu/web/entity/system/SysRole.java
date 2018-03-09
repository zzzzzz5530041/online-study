package com.online.edu.web.entity.system;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 * author
 */
public class SysRole implements Serializable{
	
	private int roleId;
	private String roleName;
	private Date createTime;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

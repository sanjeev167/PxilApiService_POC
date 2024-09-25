/**
 * 
 */
package com.pxil.sec.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pxil.sec.entities.ApiGroupRole;
import com.pxil.sec.entities.ApiUser;
import com.pxil.sec.entities.ApiUserGroup;

/**
 * @author sanjeevkumar 
 * 03-Dec-2023 
 * 8:06:22 pm 
 * Objective: UserInfoDetails contains all the details that a spring based security object i.e. UserDetails holds. So, here we are preparing those stuffs as 
 * per our implementation. We need to keep username and password at username and password variables only. In addition to this, all the roles assigned to this 
 * user need to be stuffed into List<GrantedAuthority> authorities so that spring could use while authentication and authorization. 
 */
public class UserInfoDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;	
	public String userContext;	
	public String gridNodeCode;
	
	private List<GrantedAuthority> authorities;

	public UserInfoDetails(ApiUser apiUser) {

		username = apiUser.getName();
		password = apiUser.getPwd();
		userContext=apiUser.getUserContext();
		gridNodeCode=apiUser.getGridNodeCode();
		
		List<ApiUserGroup> apiUserGroupList = apiUser.getListOfApiUserGroup();
		
		List<ApiGroupRole> apiGroupRoleList = null;
		String roleName;
		String allAssignedGroupRoles = null;
		for (ApiUserGroup apiUserGroup : apiUserGroupList) {			
			apiGroupRoleList = apiUserGroup.getApiGroup().getListOfApiGroupRole();			
			for (ApiGroupRole apiGroupRole : apiGroupRoleList) {				
				roleName = apiGroupRole.getApiRole().getRoleName();				
				if (allAssignedGroupRoles == null)
					allAssignedGroupRoles = roleName;
				else
					allAssignedGroupRoles = allAssignedGroupRoles + "," + roleName;
			}
		}		
		authorities = Arrays.stream(allAssignedGroupRoles.split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	

	/**
	 * @return the userContext
	 */
	public String getUserContext() {
		return userContext;
	}

	/**
	 * @param userContext the userContext to set
	 */
	public void setUserContext(String userContext) {
		this.userContext = userContext;
	}
	
	
	
	

	/**
	 * @return the gridNodeCode
	 */
	public String getGridNodeCode() {
		return gridNodeCode;
	}

	/**
	 * @param gridNodeCode the gridNodeCode to set
	 */
	public void setGridNodeCode(String gridNodeCode) {
		this.gridNodeCode = gridNodeCode;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}// End of UserInfoDetails

package rest.mybatis.dao.meettingroom;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import rest.mybatis.model.meettingroom.MrUserRole;

public interface MrUserRoleMapper {
	//根据userid查询用户角色
	MrUserRole selectByUserId(@Param("userId") Integer userId);
	//插入用户角色
	int insertUserRole(MrUserRole userRole);
	//删除用户角色
	int deleteUserRole(@Param("userId")Integer userId);
	//获取所有
	List<MrUserRole> selectUserRole();
	//分页获取授权列表
	List<MrUserRole> seachUserRoleByPage(@Param("page") Integer page);
	//获取授权人员总数
	Integer selectUserRoleCounts();
	//根据名字模糊查询
	List<MrUserRole> selectUserRoleByName(@Param("userName") String userName);
}

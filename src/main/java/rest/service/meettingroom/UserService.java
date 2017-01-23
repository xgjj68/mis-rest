package rest.service.meettingroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rest.mybatis.dao.meettingroom.MrUserTMapper;
import rest.mybatis.model.meettingroom.MrDepartment;
import rest.mybatis.model.meettingroom.MrDepartmentWithBLOBs;
import rest.mybatis.model.meettingroom.MrUserT;

@RestController
public class UserService {
	@Autowired
	private MrUserTMapper mruserTMapper;
	
	  //根据名称模糊查询员工
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/searchUserByName/{userName}",method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MrUserT> searchUserByName(@PathVariable("userName") String userName){
		List<MrUserT> users = mruserTMapper.selectByName(userName+"%");
		return users;
	}
	//根据员工id查询员工信息
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/searchUserByUserId/{userId}",method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MrUserT searchUserByUserId(@PathVariable("userId") Integer userId){
		MrUserT userT = mruserTMapper.selectByPrimaryKey(userId);
		return userT;
	}
	//查询所有员工信息
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/searchUsers",method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MrUserT> searchUsers(){
		List<MrUserT> users = mruserTMapper.selectUsers();
		return users;
	}
	public MrUserTMapper getMruserTMapper() {
		return mruserTMapper;
	}
	public void setMruserTMapper(MrUserTMapper mruserTMapper) {
		this.mruserTMapper = mruserTMapper;
	}
	
	
}

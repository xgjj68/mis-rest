package rest.service.meettingroom;

import java.util.List;

import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.mybatis.dao.meettingroom.MrUserRoleMapper;
import rest.mybatis.model.meettingroom.MrUserRole;
import util.PropertiesReader;

@RestController
public class UserRoleService  {
	@Autowired
    private MrUserRoleMapper userRoleMapper;

	/*//查询所有员工信息
	@RequestMapping(value="/mis-rest/login")
	public String login() {
		return "login";
	}*/
	//获取员工角色
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/loadUserByUserId/{userId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public MrUserRole loadUserByUserId(@PathVariable("userId") Integer  userId) {
		MrUserRole userRole = userRoleMapper.selectByUserId(userId);
		return userRole;
	    }
	//员工授权
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/InsertUserRole",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Void> InsertUserRole(@RequestBody MrUserRole userRole) {
		userRoleMapper.insertUserRole(userRole);
		 HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	//员工权限删除
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/deleteUserRole/{userId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Void> deleteUserRole(@PathVariable("userId") Integer userId) {
		userRoleMapper.deleteUserRole(userId);
		 HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	//获取所有授权人员
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/seachAllUserRole",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public List<MrUserRole> seachAllUserRole() {
		List<MrUserRole> list = userRoleMapper.selectUserRole();
		return list;
	    }
	//获取管理员权限
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/getAdmin",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public String getAdmin() throws Exception {
		//读取配置文件
		PropertiesReader propertiesReader = new PropertiesReader("admin.properties");
		String value = propertiesReader.getValue("userId");
		return value;
	    }
	//分页获取权限人员
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/getUserRoleByPage/{page}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public List<MrUserRole> getUserRoleByPage(@PathVariable("page")Integer page) throws Exception {
		List<MrUserRole> list = userRoleMapper.seachUserRoleByPage(page);
		return list;
	}
	//获取权限人员总数
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/getUserRoleCounts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public Integer getUserRoleCounts() throws Exception {
		 Integer counts = userRoleMapper.selectUserRoleCounts();
		return counts;
	}
	//名字模糊查询
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/getUserRoleByName/{userName}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public List<MrUserRole> getUserRoleByName(@PathVariable("userName")String userName) throws Exception {
		 List<MrUserRole> list = userRoleMapper.selectUserRoleByName(userName+"%");
		return list;
	}
	public MrUserRoleMapper getUserRoleMapper() {
		return userRoleMapper;
	}
	public void setUserRoleMapper(MrUserRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}
	
}

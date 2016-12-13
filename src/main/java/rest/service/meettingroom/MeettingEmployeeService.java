package rest.service.meettingroom;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rest.mybatis.dao.meettingroom.MrMeettingEmployeeMapper;
import rest.mybatis.dao.meettingroom.MrSpOrderMapper;
import rest.mybatis.model.meettingroom.MrMeettingEmployee;
import rest.mybatis.model.meettingroom.MrSpOrder;

@RestController
public class MeettingEmployeeService {
	@Autowired
	private MrMeettingEmployeeMapper mrMeettingEmployeeMapper;
	@Autowired  
	private HttpSession session;
	@Autowired
	private MrSpOrderMapper mrSpOrderMapper;
	//插入维系会议与员工关系
	@RequestMapping(value="/InsertMrMeettingEmployee",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Void> InsertMrMeettingEmployee(@RequestBody ArrayList<Integer> ids) {
		
		MrSpOrder lastMrSpOrder = mrSpOrderMapper.selectLastMrSpOrder();
		Integer id2 = lastMrSpOrder.getId();
		MrMeettingEmployee mrMeettingEmployee = new MrMeettingEmployee();
		for(int i=0;i<ids.size();i++){
			for(int j=i+1;j<ids.size();j++){
				if(ids.get(i)==ids.get(j)){
					ids.remove(i);
				}
			}
		}
		System.out.println(ids.size());
		for (Integer integer : ids) {
			System.out.println(integer);
			if(integer!=null){
				mrMeettingEmployee.setMeettingId(id2);
				mrMeettingEmployee.setEmployeeId(integer);
				mrMeettingEmployeeMapper.insertSelective(mrMeettingEmployee);
			}
		}
		System.out.println("哈哈插入成功");
		 HttpHeaders headers = new HttpHeaders();
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	/*//根据会议id查询参会人员
	@RequestMapping(value="/selectMrSpOrderListByMeettingId/{meettingId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public MrMeettingEmployee selectMrSpOrderListByMeettingId(@PathVariable("meettingId") Integer meettingId) {

		MrMeettingEmployee mrMeettingEmployee = mrMeettingEmployeeMapper.selectBymeettingId(meettingId);
		System.out.println("selectMrSpOrderListByMeettingId");
		return mrMeettingEmployee;
	}
	//根据会议id查询参会人员
	@RequestMapping(value="/selectMrUserTListByMeettingId/{userId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public MrMeettingEmployee selectMrUserTListByMeettingId(@PathVariable("userId") Integer userId) {

		MrMeettingEmployee mrMeettingEmployee = mrMeettingEmployeeMapper.selectByemployeeId(userId);
		System.out.println("selectMrSpOrderListByMeettingId");
		return mrMeettingEmployee;
	}*/
	//删除维护会议与员工的关系
	@RequestMapping(value="/deleteMrMeettingEmployee/{userId}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> deleteMrMeettingEmployee( @RequestBody ArrayList<Integer> spids, @PathVariable("userId")Integer userId){
		System.out.println(spids);
		System.out.println(userId);
		for (Integer integer : spids) {
			if(integer!=null&&integer!=0){
				mrMeettingEmployeeMapper.deleteByUserIdAndMid(userId, integer);
			}
		}
		System.out.println("deleteMrMeettingEmployee");
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	public MrMeettingEmployeeMapper getMrMeettingEmployeeMapper() {
		return mrMeettingEmployeeMapper;
	}
	public void setMrMeettingEmployeeMapper(MrMeettingEmployeeMapper mrMeettingEmployeeMapper) {
		this.mrMeettingEmployeeMapper = mrMeettingEmployeeMapper;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public MrSpOrderMapper getMrSpOrderMapper() {
		return mrSpOrderMapper;
	}
	public void setMrSpOrderMapper(MrSpOrderMapper mrSpOrderMapper) {
		this.mrSpOrderMapper = mrSpOrderMapper;
	}
	
	
}

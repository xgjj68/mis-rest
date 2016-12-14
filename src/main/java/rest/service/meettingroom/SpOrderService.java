package rest.service.meettingroom;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.util.UriComponentsBuilder;

import rest.mybatis.dao.meettingroom.MrMeettingEmployeeMapper;
import rest.mybatis.dao.meettingroom.MrMeettingRoomMapper;
import rest.mybatis.dao.meettingroom.MrSpOrderMapper;
import rest.mybatis.dao.meettingroom.MrUserTMapper;
import rest.mybatis.model.meettingroom.MrDepartment;
import rest.mybatis.model.meettingroom.MrDepartmentWithBLOBs;
import rest.mybatis.model.meettingroom.MrMeettingEmployee;
import rest.mybatis.model.meettingroom.MrMeettingRoom;
import rest.mybatis.model.meettingroom.MrSpOrder;
import rest.mybatis.model.meettingroom.MrUserT;
import rest.mybatis.model.test.UserT;

@RestController
public class SpOrderService {
	@Autowired
	private MrSpOrderMapper mrSpOrderMapper;
	@Autowired
	private MrMeettingRoomMapper mrMeettingRoomMapper;
	@Autowired
	private MrUserTMapper mrUserTMapper;
	@Autowired
	private MrMeettingEmployeeMapper MMEMapper;
	//插入视频会议记录
	@RequestMapping(value="/InsertSpOrder",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Void> InsertSpOrder(@RequestBody MrSpOrder mrSpOrder) {
			mrSpOrderMapper.insertSelective(mrSpOrder); 
			System.out.println("哈哈插入成功");
			 HttpHeaders headers = new HttpHeaders();
			 return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	//按会议室名称查询会议记录
	@RequestMapping(value="/searchSpOrderByMeettingRoomId",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MrSpOrder> searchSpOrderByMeettingRoomId( @RequestParam("meettingRoomId") Integer meettingRoomId, @RequestParam("startdate")String startdate){
		List<MrSpOrder> mrSpOrders = mrSpOrderMapper.selectByMeettingRoomId(meettingRoomId,startdate);
		System.out.println(meettingRoomId);
		System.out.println(startdate);
		System.out.println("mrSpOrders");
		return mrSpOrders;
	}
	//查询所有的会议记录
	@RequestMapping(value="/searchAllSpOrder/{userId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MrUserT searchAllSpOrder(@PathVariable("userId") Integer userId){
		System.out.println("进入searchAllSpOrder");
		MrUserT mrUserT = mrUserTMapper.selectByPrimaryKey(userId);
		System.out.println("搜索searchAllSpOrder");
		return mrUserT;
	}
	//删除会议记录
	@RequestMapping(value="/deleteSpOrderByIds",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Void> deleteSpOrderByIds(@RequestBody ArrayList<Integer> ids) {
		for (Integer integer : ids) {
			if(integer!=null&&integer!=0){
				List<MrMeettingEmployee> list = MMEMapper.selectBymeettingId(integer);
				if(list.size()==0){
					mrSpOrderMapper.deleteByPrimaryKey(integer);
					System.out.println("哈哈删除成功");
				}	
			}
		}
		System.out.println("有数据不能删除");
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	//按id查询会议记录
	@RequestMapping(value="/searchSpOrderById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public MrSpOrder searchSpOrderById(@PathVariable("id") Integer id) {
		System.out.println(id);
		MrSpOrder mrSpOrder = mrSpOrderMapper.selectByPrimaryKey(id);
		System.out.println("查询searchSpOrderById成功");
		return mrSpOrder;
	}
	//按日期查询会议记录
	@RequestMapping(value="/searchSpOrderByDate/{startDate}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public List<MrSpOrder> searchSpOrderByDate(@PathVariable("startDate") String startDate) {
		System.out.println(startDate);
		List<MrSpOrder> mrSpOrderDate = mrSpOrderMapper.selectByStartDate(startDate);
		System.out.println("查询searchSpOrderByDate成功");
		return mrSpOrderDate;
	}
	//查询最后一条会议记录	
		@RequestMapping(value="/searchLastSpOrder",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody 
		public MrSpOrder searchLastSpOrder() {
			 MrSpOrder mrSpOrder = mrSpOrderMapper.selectLastMrSpOrder();
			System.out.println("查询searchLastSpOrder成功");
			return mrSpOrder;
		}
	//查询上一条会议记录
		@RequestMapping(value="/searchbeforSpOrder/{timeAndMe}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody 
		public MrSpOrder searchafterSpOrder(@PathVariable("timeAndMe") String  dateAndMe) {
			System.out.println(dateAndMe);
			String[] strings = dateAndMe.split(":");
			Integer  id = Integer.parseInt(strings[0]);
			Integer  MeId = Integer.parseInt(strings[1]);
			 MrSpOrder mrSpOrder = mrSpOrderMapper.selectBefor(strings[0],MeId);
			System.out.println("查询searchbeforSpOrder成功");
			return mrSpOrder;
		}
	//查询下一条会议记录
		@RequestMapping(value="/searchafterSpOrder/{timeAndMe}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody 
		public MrSpOrder searchbeforSpOrder(@PathVariable("timeAndMe") String dateAndMe) {
			System.out.println(dateAndMe);
			String[] strings = dateAndMe.split(":");
			Integer  id = Integer.parseInt(strings[0]);
			Integer  MeId = Integer.parseInt(strings[1]);
			 MrSpOrder mrSpOrder = mrSpOrderMapper.selectNext(strings[0],MeId);
			System.out.println("查询searchafterSpOrder成功");
			return mrSpOrder;
		}
	//修改会议室预订信息
		@RequestMapping(value = "/updateSpOrder", method = RequestMethod.PUT)
		@ResponseBody 
	    public void updateSpOrder(@RequestBody MrSpOrder mrSpOrder) {
			Integer id = mrSpOrder.getId();
			String organization = mrSpOrder.getOrganization();
			Integer userId = mrUserTMapper.selectByName(organization).get(0).getUserId();
			MrSpOrder spOrder = mrSpOrderMapper.selectByPrimaryKey(id);
			MrMeettingEmployee mrMeettingEmployee = new MrMeettingEmployee();
			if(spOrder!=null){
				MMEMapper.deleteByMeettingId(id);
				 mrSpOrderMapper.updateByPrimaryKeySelective(mrSpOrder);
				    mrMeettingEmployee.setMeettingId(id);
					mrMeettingEmployee.setEmployeeId(userId);
					MMEMapper.insertSelective(mrMeettingEmployee);
			}else{
				System.out.println("User with id " + id + " not found");
			}
	       
	    }
	public MrSpOrderMapper getMrSpOrderMapper() {
		return mrSpOrderMapper;
	}

	public void setMrSpOrderMapper(MrSpOrderMapper mrSpOrderMapper) {
		this.mrSpOrderMapper = mrSpOrderMapper;
	}
	public MrMeettingRoomMapper getMrMeettingRoomMapper() {
		return mrMeettingRoomMapper;
	}
	public void setMrMeettingRoomMapper(MrMeettingRoomMapper mrMeettingRoomMapper) {
		this.mrMeettingRoomMapper = mrMeettingRoomMapper;
	}
	public MrUserTMapper getMrUserTMapper() {
		return mrUserTMapper;
	}
	public void setMrUserTMapper(MrUserTMapper mrUserTMapper) {
		this.mrUserTMapper = mrUserTMapper;
	}
	public MrMeettingEmployeeMapper getMMEMapper() {
		return MMEMapper;
	}
	public void setMMEMapper(MrMeettingEmployeeMapper mMEMapper) {
		MMEMapper = mMEMapper;
	}
	
}

package rest.service.meettingroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rest.mybatis.dao.meettingroom.MrMeettingRoomMapper;
import rest.mybatis.model.meettingroom.MrMeettingRoom;
import rest.mybatis.model.meettingroom.MrSpOrder;
import rest.mybatis.model.test.UserT;


@RestController
public class MettingRoomServie {
	@Autowired
	private MrMeettingRoomMapper mrmeettingRommMapper;
	
	//分页查询出所有的会议室
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/searchAllMeettingRoomByPage/{page}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MrMeettingRoom> searchAllMeettingRoomByPage(@PathVariable("page") Integer page ){
		List<MrMeettingRoom> meettingRooms = mrmeettingRommMapper.selectAllMeettingRoomByPage(page);
		return meettingRooms;
	}
	//查询所有会议室
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/searchAllMeettingRoom",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MrMeettingRoom> searchAllMeettingRoom( ){
		List<MrMeettingRoom> meettingRooms = mrmeettingRommMapper.selectAllMeettingRoom();
		return meettingRooms;
	}
	//添加会议室
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/addMeettingRoom",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addAllMeettingRoom(@RequestBody MrMeettingRoom meettingRoom){
		 mrmeettingRommMapper.insertSelective(meettingRoom);
	}
	//删除会议室
	
	@RequestMapping(value = "/mis-rest/rest/service/meettingroom/deleteMeettingRoom/{id}", method = RequestMethod.GET)
    public void deleteMeettingRoom(@PathVariable("id") Integer id) {
		MrMeettingRoom mrMeettingRoom = mrmeettingRommMapper.selectByPrimaryKey(id);
		mrMeettingRoom.setZhuangTai(-1);
		mrmeettingRommMapper.updateByPrimaryKeySelective(mrMeettingRoom);
       
    }
	//根据id查询会议室
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/searchMeettingRoomById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MrMeettingRoom searchMeettingRoomById(@PathVariable("id")Integer id){
		 MrMeettingRoom mrMeettingRoom = mrmeettingRommMapper.selectByPrimaryKey(id);
		return mrMeettingRoom;
	}
	//修改会议室信息
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/updateMeettingRoom",method=RequestMethod.PUT)
	@ResponseBody
	public void updateMeettingRoom(@RequestBody MrMeettingRoom mrMeettingRoom){
		mrmeettingRommMapper.updateByPrimaryKeySelective(mrMeettingRoom);
	}
	//查询会议室总数
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/selectMeettingRoomCounts",method=RequestMethod.GET)
	@ResponseBody
	public Integer selectMeettingRoomCounts(){
		Integer counts = mrmeettingRommMapper.selectMeettingRoomCounts();
		return counts;
	}
	public MrMeettingRoomMapper getMrmeettingRommMapper() {
		return mrmeettingRommMapper;
	}
	public void setMrmeettingRommMapper(MrMeettingRoomMapper mrmeettingRommMapper) {
		this.mrmeettingRommMapper = mrmeettingRommMapper;
	}
}
	

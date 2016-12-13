package rest.service.meettingroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rest.mybatis.dao.meettingroom.MrMeettingRoomMapper;
import rest.mybatis.model.meettingroom.MrMeettingRoom;


@RestController
public class MettingRoomServie {
	@Autowired
	private MrMeettingRoomMapper mrmeettingRommMapper;
	
	//查询出所有的会议室
	@RequestMapping(value="/searchAllMeettingRoom",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MrMeettingRoom> searchAllMeettingRoom(){
		System.out.println("搜索会议室");
		List<MrMeettingRoom> meettingRooms = mrmeettingRommMapper.selectAllMeettingRoom();
		return meettingRooms;
	}
	
	public MrMeettingRoomMapper getMrmeettingRommMapper() {
		return mrmeettingRommMapper;
	}
	public void setMrmeettingRommMapper(MrMeettingRoomMapper mrmeettingRommMapper) {
		this.mrmeettingRommMapper = mrmeettingRommMapper;
	}
}
	

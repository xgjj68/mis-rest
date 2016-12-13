package rest.service.meettingroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rest.mybatis.dao.meettingroom.MrDepartmentMapper;
import rest.mybatis.model.meettingroom.MrDepartment;
import rest.mybatis.model.meettingroom.MrDepartmentWithBLOBs;


@RestController
public class DepartmentService {
	@Autowired
	private MrDepartmentMapper mrdepartmentmapper;
	//获取所有的部门
	@RequestMapping(value="/departments",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MrDepartmentWithBLOBs> searchAllDepartments(){
		System.out.println("进入service");
		List<MrDepartmentWithBLOBs> departments = mrdepartmentmapper.selectAllMrDepartment();
		System.out.println("搜索");
		return departments;
	}
	public MrDepartmentMapper getMrdepartmentmapper() {
		return mrdepartmentmapper;
	}
	public void setMrdepartmentmapper(MrDepartmentMapper mrdepartmentmapper) {
		this.mrdepartmentmapper = mrdepartmentmapper;
	}
	
	
}

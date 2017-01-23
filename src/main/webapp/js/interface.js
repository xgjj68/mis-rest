MeettingRoominterfaces={
	//条件（id和开始时间）提取会议预定记录
	Var_searchSpOrderByMeettingRoomIdAndTime:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchSpOrderByMeettingRoomId',
	
	//添加会议室预定记录接口
	Var_InsertSpOrder:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/InsertSpOrder',
	
	//插入员工和会议关系接口
	Var_InsertMrMeettingEmploye:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/InsertMrMeettingEmployee',
	
	//提取所有部门信息的接口
	Var_departments:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/departments',
	//根据部门名称模糊查询部门
	Var_departmentsByName:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/departmentsByName/',
	//根据输入员工名模糊查询员工列表接口
	Var_searchUserByName:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchUserByName/',
	//查询所有员工信息
	Var_searchUsers:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchUsers',
	//提取所有会议室接口
	Var_searchAllMeettingRoom:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchAllMeettingRoom',
	
	//修改会议室记录接口
	Var_updateSpOrder:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/updateSpOrder',
	
	//根据会议Id查询会议记录接口
	Var_searchSpOrderById:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchSpOrderById/',
	
	//条件（id）提取会议预定记录
	Var_searchSpOrderByMeettingRoomId:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchSpOrderByMeettingRoomId/',
	
	//查询按时间查询会议室
	Var_searchSpOrderByDate:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchSpOrderByDate/',
	
	//删除会议员工关系
	Var_deleteMrMeettingEmployee:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/deleteMrMeettingEmployee/',
	
	//删除会议记录
	Var_deleteSpOrderByIds:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/deleteSpOrderByIds',
	
	//根据用户id查询该员工所有的会议记录
	Var_searchAllSpOrder:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchAllSpOrder/',
	
	//根据当前会议获取上一条会议记录
	Var_searchbeforSpOrder:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchbeforSpOrder/',
	
	//根据当前会议获取下一条会议记录
	Var_searchafterSpOrder:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchafterSpOrder/',
	
	//添加会议室
	Var_addMeettingRoom:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/addMeettingRoom',
	
	//删除会议室
	Var_deleteMeettingRoom:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/deleteMeettingRoom/',
	
	//根据id查询会议室
	Var_searchMeettingRoomById:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchMeettingRoomById/',
	
	//修改会议室信息
	Var_updateMeettingRoom:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/updateMeettingRoom',
	
	//获取所有的链接
	Var_downloads:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/downloads',
	
	//修改链接地址
	Var_updateSpdownload:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/updateSpdownload',
	
	//上传文件接口
	Var_upload:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/upload',
	
	//下载文件
	Var_downlaod:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/Download',
	
	//员工邮件发送
	Var_sendMailetoEmployee:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/sendMailetoEmployee',
	
	//管理员邮件发送
	Var_sendMaileToAdmin:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/sendMaileToAdmin',
	
	//按员工id查询会议的总条数
	Var_searchbeSpOrderCounts:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchbeSpOrderCounts/',
	
	//根据员工id查询员工信息
	Var_searchUserByUserId:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchUserByUserId/',
	
	//权限管理获取角色
	Var_loadUserByUserId:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/loadUserByUserId/',
	
	//权限管理授权
	Var_InsertUserRole:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/InsertUserRole',
	
	//权限管理去除权限
	Var_deleteUserRole:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/deleteUserRole/',
	
	//获取所有授权人员
	Var_seachAllUserRole:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/seachAllUserRole',
	//获取管理员权限
	Var_getAdmin:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/getAdmin'	
};
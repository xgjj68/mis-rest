var misrest_dns="http://mis.dayang.com/mis-rest";
MeettingRoominterfaces={
//	//张鹏机器
//	//条件（id和开始时间）提取会议预定记录
//	Var_searchSpOrderByMeettingRoomIdAndTime:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchSpOrderByMeettingRoomId',
//	
//	//添加会议室预定记录接口
//	Var_InsertSpOrder:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/InsertSpOrder',
//	
//	//插入员工和会议关系接口
//	Var_InsertMrMeettingEmploye:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/InsertMrMeettingEmployee',
//	
//	//提取所有部门信息的接口
//	Var_departments:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/departments',
//	//根据部门名称模糊查询部门
//	Var_departmentsByName:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/departmentsByName/',
//	//根据输入员工名模糊查询员工列表接口
//	Var_searchUserByName:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchUserByName/',
//	//查询所有员工信息
//	Var_searchUsers:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchUsers',
//	//分页提取会议室接口
//	Var_searchAllMeettingRoomByPage:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchAllMeettingRoomByPage/',
//	//提取所有会议室
//	Var_searchAllMeettingRoom:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchAllMeettingRoom',
//	//修改会议室记录接口
//	Var_updateSpOrder:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/updateSpOrder',
//	
//	//根据会议Id查询会议记录接口
//	Var_searchSpOrderById:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchSpOrderById/',
//	
//	//条件（id）提取会议预定记录
//	Var_searchSpOrderByMeettingRoomId:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchSpOrderByMeettingRoomId/',
//	
//	//查询按时间查询会议室
//	Var_searchSpOrderByDate:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchSpOrderByDate/',
//	
//	//删除会议员工关系
//	Var_deleteMrMeettingEmployee:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/deleteMrMeettingEmployee/',
//	
//	//删除会议记录
//	Var_deleteSpOrderByIds:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/deleteSpOrderByIds',
//	
//	//根据用户id查询该员工所有的会议记录
//	Var_searchAllSpOrder:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchAllSpOrder/',
//	
//	//根据当前会议获取上一条会议记录
//	Var_searchbeforSpOrder:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchbeforSpOrder/',
//	
//	//根据当前会议获取下一条会议记录
//	Var_searchafterSpOrder:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchafterSpOrder/',
//	
//	//添加会议室
//	Var_addMeettingRoom:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/addMeettingRoom',
//	
//	//删除会议室
//	Var_deleteMeettingRoom:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/deleteMeettingRoom/',
//	
//	//根据id查询会议室
//	Var_searchMeettingRoomById:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchMeettingRoomById/',
//	
//	//修改会议室信息
//	Var_updateMeettingRoom:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/updateMeettingRoom',
//	
//	//获取所有的文件信息
//	Var_downloads:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/downloads',
//	
//	//修改链接地址
//	Var_updateSpdownload:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/updateSpdownload',
//	//插入文件信息
//	Var_insertSpdownload:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/insertSpdownload',
//	//删除文件信息
//	Var_deleteSpdownload:'http://192.168.6.190:8080	/mis-rest/rest/service/meettingroom/deleteSpdownload/',
//
//	//上传文件接口
//	Var_upload:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/upload',
//	//删除文件接口
//	Var_deleteFile:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/deleteFile',
//	//下载文件
//	Var_downlaod:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/Download',
//	
//	//员工邮件发送
//	Var_sendMailetoEmployee:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/sendMailetoEmployee',
//	
//	//管理员邮件发送
//	Var_sendMaileToAdmin:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/sendMaileToAdmin',
//	
//	//按员工id查询会议的总条数
//	Var_searchbeSpOrderCounts:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchbeSpOrderCounts/',
//	
//	//根据员工id查询员工信息
//	Var_searchUserByUserId:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/searchUserByUserId/',
//	
//	//权限管理获取角色
//	Var_loadUserByUserId:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/loadUserByUserId/',
//	
//	//权限管理授权
//	Var_InsertUserRole:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/InsertUserRole',
//	
//	//权限管理去除权限
//	Var_deleteUserRole:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/deleteUserRole/',
//	
//	//获取所有授权人员
//	Var_seachAllUserRole:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/seachAllUserRole',
//	//获取管理员权限
//	Var_getAdmin:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/getAdmin',
//	//查询会议室总数
//	Var_selectMeettingRoomCounts:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/selectMeettingRoomCounts',
//    //分页获取权限人员
//	Var_getUserRoleByPage:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/getUserRoleByPage/',
//	//获取权限人员总数
//	Var_getUserRoleCounts:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/getUserRoleCounts',
//	//名字模糊查询授权人员
//	Var_getUserRoleByName:'http://192.168.6.190:8080/mis-rest/rest/service/meettingroom/getUserRoleByName/',
	
	
	
	
	//正式库
	
	//条件（id和开始时间）提取会议预定记录
	Var_searchSpOrderByMeettingRoomIdAndTime:misrest_dns+'/mis-rest/rest/service/meettingroom/searchSpOrderByMeettingRoomId',
	
	//添加会议室预定记录接口
	Var_InsertSpOrder:misrest_dns+'/mis-rest/rest/service/meettingroom/InsertSpOrder',
	
	//插入员工和会议关系接口
	Var_InsertMrMeettingEmploye:misrest_dns+'/mis-rest/rest/service/meettingroom/InsertMrMeettingEmployee',
	
	//提取所有部门信息的接口
	Var_departments:misrest_dns+'/mis-rest/rest/service/meettingroom/departments',
	//根据部门名称模糊查询部门
	Var_departmentsByName:misrest_dns+'/mis-rest/rest/service/meettingroom/departmentsByName/',
	//根据输入员工名模糊查询员工列表接口
	Var_searchUserByName:misrest_dns+'/mis-rest/rest/service/meettingroom/searchUserByName/',
	//查询所有员工信息
	Var_searchUsers:misrest_dns+'/mis-rest/rest/service/meettingroom/searchUsers',
	//分页提取会议室接口
	Var_searchAllMeettingRoomByPage:misrest_dns+'/mis-rest/rest/service/meettingroom/searchAllMeettingRoomByPage/',
	//提取所有会议室
	Var_searchAllMeettingRoom:misrest_dns+'/mis-rest/rest/service/meettingroom/searchAllMeettingRoom',
	//修改会议室记录接口
	Var_updateSpOrder:misrest_dns+'/mis-rest/rest/service/meettingroom/updateSpOrder',
	
	//根据会议Id查询会议记录接口
	Var_searchSpOrderById:misrest_dns+'/mis-rest/rest/service/meettingroom/searchSpOrderById/',
	
	//条件（id）提取会议预定记录
	Var_searchSpOrderByMeettingRoomId:misrest_dns+'/mis-rest/rest/service/meettingroom/searchSpOrderByMeettingRoomId/',
	
	//查询按时间查询会议室
	Var_searchSpOrderByDate:misrest_dns+'/mis-rest/rest/service/meettingroom/searchSpOrderByDate/',
	
	//删除会议员工关系
	Var_deleteMrMeettingEmployee:misrest_dns+'/mis-rest/rest/service/meettingroom/deleteMrMeettingEmployee/',
	
	//删除会议记录
	Var_deleteSpOrderByIds:misrest_dns+'/mis-rest/rest/service/meettingroom/deleteSpOrderByIds',
	
	//根据用户id查询该员工所有的会议记录
	Var_searchAllSpOrder:misrest_dns+'/mis-rest/rest/service/meettingroom/searchAllSpOrder/',
	
	//根据当前会议获取上一条会议记录
	Var_searchbeforSpOrder:misrest_dns+'/mis-rest/rest/service/meettingroom/searchbeforSpOrder/',
	
	//根据当前会议获取下一条会议记录
	Var_searchafterSpOrder:misrest_dns+'/mis-rest/rest/service/meettingroom/searchafterSpOrder/',
	
	//添加会议室
	Var_addMeettingRoom:misrest_dns+'/mis-rest/rest/service/meettingroom/addMeettingRoom',
	
	//删除会议室
	Var_deleteMeettingRoom:misrest_dns+'/mis-rest/rest/service/meettingroom/deleteMeettingRoom/',
	
	//根据id查询会议室
	Var_searchMeettingRoomById:misrest_dns+'/mis-rest/rest/service/meettingroom/searchMeettingRoomById/',
	
	//修改会议室信息
	Var_updateMeettingRoom:misrest_dns+'/mis-rest/rest/service/meettingroom/updateMeettingRoom',
	
	//获取所有的文件信息
	Var_downloads:misrest_dns+'/mis-rest/rest/service/meettingroom/downloads',
	
	//修改链接地址
	Var_updateSpdownload:misrest_dns+'/mis-rest/rest/service/meettingroom/updateSpdownload',
	//插入文件信息
	Var_insertSpdownload:misrest_dns+'/mis-rest/rest/service/meettingroom/insertSpdownload',
	//删除文件信息
	Var_deleteSpdownload:misrest_dns+'	/mis-rest/rest/service/meettingroom/deleteSpdownload/',

	//上传文件接口
	Var_upload:misrest_dns+'/mis-rest/rest/service/meettingroom/upload',
	//删除文件接口
	Var_deleteFile:misrest_dns+'/mis-rest/rest/service/meettingroom/deleteFile',
	//下载文件
	Var_downlaod:misrest_dns+'/mis-rest/rest/service/meettingroom/Download',
	
	//员工邮件发送
	Var_sendMailetoEmployee:misrest_dns+'/mis-rest/rest/service/meettingroom/sendMailetoEmployee',
	
	//管理员邮件发送
	Var_sendMaileToAdmin:misrest_dns+'/mis-rest/rest/service/meettingroom/sendMaileToAdmin',
	
	//按员工id查询会议的总条数
	Var_searchbeSpOrderCounts:misrest_dns+'/mis-rest/rest/service/meettingroom/searchbeSpOrderCounts/',
	
	//根据员工id查询员工信息
	Var_searchUserByUserId:misrest_dns+'/mis-rest/rest/service/meettingroom/searchUserByUserId/',
	
	//权限管理获取角色
	Var_loadUserByUserId:misrest_dns+'/mis-rest/rest/service/meettingroom/loadUserByUserId/',
	
	//权限管理授权
	Var_InsertUserRole:misrest_dns+'/mis-rest/rest/service/meettingroom/InsertUserRole',
	
	//权限管理去除权限
	Var_deleteUserRole:misrest_dns+'/mis-rest/rest/service/meettingroom/deleteUserRole/',
	
	//获取所有授权人员
	Var_seachAllUserRole:misrest_dns+'/mis-rest/rest/service/meettingroom/seachAllUserRole',
	//获取管理员权限
	Var_getAdmin:misrest_dns+'/mis-rest/rest/service/meettingroom/getAdmin',
	//查询会议室总数
	Var_selectMeettingRoomCounts:misrest_dns+'/mis-rest/rest/service/meettingroom/selectMeettingRoomCounts',
    //分页获取权限人员
	Var_getUserRoleByPage:misrest_dns+'/mis-rest/rest/service/meettingroom/getUserRoleByPage/',
	//获取权限人员总数
	Var_getUserRoleCounts:misrest_dns+'/mis-rest/rest/service/meettingroom/getUserRoleCounts',
	//名字模糊查询授权人员
	Var_getUserRoleByName:misrest_dns+'/mis-rest/rest/service/meettingroom/getUserRoleByName/',
};
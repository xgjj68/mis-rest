package rest.service.meettingroom;


import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import rest.mybatis.dao.meettingroom.MrSpDownloadMapper;
import rest.mybatis.model.meettingroom.MrSpDownload;
import util.PropertiesReader;
@RestController
public class SpDownloadService{
	@Autowired
	private MrSpDownloadMapper mrSpDownlaodMapper;
	//获取所有的链接
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/downloads",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MrSpDownload> searchAlldownlaods(){
		List<MrSpDownload> list = mrSpDownlaodMapper.selectAlldownload();
		return list;
	}
	//修改下载地址
	@RequestMapping(value = "/mis-rest/rest/service/meettingroom/updateSpdownload", method = RequestMethod.PUT)
	@ResponseBody 
    public void updateSpOrder(@RequestBody MrSpDownload mrSpDownload) {
		mrSpDownlaodMapper.updateByPrimaryKeySelective(mrSpDownload); 
    }
	//插入文件信息
	@RequestMapping(value = "/mis-rest/rest/service/meettingroom/insertSpdownload", method = RequestMethod.POST)
	@ResponseBody 
    public void insertSpdownload(@RequestBody MrSpDownload mrSpDownload) {
		mrSpDownload.setDownload("wenjian");
		mrSpDownlaodMapper.insert(mrSpDownload); 
		
    }
	//删除文件数据
	@RequestMapping(value = "/mis-rest/rest/service/meettingroom/deleteSpdownload/{id}", method = RequestMethod.DELETE)
	@ResponseBody 
    public void deleteSpdownload(@PathVariable ("id") Integer id) {
		mrSpDownlaodMapper.deleteByPrimaryKey(id);
    }

	//下载文件
	@RequestMapping(value = "/mis-rest/rest/service/meettingroom/Download", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> Download  (@RequestParam("fileName")String fileName, HttpServletResponse response,HttpServletRequest request)   {
    	try {
    		//读取配置文件
    		PropertiesReader propertiesReader = new PropertiesReader("uploadURL.properties");
    		//获取文件夹路径
    		String dirPath = propertiesReader.getValue("uploadURL")+fileName;
    		//获取文件
			FileSystemResource file = new FileSystemResource(dirPath);
			//获取文件名
			String filename = file.getFilename();
			String dfileName = new String(filename.getBytes(), "UTF-8");
			HttpHeaders headers = new HttpHeaders();
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");  
			headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", new String(dfileName.getBytes("utf-8"),"ISO-8859-1")));  
			headers.add("Pragma", "no-cache");  
			headers.add("Expires", "0");  

			return ResponseEntity  
					.ok()  
					.headers(headers)  
					.contentLength(file.contentLength())  
					.contentType(MediaType.parseMediaType("multipart/form-data"))  
					.body(new InputStreamResource(file.getInputStream()));  
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	//删除文件
	@RequestMapping(value = "/mis-rest/rest/service/meettingroom/deleteFile", method = RequestMethod.GET)
    public void deleteFile  (@RequestParam("fileName")String fileName, HttpServletResponse response,HttpServletRequest request)   {
    	try {
    		//读取配置文件
    		PropertiesReader propertiesReader = new PropertiesReader("uploadURL.properties");
    		//获取文件夹路径
    		String dirPath = propertiesReader.getValue("uploadURL");
    		
    		File dirFile = new File(dirPath);  
    		if (!dirFile.exists()) {  
				dirFile.mkdirs();  
			}
    		String s = dirPath+ fileName;//文件的绝对路径
    		   File file = new File(s);
    		   if(file.exists()){
    			     boolean d = file.delete();
    		   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	public MrSpDownloadMapper getMrSpDownlaodMapper() {
		return mrSpDownlaodMapper;
	}
	public void setMrSpDownlaodMapper(MrSpDownloadMapper mrSpDownlaodMapper) {
		this.mrSpDownlaodMapper = mrSpDownlaodMapper;
	}
	
}

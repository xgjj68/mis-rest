package rest.service.meettingroom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import util.PropertiesReader;

@RestController 
public class SpuploadService {
	//上传文件
		@RequestMapping(value = "/mis-rest/rest/service/meettingroom/upload", method = RequestMethod.POST)
		@ResponseBody 
	    public String upload  (@RequestParam("file") MultipartFile file) throws Exception {
				if (!file.isEmpty()) {
				try {
					//读取配置文件
					PropertiesReader propertiesReader = new PropertiesReader("uploadURL.properties");
					//获取上传路径
					String dirPath = propertiesReader.getValue("uploadURL");
					//String dirPath = "E:\\workspace\\mis-rest\\src\\main\\webapp\\upload";  
					File dirFile = new File(dirPath);  
					if (!dirFile.exists()) {  
						dirFile.mkdirs();  
					}
					  //设置响应的内容类型 
					//response.setContentType("application/x-msdownload"); //指定响应动作是下载
					//获取文件
					File uploadFile = new File(dirFile,  
							file.getOriginalFilename());
					InputStream is = file.getInputStream();  
					FileOutputStream fos = new FileOutputStream(uploadFile);  
					byte[] tmp = new byte[1024];  
					int len = -1;  
					while ((len = is.read(tmp)) != -1) {  
						fos.write(tmp, 0, len);  
					}  
					is.close();  
					fos.flush();  
					fos.close();  
					Thread.sleep(1000);
					return "success";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "fail";
				}
			}
			return "fail";
	    }
}

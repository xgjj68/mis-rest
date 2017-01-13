package rest.service.meettingroom;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

/*	//上传文件
	@RequestMapping(value = "/mis-rest/rest/service/meettingroom/upload", method = RequestMethod.POST)
	@ResponseBody 
    public String upload  (HttpServletRequest request) throws Exception {
		DiskFileItemFactory factory = new DiskFileItemFactory();  
		ServletFileUpload upload = new ServletFileUpload(factory);  
		upload.setHeaderEncoding("utf-8"); 
		List<FileItem> fis=upload.parseRequest(request);
		for (int i = 0; i < fis.size(); i++) {
			System.out.println(fis.get(i).getString());
		}
		
		if (!uploadfile.isEmpty()) {
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
						uploadfile.getOriginalFilename());
				InputStream is = uploadfile.getInputStream();  
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
    }*/
	//下载文件
	@RequestMapping(value = "/mis-rest/rest/service/meettingroom/Download", method = RequestMethod.GET)
	//@ResponseBody
    public ResponseEntity<InputStreamResource> Download  (@RequestParam("filePath")String filePath, HttpServletResponse response,HttpServletRequest request)   {
    	try {
    		//获取文件
			FileSystemResource file = new FileSystemResource(filePath);
			//获取文件名
			String fileName = file.getFilename();
			String dfileName = new String(fileName.getBytes("iso-8859-1"), "UTF-8");
			HttpHeaders headers = new HttpHeaders();
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");  
			headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", dfileName));  
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
		
			/*File downloadFile = new File(filePath);  
	
			ServletContext context = request.getServletContext();  
	
			// get MIME type of the file  
			String mimeType = context.getMimeType(filePath);  
			if (mimeType == null) {  
				// set to binary type if MIME mapping not found  
				mimeType = "application/octet-stream";  
				System.out.println("context getMimeType is null");  
			}  
			System.out.println("MIME type: " + mimeType);  
	
			// set content attributes for the response  
			response.setContentType(mimeType);  
			response.setContentLength((int) downloadFile.length());  
	
			// set headers for the response  
			String headerKey = "Content-Disposition";  
			String headerValue = String.format("attachment; filename=\"%s\"",  
					downloadFile.getName());  
			response.setHeader(headerKey, headerValue);
			try {  
				InputStream myStream = new FileInputStream(filePath);  
				IOUtils.copy(myStream, response.getOutputStream());  
				response.flushBuffer();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  */
    }
	  
	public MrSpDownloadMapper getMrSpDownlaodMapper() {
		return mrSpDownlaodMapper;
	}
	public void setMrSpDownlaodMapper(MrSpDownloadMapper mrSpDownlaodMapper) {
		this.mrSpDownlaodMapper = mrSpDownlaodMapper;
	}
	
}

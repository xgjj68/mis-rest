package rest.service.meettingroom;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.assertj.core.data.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rest.mybatis.dao.meettingroom.MrSpOrderMapper;
import rest.mybatis.model.meettingroom.MrMeettingRoom;
import rest.mybatis.model.meettingroom.MrSpOrder;

@Component 
public class RegularlysendService {
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
	private MrSpOrderMapper mrSpOrderMapper;
	@Scheduled(fixedRate=600000)  
	public void testTasks() throws Exception {      
		 System.out.println("=====每隔10分钟执行一次=====");
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		 String startDate = df.format(new Date());
		 System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		 List<MrSpOrder> mrSpOrderDate = mrSpOrderMapper.selectByStartDate(startDate);
		 Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		 //int year = c.get(Calendar.YEAR); 
		 //int month = c.get(Calendar.MONTH); 
		 //int date = c.get(Calendar.DATE); 
		 int hour = c.get(Calendar.HOUR_OF_DAY); 
		 int minute = c.get(Calendar.MINUTE); 
		 //int second = c.get(Calendar.SECOND); 
		 System.out.println(hour); 

		 int bighour = -1;
		 for (MrSpOrder mrSpOrder : mrSpOrderDate) {
			 String endTime = mrSpOrder.getEndTime();
			 String[] split = endTime.split(":");
			 int parseInt = Integer.parseInt(split[0]);

			 if(parseInt>bighour){
				bighour = parseInt;
			 }
		}
		 if( hour-bighour>=0&&hour-bighour<=1){
			 if(minute<=10){
				 this.sendMaileToAdmin(); 
			 }
		 }
	}    
	//发送会议提示邮件给管理员
			public void sendMaileToAdmin() throws MessagingException{

				MrSpOrder mrSpOrder = mrSpOrderMapper.selectLastMrSpOrder();
				String meettingName = mrSpOrder.getMeettingName();
				String organization = mrSpOrder.getOrganization();
				String startDate = mrSpOrder.getStartDate();
				String endDate = mrSpOrder.getEndDate();
				String startTime = mrSpOrder.getStartTime();
				String endTime = mrSpOrder.getEndTime();
				MrMeettingRoom mrMeettingRoom = mrSpOrder.getMrMeettingRoom();
				String meetingRoomName = mrMeettingRoom.getMeetingRoomName();
				
				MimeMessage mimeMessage = mailSender.createMimeMessage();

				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				helper.setFrom("dayang_erp@dayang.com.cn");
				//helper.setTo("zhangpeng@dayang.com.cn");
				String ids [] = {"zhangpeng@dayang.com.cn","yangbowen@dayang.com.cn"};
				helper.setTo(ids);
				helper.setSubject("系统自动通知邮件-视频会议结束提示");
				helper.setText("<html><body>&nbsp&nbsp&nbsp您好！<br>"
						+"<br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp会议议题："+meettingName
						+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp组织人："+organization
						+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp所在会议室："+meetingRoomName
						+ "<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp开始时间："+startDate+"&nbsp&nbsp"+startTime
						+"<br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp结束时间："+endDate+"&nbsp&nbsp"+endTime
						+"<br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+"\""+meettingName+"\""+"此会议已结束"
						+"<br><br><br><br>&nbsp&nbsp&nbsp北京中科大洋电子信息平台<br><br>&nbsp&nbsp&nbsp<strong>Email:dayang_erp@dayang.com.cn</strong></body></html>", true);
				mailSender.send(mimeMessage);

			}

			public MrSpOrderMapper getMrSpOrderMapper() {
				return mrSpOrderMapper;
			}

			public void setMrSpOrderMapper(MrSpOrderMapper mrSpOrderMapper) {
				this.mrSpOrderMapper = mrSpOrderMapper;
			}
			
}

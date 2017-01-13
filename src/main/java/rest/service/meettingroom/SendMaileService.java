package rest.service.meettingroom;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import rest.mybatis.dao.meettingroom.MrSpOrderMapper;
import rest.mybatis.model.meettingroom.MrMeettingRoom;
import rest.mybatis.model.meettingroom.MrSpOrder;
import rest.mybatis.model.meettingroom.MrUserT;
@RestController
public class SendMaileService {
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
	private MrSpOrderMapper mrSpOrderMapper;
	//发送会议提示邮件给员工
	@RequestMapping(value="/mis-rest/rest/service/meettingroom/sendMailetoEmployee",method=RequestMethod.GET)
	public void sendMaileToEmployee() throws MessagingException{

		/*SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("dayang_erp@dayang.com.cn");
		message.setTo("zhangpeng@dayang.com.cn");
		message.setSubject("系统自动通知邮件-视频会议提示");
		message.setText("<html><body>&nbsp&nbsp&nbsp您好！<br>"
				+"<br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp会议议题："
				+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp简要："
				+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp组织人："
				+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp于会议室  &nbsp&nbsp 开始时间：216 &nbsp&nbsp结束时间：216"
				+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp请准时与会，谢谢。"
				+"<br><br><br><br>&nbsp&nbsp&nbsp北京中科大洋电子信息平台<br><br>&nbsp&nbsp&nbsp<strong>Email:dayang_erp@dayang.com.cn</strong></body></html>");
				mailSender.send(message);*/
		MrSpOrder mrSpOrder = mrSpOrderMapper.selectLastMrSpOrder();
		String meettingName = mrSpOrder.getMeettingName();
		String meettingTitle = mrSpOrder.getMeettingTitle();
		String organization = mrSpOrder.getOrganization();
		String startDate = mrSpOrder.getStartDate();
		String endDate = mrSpOrder.getEndDate();
		String startTime = mrSpOrder.getStartTime();
		String endTime = mrSpOrder.getEndTime();
		MrMeettingRoom mrMeettingRoom = mrSpOrder.getMrMeettingRoom();
		String meetingRoomName = mrMeettingRoom.getMeetingRoomName();
		List<MrUserT> userTList = mrSpOrder.getMrUserTList();
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		for (MrUserT mrUserT : userTList) {
			String userEmail = mrUserT.getUserEmail();
			helper.setFrom("dayang_erp@dayang.com.cn");
			helper.setTo(userEmail);
			helper.setSubject("系统自动通知邮件-视频会议提示");
			helper.setText("<html><body>&nbsp&nbsp&nbsp您好！<br>"
					+"<br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp会议议题："+meettingName
					+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp简要："+meettingTitle
					+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp组织人："+organization
					+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp于"+meetingRoomName+"会议室  &nbsp&nbsp "
					+ "<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp开始时间："+startDate+"&nbsp&nbsp"+startTime
					+"<br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp结束时间："+endDate+"&nbsp&nbsp"+endTime
					+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp请准时与会，谢谢。"
					+"<br><br><br><br>&nbsp&nbsp&nbsp北京中科大洋电子信息平台<br><br>&nbsp&nbsp&nbsp<strong>Email:dayang_erp@dayang.com.cn</strong></body></html>", true);
			mailSender.send(mimeMessage);

		}
	}
	//发送会议提示邮件给管理员
		@RequestMapping(value="/mis-rest/rest/service/meettingroom/sendMaileToAdmin",method=RequestMethod.GET)
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
			helper.setSubject("系统自动通知邮件-视频会议预定提示");
			helper.setText("<html><body>&nbsp&nbsp&nbsp您好！<br>"
					+"<br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp会议议题："+meettingName
					+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp组织人："+organization
					+"<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp预定了"+meetingRoomName+"会议室  &nbsp&nbsp "
					+ "<br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp开始时间："+startDate+"&nbsp&nbsp"+startTime
					+"<br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp结束时间："+endDate+"&nbsp&nbsp"+endTime
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

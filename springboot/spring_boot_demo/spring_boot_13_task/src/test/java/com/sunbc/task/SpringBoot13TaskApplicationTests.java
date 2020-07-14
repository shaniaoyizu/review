package com.sunbc.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBoot13TaskApplicationTests {

	@Autowired
	JavaMailSenderImpl mailSender;

	@Test
	void contextLoads() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject("通知-今晚开会");
		mailMessage.setText("今晚19:00开会");
		mailMessage.setTo("13070160455@163.com");
		mailMessage.setFrom("861598189@qq.com");
		mailSender.send(mailMessage);
	}

	@Test
	public void test01() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setSubject("通知-今晚开会");
		helper.setText("<b style='color:red'>今晚19:00开会</b>",true);
		helper.setTo("13070160455@163.com");
		helper.setFrom("861598189@qq.com");
		helper.addAttachment("1.jpg",new File("C:\\Users\\sunbc\\Desktop\\1.jpg"));
		helper.addAttachment("2.jpg",new File("C:\\Users\\sunbc\\Desktop\\2.jpg"));
		mailSender.send(mimeMessage);
	}

}

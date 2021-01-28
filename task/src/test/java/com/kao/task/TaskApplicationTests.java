package com.kao.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class TaskApplicationTests {

	@Autowired
	JavaMailSenderImpl javaMailSender;

	@Test
	void contextLoads() {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setSubject("try agin");
		mail.setText("just try agin");
		mail.setTo("gustavo@gmail.com");//可以是多個
		mail.setFrom("kaoyuchun14@gmail.com");
		javaMailSender.send(mail);
	}

	@Test
	void withAnexo() throws Exception {
		MimeMessage mimeMail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMail, true);
		helper.setSubject("try agin");
		helper.setText("<b style='color:red'>today</b>",true);

		helper.setTo("gustavo@gmail.com");//可以是多個
		helper.setFrom("kaoyuchun14@gmail.com");

		//anexo
		helper.addAttachment("1.jpg", new File("C:\\User\\1.jpg"));
		helper.addAttachment("2.jpg", new File("C:\\User\\2.jpg"));
		helper.addAttachment("3.jpg", new File("C:\\User\\3.jpg"));
	}

}

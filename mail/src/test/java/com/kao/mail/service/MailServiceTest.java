package com.kao.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.mail.MessagingException;
import java.net.URL;

public class MailServiceTest extends MailApplicationTests{

    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private ApplicationContext context;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("chun@gmail.com", "this is Simple Mail", "test Simple Mail");
    }

    @Test
    public void sendHtmlMail() throws MessagingException {
        Context context = new Context();
        context.setVariable("project", "Spring Boot Demo");
        context.setVariable("author", "Gustavo");
        context.setVariable("url", "https://github.com/kao/spring-boot");

        String emailTemplate = templateEngine.process("welcome", context);
        mailService.sendHtmlMail("chun@gmail.com", "this is Html Mail", emailTemplate);
    }

    /**
     * HTML MAIL，manual
     *
     * @throws MessagingException
     */
    @Test
    public void sendHtmlMail2() throws MessagingException {

        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(context);
        templateResolver.setCacheable(false);
        templateResolver.setPrefix("classpath:/email/");
        templateResolver.setSuffix(".html");

        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("project", "Spring Boot Demo");
        context.setVariable("author", "Gustavo");
        context.setVariable("url", "https://github.com/kao/spring-boot");

        String emailTemplate = templateEngine.process("test", context);
        mailService.sendHtmlMail("chun@gmail.com", "this is Html Mail", emailTemplate);
    }

    /**
     * anexo
     *
     * @throws MessagingException
     */
    @Test
    public void sendAttachmentsMail() throws MessagingException {
        URL resource = ResourceUtil.getResource("static/xkcoding.png");
        mailService.sendAttachmentsMail("chun@gmail.com", "this is anexo mail", "it is content anexo", resource.getPath());
    }

    /**
     *静態資源
     *
     * @throws MessagingException
     */
    @Test
    public void sendResourceMail() throws MessagingException {
        String rscId = "kao";
        String content = "<html><body>this is email estavel Resource <br/><img src=\'cid:" + rscId + "\' ></body></html>";
        URL resource = ResourceUtil.getResource("static/xkcoding.png");
        mailService.sendResourceMail("237497819@qq.com", "this is Resource Mail", content, resource.getPath(), rscId);
    }
}

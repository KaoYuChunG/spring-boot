package com.kao.mail.service;

import javax.mail.MessagingException;

public interface MailService {

    /**
     * 發送文本邮件
     */
    void sendSimpleMail(String to, String subject, String content, String... cc);

    /**
     * 發送HTML邮件
     */
    void sendHtmlMail(String to, String subject, String content, String... cc) throws MessagingException;

    /**
     * 發送带附件的邮件
     *
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath, String... cc) throws MessagingException;

    /**
     * 發送正文中有静態資源的郵件
     */
    void sendResourceMail(String to, String subject, String content, String rscPath, String rscId, String... cc) throws MessagingException;
}

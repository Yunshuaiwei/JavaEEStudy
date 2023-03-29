package com.example.service.impl;

import com.example.service.SendMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/29 10:53
 */
//@Service
@Slf4j
public class SendMailServiceImpl implements SendMailService {

    //发送人
    private String from = "1779001867@qq.com";

    private String to = "ysw15129759097@163.com";

    private String subject = "测试邮件";

    private String context = "测试邮件发送正文";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail() {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        javaMailSender.send(message);
    }
}

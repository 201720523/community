package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)

public class MailTests {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail(){
        mailClient.sendMail("2167283338@qq.com","test","welcome!");
    }

    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username","houjinwei");

        String content = templateEngine.process("/mail/demo",context);
        System.out.println(content);
        mailClient.sendMail("2167283338@qq.com","html",content);
    }
}

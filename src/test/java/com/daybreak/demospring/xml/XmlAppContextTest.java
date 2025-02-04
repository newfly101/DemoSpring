package com.daybreak.demospring.xml;

import com.daybreak.demospring.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContextTest {
    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("AppConfig.xml");
        MemberService memberService = (MemberService) ac.getBean("memberService");
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}

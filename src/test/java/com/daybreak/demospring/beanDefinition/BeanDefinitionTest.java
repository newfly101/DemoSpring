package com.daybreak.demospring.beanDefinition;

import com.daybreak.demospring.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

//    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("AppConfig.xml");

    @Test
    @DisplayName("빈 설정 메타 정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String key : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(key);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + key + ",\tbeanDefinition = " + beanDefinition);
            }
        }
    }



}

package com.daybreak.demospring.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("서비스 테스트")
    void statefulServiceSingleton() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService service1 = context.getBean(StatefulService.class);
        StatefulService service2 = context.getBean(StatefulService.class);

        // threadA : A사용자 10_000원 주문
        service1.order("userA", 10_000);
        // threadA : B사용자 20_000원 주문
        service2.order("userB", 20_000);

        // threadA: 사용자A 주문 금액 조회
        int price = service1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(service1.getPrice()).isEqualTo(20_000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}

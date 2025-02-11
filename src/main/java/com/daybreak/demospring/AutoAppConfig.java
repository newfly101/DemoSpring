package com.daybreak.demospring;

import com.daybreak.demospring.member.MemberRepository;
import com.daybreak.demospring.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        basePackages = "com.daybreak.demospring.member",
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository") // 수동 빈 등록
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

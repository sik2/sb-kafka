package com.ll.sbkafka.global.initData;


import com.ll.sbkafka.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Profile("!prod")
@Configuration
@RequiredArgsConstructor
@Slf4j
public class InitData {
    private final MemberService memberService;

    @Bean
    @Order(3)
    public ApplicationRunner initDataNotProd() {
        return new ApplicationRunner() {

            @Transactional
            @Override
            public void run (ApplicationArguments args) {
                if (memberService.count() > 0)  return;
                memberService.join("user1", "1234", "유저1");
                memberService.join("user1", "1234", "유저1");
                memberService.join("user1", "1234", "유저1");
            }
        };
    }
}

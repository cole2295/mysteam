package com.akkafun.coupon.context;

import com.akkafun.common.event.EventInit;
import com.akkafun.common.event.EventRegistry;
import com.akkafun.common.scheduler.config.SchedulerConfiguration;
import com.akkafun.common.spring.BaseApplication;
import com.akkafun.coupon.event.EventHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * Created by liubin on 2016/3/28.
 */
@SpringBootApplication
@Import({BaseApplication.class, SchedulerConfiguration.class})
public class CouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class, args);
    }

    @Bean
    public EventInit eventInit() {
        EventRegistry.getInstance().clear();
        return new EventInit(new EventHandler());
    }
}
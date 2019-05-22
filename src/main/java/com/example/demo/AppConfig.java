package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FastByteArrayOutputStream;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

@Configuration
public class AppConfig {

    private static AtomicBoolean a = new AtomicBoolean(true);
    @PostConstruct
    private void start() {
        Thread q = new Thread(() -> {
            while (true) {
                try {
                    LockSupport.parkNanos(TimeUnit.NANOSECONDS.convert(5000L, TimeUnit.MILLISECONDS));
                } finally {
                    System.out.println("1111111111111111111111111111111111111111111111");
                    LockSupport.parkNanos(TimeUnit.NANOSECONDS.convert(5000L, TimeUnit.MILLISECONDS));
                    System.out.println("2222222222222222222222222222222222222");
                }
            }
        });
        q.setName(String.format("[%s-scanThread]", getClass().getSimpleName()));
        q.setDaemon(true);
        q.setPriority(Thread.MIN_PRIORITY+1);
        q.start();
    }

    @Bean
    @Scope(value = "prototype")
    public MyPrototypeBean prototypeBean() {
        MyPrototypeBean a = new MyPrototypeBean();
        System.out.println("prototypeBean " + a.getList());
        return a;
    }

    @Bean
    public MyPrototypeBean singletonBean(MyPrototypeBean prototypeBean) {
        System.out.println("HashCode singletonBean1 = " + prototypeBean.hashCode());
        prototypeBean.setList(Arrays.asList("123", "123"));
        System.out.println("List singletonBean1 = " + prototypeBean.getList());
        return prototypeBean;
    }

    @Bean
    public MyPrototypeBean singletonBean2(MyPrototypeBean prototypeBean) {
        System.out.println("HashCode singletonBean2 = " + prototypeBean.hashCode());
        prototypeBean.setList(Arrays.asList("444444", "3333"));
        System.out.println("List singletonBean2 = " + prototypeBean.getList());
        return prototypeBean;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println(Statuses.valueOf("ENABLED"));

        MyPrototypeBean bean = (MyPrototypeBean) context.getBean("singletonBean");
        MyPrototypeBean bean2 = (MyPrototypeBean) context.getBean("singletonBean2");

        System.out.println(bean.getList() + "-1 2");
        System.out.println(bean2.getList() + "-2 2");

        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));

        if (!a.getAndSet(false)) {
            System.out.println("a");
        }
        System.out.println(a.get());

    }
}

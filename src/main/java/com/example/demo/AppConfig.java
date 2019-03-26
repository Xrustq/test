package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = "prototype")
    public MyPrototypeBean prototypeBean() {
        MyPrototypeBean a = new MyPrototypeBean();
        System.out.println("prototypeBean " + a.getList());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//
//        System.out.println(Statuses.valueOf("ENABLED"));
//
//        MyPrototypeBean bean = (MyPrototypeBean) context.getBean("singletonBean");
//        MyPrototypeBean bean2 = (MyPrototypeBean) context.getBean("singletonBean2");
//
//        System.out.println(bean.getList() + "-1 2");
//        System.out.println(bean2.getList() + "-2 2");
//
//        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));

//        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
//                // date and time
//                .appendPattern()
//                // timezone short name with custom set of preferred zones
//                // create formatter (use English locale for month and day of week)
//                .toFormatter(Locale.ENGLISH);

//        String input = "Mon 14 Aug 2017 02:00 AM CEST";
//        System.out.println(ZonedDateTime.parse(input, formatter));
//
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(
                "Sat Mar 07 01:00:00 SAMT 2015", DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy"));

        Instant instant = zonedDateTime.toInstant();
        System.out.println(Date.from(instant));

        List<String> q = new ArrayList<>();
        check(null);
    }

    public static void check(List<String> s){
//        System.out.println(s.isEmpty());
        System.out.println(CollectionUtils.isEmpty(s));
    }
}

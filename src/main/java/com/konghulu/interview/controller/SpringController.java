package com.konghulu.interview.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author lining
 * @date 2018-07-29
 */
@RestController
@RequestMapping("spring")
public class SpringController implements ApplicationContextAware {

    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

    @RequestMapping("/context")
    public String applicationContext() {
        System.out.println(applicationContext.getApplicationName());
        Consumer<String> consumer = (x) -> {
            System.out.println(x);
        };
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(consumer);
        System.out.println(applicationContext.getDisplayName());
        return applicationContext.getClass().getName();
    }

}

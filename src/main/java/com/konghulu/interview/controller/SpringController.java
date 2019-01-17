package com.konghulu.interview.controller;

import com.konghulu.interview.domain.MyCondition;
import com.konghulu.interview.domain.Person;
import com.konghulu.interview.enums.LevelCategoryEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/builder", method = RequestMethod.POST)
    public String modelBuilder(@RequestBody MyCondition condition){
        System.out.println(condition.getInsurerId());
        System.out.println(condition.getClaimType());
        return "~~";
    }

    @RequestMapping(value = "/serialize")
    public Person serializeRule(){
        return Person.builder().age((byte)18).name("lining").level(LevelCategoryEnum.get(1)).id(1).build();
    }
}

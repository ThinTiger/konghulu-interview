package com.konghulu.interview.handler;

import com.konghulu.interview.domain.Person;
import com.konghulu.interview.enums.LevelCategoryEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: za-lining
 * @date: 2019/2/18
 **/
@Component
@Slf4j
public class SimpleBuilderHander extends AbstractBuilderHandler {

    @Override
    public Person builder() {
        Person person = new Person(1001, "simple", (byte)18, "tiny", LevelCategoryEnum.LOW);
        return person;
    }
}

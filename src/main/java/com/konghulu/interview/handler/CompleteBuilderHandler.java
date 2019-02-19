package com.konghulu.interview.handler;

import com.konghulu.interview.domain.Person;
import com.konghulu.interview.enums.LevelCategoryEnum;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

/**
 * @author: za-lining
 * @date: 2019/2/18
 **/
@Component
@Slf4j
public class CompleteBuilderHandler extends AbstractBuilderHandler {

    @Override
    public Person builder() {
        Person person = new Person(1002, "complete", (byte)22, "jiangjiang", LevelCategoryEnum.MID);
        return person;
    }
}

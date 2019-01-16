package com.konghulu.interview.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author: thinTiger
 * @date: 2018/12/28
 **/
@Slf4j
public class DateTests extends BaseApplicationTest {

    @Test
    public void timeZoneTest(){
        Date now = new Date();
        log.info("----now" + now);
        System.out.println(now.toGMTString());
        System.out.println(now.toLocaleString());
        System.out.println(now.getTimezoneOffset());
    }
}

package com.konghulu.interview.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 5);
        System.out.println(sdf.format(nowTime.getTime()));
    }
}

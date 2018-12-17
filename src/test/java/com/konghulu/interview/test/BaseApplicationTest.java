package com.konghulu.interview.test;

import com.konghulu.interview.annotation.AliasForTest;
import com.konghulu.interview.server.KonghuluInterviewApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: thinTiger
 * @date: 2018/12/13
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KonghuluInterviewApplication.class)
public class BaseApplicationTest {
}

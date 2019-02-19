package com.konghulu.interview.handler;

import com.konghulu.interview.domain.Person;

/**
 * builder abstract class
 * @author za-lining
 * @date: 2019/2/18
 **/
public abstract class AbstractBuilderHandler {

    /**
     * 组装
     * @return
     */
    public abstract Person builder();
}

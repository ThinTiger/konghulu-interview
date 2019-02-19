package com.konghulu.interview.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: za-lining
 * @date: 2019/2/19
 **/
@RestController
@RequestMapping("mvc")
@Slf4j
public class MvcController {

    @RequestMapping("queryFromUrl")
    public String queryFromUrl(HttpServletRequest request){
        log.debug(request.getRemoteUser());
        log.debug(request.getRequestURI());
        log.debug(request.getRemoteAddr());

        return request.getRemoteHost();
    }
}

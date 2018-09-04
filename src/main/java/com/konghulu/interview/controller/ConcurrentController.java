package com.konghulu.interview.controller;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author lining
 * @date 2018-09-04
 */
@RestController
@RequestMapping("concurrent")
public class ConcurrentController {

    private ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<>();

    @RequestMapping("/getSize")
    public String concurrentGetSize() {
	ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

	for (int i = 0; i < 100; i++) {
	    threadPoolExecutor.execute(() -> {
	        UUID currentUUID = UUID.randomUUID();
	        hashMap.put(currentUUID.toString(), 0);
	        System.out.println("uuid:" + currentUUID + ",size:" + hashMap.size());
	    });
	}
	return "";
    }
}

package com.konghulu.interview.controller;

import com.konghulu.interview.common.ThreadUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author lining
 * @date 2018-07-27
 */
@RestController
@RequestMapping("thread")
public class ThreadController {

    @RequestMapping("/callable")
    public String callable() {
	String result = null;

	Callable<String> callable = new Callable<String>() {

	    @Override
	    public String call() throws Exception {
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(5000);
		return "123";
	    }
	};
	System.out.println("outer print1!~");

	FutureTask<String> futureTask = new FutureTask<>(callable);
	ThreadUtil.execGeneralTask(futureTask);
	System.out.println("outer print2!~");
	try {
	    result = futureTask.get();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return result;
    }

    @RequestMapping("/pool")
    public String poolTask() {
	ThreadUtil.execGeneralTask(() -> {
	    System.out.println("exec one task!~");
	    System.out.println(Thread.currentThread().getName());
	}); return "done!~";
    }
}

package com.konghulu.interview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

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
	Thread thread = new Thread(futureTask);
	thread.start();
	System.out.println("outer print2!~");
	try {
	    result = futureTask.get();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return result;
    }
}

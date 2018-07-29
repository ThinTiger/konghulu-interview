package com.konghulu.interview.common;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.concurrent.*;

/**
 * @author lining
 * @date 2018-07-28
 */
public class ThreadUtil {

    private static ThreadPoolExecutor threadPoolExecutor;

    static {
	ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("general-pool-%d").build();

	threadPoolExecutor = new ThreadPoolExecutor(2, 100, 60L,
		TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), namedThreadFactory,
		new ThreadPoolExecutor.AbortPolicy());
	//threadPoolExecutor = Executors.newFixedThreadPool(10, namedThreadFactory);
    }

    public static void execGeneralTask(Runnable runnable) {
	threadPoolExecutor.execute(runnable);
    }

    public static void printQueueCount(){
	System.out.println(threadPoolExecutor.getQueue().size());
    }
}

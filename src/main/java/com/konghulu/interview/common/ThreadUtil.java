package com.konghulu.interview.common;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author lining
 * @date 2018-07-28
 */
public class ThreadUtil {

    private static ExecutorService threadPoolExecutor;

    static {
	ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("general-pool-%d").build();

	threadPoolExecutor = new ThreadPoolExecutor(1, 100, 0L,
		TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory,
		new ThreadPoolExecutor.AbortPolicy());
    }

    public static void execGeneralTask(Runnable runnable) {
	threadPoolExecutor.execute(runnable);
    }
}

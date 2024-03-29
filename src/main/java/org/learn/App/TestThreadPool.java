package org.learn.App;

import org.learn.Pool.ThreadPool;

public class TestThreadPool {
	
	public static void main(String[] args) throws InterruptedException {
		//create queue size - 3
		//Number of threads - 4
		ThreadPool threadPool = new ThreadPool(3,4);

		//Created 15 Tasks and submit to pool (actually there are 7 Tasks)
		for(int taskNumber = 1 ; taskNumber <= 7; taskNumber++) {
			TestTask task = new TestTask(taskNumber);
			threadPool.submitTask(task);
		}
		System.out.println("Main Thread execution done");
	}
}
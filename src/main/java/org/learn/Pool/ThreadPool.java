package org.learn.Pool;

import org.learn.App.TestTask;

//ThreadPool class is responsible for en-queuing task to blocking queue
public class ThreadPool {

	private BlockingQueue blockingQueue;
	
	//Constructor setting the BlockingQueue and creates numbers of TaskExecutor instances
	public ThreadPool(int taskQueueMaxSize, int numberOfThreads) {
		
		this.blockingQueue = new BlockingQueue(taskQueueMaxSize);

		for(int i = 0; i < numberOfThreads; i++) {
			
			TaskExecutor taskExecutor = new TaskExecutor(this.blockingQueue);
			Thread thread = new Thread(taskExecutor);
			thread.start();
		}
	}

	//Submit task to BlockingQueue
	public void submitTask(TestTask testTask) {
		this.blockingQueue.enQueue(testTask);
	}
}
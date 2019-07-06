package org.learn.Pool;

//TaskExecutor class is capable of executing the task
public class TaskExecutor implements Runnable{

	private BlockingQueue blockingQueue;
	
	//Setting a new TestExecutor
	public TaskExecutor(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;

	}
	
	//Get TestTask to execute
	@Override
	public void run() {
		while(true) {
		this.blockingQueue.deQueue().run();
		}

	}
}

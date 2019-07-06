package org.learn.Pool;
import java.util.LinkedList;

import org.learn.App.TestTask;;

//BlockingQueue class will be used to store TestTasks
public class BlockingQueue {
	
	private int maxQueueSize;
	private LinkedList<TestTask> blockingQueue;

	//Setting the BlockingQueue and its max size
	public BlockingQueue(int taskQueueMaxSize) {
		this.maxQueueSize = taskQueueMaxSize;
		this.blockingQueue = new LinkedList<TestTask>();
	}

	//Synchronized method for Sending a new TestTask
	public synchronized void enQueue(TestTask testTask) {
		while(this.blockingQueue.size() == this.maxQueueSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		this.blockingQueue.add(testTask);
	}

	//Synchronized method for Receiving a TestTask
	public synchronized TestTask deQueue() {
		while(this.blockingQueue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		return this.blockingQueue.remove();		
	}
}
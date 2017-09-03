package com.cyr.util.scheduler;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.Scheduler;

public class Local58Scheduler implements Scheduler{

	/**
	 * 管理要抓取的url,并且去除重复的url
	 * @see
	 * QueueScheduler继承Scheduler接口，一个简单的内存队列，速度较快，并且是线程安全的
		
		主要成员变量
		
		Logger  logger = Logger.getLogger(getClass());
		
		BlockingQueue<Request>  queue = new LinkedBlockingQueue<Request>();
		
		Set<String>  urls = new HashSet<String>();
		
		   主要方法
		
		void  push(Request request, Task task)  往queue里边添加一个request
		
		Request  poll(Task task)  从queue里边弹出一个request
	 * 
	 */
	public void push(Request request, Task task) {
		// TODO Auto-generated method stub
		
	}

	public Request poll(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

}

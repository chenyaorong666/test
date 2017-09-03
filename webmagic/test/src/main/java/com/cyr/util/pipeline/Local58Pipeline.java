package com.cyr.util.pipeline;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class Local58Pipeline implements Pipeline {

	/**
	 * 从resultItems通过get(key)得到数据
	 */
	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub

	}

	/**
	 * ConsolePipeline 实现了Pipeline接口，把结果输出到控制台
	 * 
	 * public void process(ResultItems resultItems, Task task) {
	 * 
	 * 		System.out.println("get page: " + resultItems.getRequest().getUrl());
	 * 
	 * 			for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
	 * 
	 * 				System.out.println(entry.getKey() + ":\t" + entry.getValue());
	 * 
	 * 				}
	 * 	}
	 */

	/**
	 * FilePipeline 实现了FilePersistentBase，Pipeline接口，把数据存到文件里，每个URL单独保存到一个页面，以URL的MD5结果作为文件名
	 * 
	 * 主要成员变量
	 * 
	 * 		Logger logger = Logger.getLogger(getClass());
	 * 
	 * 主要方法
	 * 
	 * 		FilePipeline() { setPath("/data/webmagic/"); } 默认构造函数 设置了存储路径
	 * 
	 * 		FilePipeline(String path) { setPath(path); } 自定义存储路径
	 * 
	 * 		void process(ResultItems resultItems, Task task)
	 */

}

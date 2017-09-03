package com.cyr.util.spider;

import java.util.ArrayList;
import java.util.List;

import com.cyr.util.downloader.Local58downloader;
import com.cyr.util.pageprocessor.Local_58processor;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class Local58Spider extends Spider{

	public Local58Spider(PageProcessor pageProcessor) {
		super(pageProcessor);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PageProcessor local58processor = new Local_58processor();
		Downloader local58downloader = new Local58downloader();
		List<String> targetRequests = new ArrayList<String>();
        for (int i = 20;i < 100; i++){
            targetRequests.add("http://www.mm131.com/xinggan/list_6_" + i+".html");
        }
		(new Local58Spider(local58processor))
		.setDownloader(local58downloader)
		.addPipeline(new FilePipeline("/data/58aaaa/"))
//		.addUrl("http://se.haoa04.com/listhtml/2.html")
		.addUrl("http://se.haoa04.com/html/114272.html")
//		.startUrls(targetRequests)
		.thread(5)
		.run();

	}

}

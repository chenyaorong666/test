package com.cyr.util.pageprocessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cyr.util.util.DownloadImage;
import com.cyr.util.util.RandomString;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class Local_58processor implements PageProcessor {

	/**
	 * 包含爬虫的一些配置 Site.me()--> return new Site(); List<Request> startRequests = new
	 * ArrayList<Request>(); 爬虫开始的url集
	 * 
	 */
	private Site site = Site.me().setRetryTimes(300).setSleepTime(2000);

	// 爬取的列表页，页数。
	private static final int PAGE_SIZE = 100;

	// 列表页正则表达式
	// private static final String REGEX_PAGE_URL = "http://bj\\.58\\.com\\hezu\\";

	private static final String REGEX_PAGE_URL = "[http]{4}\\:\\/\\/bj\\.58\\.com\\/hezu\\/";
	/**
	 * 处理Page对象，提取Url,提取数据并存储 (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#process(us.codecraft.webmagic.Page)
	 * 
	 *      webmagic主要实现了CSS Selector、XPath和正则表达式三种抓取方式，其实现放在Selector文件下 示例：
	 *      page.putField("author",
	 *      page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
	 * 
	 *      page.putField("name",
	 *      page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
	 * 
	 *      if (page.getResultItems().get("name")==null){ page.setSkip(true); }
	 *      //skip this page
	 * 
	 *      page.putField("readme",
	 *      page.getHtml().xpath("//div[@id='readme']/tidyText()"));
	 * 
	 */

	/**
	 * page.putField()： 把结果存到ResultItems的Map<String, Object> fields的键值对中 page 和
	 * resultItem中都有request, page.setRequest(request)时同时设置到page和resultitem对象的变量中
	 * 加载page对象的时候同时加载了一个ResultItem对象。 ResultItems resultItems = new ResultItems();
	 */

	// public void process(Page page) {
	// // TODO Auto-generated method stub
	// /**
	// * page.getUrl() 会把所有的url都取到，存到Selectable的 List<String> getSourceTexts();中
	// */
	//// page.putField("aa",page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
	// /**
	// * 把所有的列表页都添加到 爬取的目标URL中
	// */
	// List<String> targetRequests = new ArrayList<String>();
	// for (int i = 1;i < PAGE_SIZE; i++){
	// targetRequests.add("http://bj.58.com/chuzu/" + i);
	// }
	// page.addTargetRequests(targetRequests);
	// //用正则匹配是否是列表页
	// if (page.getUrl().regex(REGEX_PAGE_URL).match()) {
	// /**
	// * 如果是，获取 class为 lady-name 的a 标签 的所有链接(详情页)。
	// */
	// List<String> urls =
	// page.getHtml().xpath("//a[@class=\"lady-name\"]").links().all();
	// for (String url:urls) {
	// /**
	// *
	// 获取到的详情页链接，是找不到图片的URL,利用Chrome的控制台，发现数据是从https://mm.taobao.com/self/info/model_info_show.htm?user_id=46599595。下发的。
	// * 把URL替换下，添加到爬取的目标URL,中。
	// */
	// page.addTargetRequest(url.replace("self/model_card.htm","self/info/model_info_show.htm"));
	// }
	// } else {
	// // 如果不是,则
	// // 获取 class为mm-p-info-cell clearfix 的ul /li /span/文本，作为图片保存图片名。
	// String nickname = page.getHtml().xpath("//ul[@class=\"mm-p-info-cell
	// clearfix\"]/li/span/text()").toString();
	// // 获取 class为mm-p-modelCard 的div /a /img src 值，此为图片URL.
	// String imgUrl =
	// page.getHtml().xpath("//div[@class=\"mm-p-modelCard\"]/a").css("img","src").toString();
	// try {
	// // 根据图片URL 下载图片方法
	// /**
	// * String 图片URL地址
	// * String 图片名称
	// * String 保存路径
	// */
	// DownloadImage.download("http:" + imgUrl,nickname + ".jpg","F:\\image\\");
	// } catch (Exception e){
	// e.printStackTrace();
	// }
	// }
	//
	// }

	/**
	 * 获取site的设置信息
	 */
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	public void process(Page page) {

		System.out.println("----------------------"+page.getUrl());
		if (page.getUrl().regex("http://se.haoa04.com/html/[0-9]+.html").match()) {

//			List<String> detailPage = page.getHtml().xpath("//div[@class=\"content-page\"]/a/@href").all();
//			List<String> listpage1 = new ArrayList<String>();
//			for(String list:detailPage) {
//				System.out.println("detailPage = "+list);
//				if(!list.contains("mm131")) {
//					listpage1.add("http://www.mm131.com/chemo/"+list);
//				}
//			}
//			page.addTargetRequests(listpage1);
			try {
				List<String> imgUrls = page.getHtml().xpath("//div[@class=\"center margintop border clear main\"]/img/@src").all();
//				List<String> imgurls = page.getHtml().xpath("//div[@class=\"content-pic\"]/a/img/@src").all();
//				System.out.println("imgname="+imgname+"\n"+"imgurl="+imgurl);
				System.out.println("start download...." + imgUrls.size());
				for(String img:imgUrls) {
					System.out.println("img = " + img);
//					DownloadImage.download(img, RandomString.getRandomString(5) + ".jpg", "F:\\ohshit\\");
				}
				for(String img:imgUrls) {
//					System.out.println("img = " + img);
					DownloadImage.download(img, RandomString.getRandomString(5) + ".jpg", "F:\\ohshit\\");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (page.getUrl().regex("http://se.haoa04.com/listhtml/2(\\-[0-9])?.html").match()) {
			List<String> detailPage = page.getHtml().xpath("//div[@class=\"list\"]/ul/li/a/@href").all();
			page.addTargetRequests(detailPage);
			List<String> listPage = page.getHtml().xpath("//div[@class=\"page\"]/a/@href").all();
			page.addTargetRequests(listPage);
		}
		
//		// TODO Auto-generated method stub
//		// http\\:\\/\\/www\\.mm131\\.com\\/xinggan\\/[0-9]{4}\\.html
//		// String nickname = page.getHtml().xpath("//ul[@class=\"mm-p-info-cell
//		// clearfix\"]/li/span/text()").toString();
//		List<String> nicknames = page.getHtml().xpath("//dd/a/img/text()").all();
//		// 获取 class为mm-p-modelCard 的div /a /img src 值，此为图片URL.
//		// String imgUrl =
//		// page.getHtml().xpath("//ul[@id=\"housePicList\"]/li/").css("img","src").toString();
//		// http: //pic 7.58c dn.co m.cn/ p1/bi g/n_v
//		// 1bl2lwxw25xxfqgahxfda.jpg?w=696&h=522&crop=1
//		List<String> imgUrls = page.getHtml().xpath("//dd/a/img/@src").all();
//		System.out.println("nickname=" + nicknames.size());
//		System.out.println("imgUrl=" + imgUrls.size());
//
//		for (String url : page.getUrl().all()) {
//			System.out.println(url);
//		}
//		System.out.println("url is" + page.getUrl().toString());
//		for (String img : imgUrls) {
//			System.out.println(img);
//		}
//		try {
//			// 根据图片URL 下载图片方法
//			/**
//			 * String 图片URL地址 String 图片名称 String 保存路径
//			 */
//			for (int i = 1; i < imgUrls.size(); i++) {
//				String name = RandomString.getRandomString(5);
//				System.out.println("randomname=" + name);
//				DownloadImage.download(imgUrls.get(i), name + i + ".jpg", "F:\\image\\");
//			}
//			// DownloadImage.download(nickname,nickname.substring(0,2) +
//			// ".jpg","F:\\image\\");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}

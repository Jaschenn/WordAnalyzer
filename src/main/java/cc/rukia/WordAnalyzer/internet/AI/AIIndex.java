package cc.rukia.WordAnalyzer.internet.AI;

import java.util.List;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

//consolePipeline
//http://www.elecfans.com/rengongzhineng/1064_2.html
@Gecco(matchUrl="http://www.elecfans.com/rengongzhineng/1064_{page}.html", pipelines="AIPagePipeline")
public class AIIndex implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//div.article-list:nth-child(7) > div:nth-child(2) > h3:nth-child(1)
	@Request
	private HttpRequest request;
	
	//网络地址
	@Href(value="href")
	@HtmlField(cssPath="div.article-list div h3 a")
	private List<String> contentUrl;
	
	//链接名称
	@HtmlField(cssPath="div.article-list div h3 a")
	private List<String> contentName;

	@Href(value="href")
	@HtmlField(cssPath="div.pagn1 a:last-child")
	private String nextUrl;

	public HttpRequest getRequest() {
		return request;
	}


	public List<String> getContentUrl() {
		return contentUrl;
	}


	public String getNextUrl() {
		return nextUrl;
	}


	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}


	public List<String> getContentName() {
		return contentName;
	}


	public void setRequest(HttpRequest request) {
		this.request = request;
	}


	public void setContentUrl(List<String> contentUrl) {
		this.contentUrl = contentUrl;
	}


	public void setContentName(List<String> contentName) {
		this.contentName = contentName;
	}

}

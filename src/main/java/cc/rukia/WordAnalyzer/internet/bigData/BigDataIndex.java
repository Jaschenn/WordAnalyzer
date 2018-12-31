package cc.rukia.WordAnalyzer.internet.bigData;

import java.util.List;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

//li.am-g:nth-child(5) > div:nth-child(2) > p:nth-child(1) > a:nth-child(1)
@Gecco(matchUrl="http://www.cbdio.com/{index}.html", pipelines="PagePipeline")
public class BigDataIndex implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Request
	private HttpRequest request;
	
	@Href(value="href")
	@HtmlField(cssPath="p.cb-media-title a")
	private List<String> contentUrl;
	
	@HtmlField(cssPath="p.cb-media-title a")
	private List<String> contentName;


	@HtmlField(cssPath="a.page-num:nth-child(5)")
	private String number;
	


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public HttpRequest getRequest() {
		return request;
	}


	public List<String> getContentUrl() {
		return contentUrl;
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

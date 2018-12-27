package cc.rukia.WordAnalyzer.People;

import java.util.List;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
@Gecco(matchUrl="http://it.people.com.cn/{index}.html", pipelines="pagePipeline1")
public class peopleIndex implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpRequest request;
	//
	//div.hdNews:nth-child(1) > p:nth-child(1) > strong:nth-child(1) > a:nth-child(1)
	@Href(click=true)
	@HtmlField(cssPath="div.hdNews > p > strong > a")
	private List<String> nameList;   //得到的是网络地址
	
	
	@Text
	@HtmlField(cssPath="div.hdNews > p > strong > a")
	private List<String>idList;     //得到的名称
	
	
	//页码的css.page_n
	@Text
	@HtmlField(cssPath=".page_n a")
	private List<String> pageNameList;
	
	
	@Href(click=true)
	@HtmlField(cssPath=".page_n a")
	private List<String> pageUrlList;   //得到的是网络地址
	
	

	public List<String> getPageNameList() {
		return pageNameList;
	}
	public List<String> getPageUrlList() {
		return pageUrlList;
	}
	public void setPageNameList(List<String> pageNameList) {
		this.pageNameList = pageNameList;
	}
	public void setPageUrlList(List<String> pageUrlList) {
		this.pageUrlList = pageUrlList;
	}


	public List<String> getIdList() {
		return idList;
	}
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	public HttpRequest getRequest() {
		return request;
	}
	public List<String> getNameList() {
		return nameList;
	}
	
	
	public void setRequest(HttpRequest request) {
		this.request = request;
	}
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
	

}

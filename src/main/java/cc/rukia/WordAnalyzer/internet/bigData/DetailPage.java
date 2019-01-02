package cc.rukia.WordAnalyzer.internet.bigData;

import java.util.List;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import cc.rukia.WordAnalyzer.internet.AbstractArticle;

//http://www.cbdio.com/BigData/2018-12/24/content_5964043.htm
@Gecco(matchUrl="http://www.cbdio.com/BigData/{year}/{day}/{index}.htm", pipelines="to_DB_Pipeline")
public class DetailPage extends AbstractArticle implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Request
	private HttpRequest request;
	
	//cb-article
	@HtmlField(cssPath="div.cb-article h1")
	private String title;
	
	@Text
	@HtmlField(cssPath="div.cb-article p")
	private List<String> content;

	public HttpRequest getRequest() {
		return request;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getContent() {
		return content;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}
	
}

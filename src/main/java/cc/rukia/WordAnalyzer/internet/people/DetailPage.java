package cc.rukia.WordAnalyzer.internet.people;

import java.util.List;

import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
//http://it.people.com.cn/n1/2018/1227/c1009-30490112.html
@Gecco(matchUrl="http://it.people.com.cn/n1/{year}/{month}/{id}.html", pipelines="DetatilPipeline")
public class DetailPage extends AbstractArticle implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Request
	private HttpRequest request;
	
	
	//div.w1000_320:nth-child(8) > h1:nth-child(2)div.w1000_320:nth-child(8)
	@HtmlField(cssPath="div.w1000_320 h1")
	private String title;
	
	

	@Text
	@HtmlField(cssPath="div.box_con p")
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

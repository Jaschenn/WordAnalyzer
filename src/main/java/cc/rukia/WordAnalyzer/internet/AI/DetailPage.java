package cc.rukia.WordAnalyzer.internet.AI;

import java.util.List;
 
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import cc.rukia.WordAnalyzer.internet.people.AbstractArticle;

//http://www.elecfans.com/emb/dsp/20181226840256.html
@Gecco(matchUrl="http://www.elecfans.com/rengongzhineng/8{index}.html", pipelines="to_DB_Pipeline")
public class DetailPage extends AbstractArticle implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Request
	private HttpRequest request;
	
	//cb-article
	@HtmlField(cssPath=".article-title")
	private String title;
	
	
	//.simditor-body
	@Text
	@HtmlField(cssPath="div.simditor-body p")
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

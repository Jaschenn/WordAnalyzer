package cc.rukia.WordAnalyzer.util.explUtil;

import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;
@Gecco(matchUrl = "https://baike.baidu.com/item/{title}/{number}",pipelines = "wordExplaination")
public class WordExplaination extends AbstractArticle implements HtmlBean {
    private static final long serialVersionUID = 111213765435676532L;
    @Request
    private HttpRequest httpRequest;
    @RequestParameter
    private String title;
    @HtmlField(cssPath = "div.lemma-summary div ")
    private List<String> content;
    public String getTitle() {
        return title;
    }

    public void setTitle(String wordName) {
        this.title = wordName;
    }

    @Override
    public List<String> getContent() {
        return content;
    }

    @Override
    public void setContent(List<String> content) {
        this.content = content;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }
}

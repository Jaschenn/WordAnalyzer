package cc.rukia.WordAnalyzer.ansj;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "https://baike.baidu.com/item/{name}",pipelines = "consolePipeline")
public class Expression implements HtmlBean {
    private static final long serialVersionUID = -3770531202833832223L;
    @Request
    private HttpRequest request;
    @RequestParameter
    private String name;
    @HtmlField(cssPath = "body > div.body-wrapper > div.content-wrapper > div > div.main-content > dl.lemmaWgt-lemmaTitle.lemmaWgt-lemmaTitle- > dd > h1")
    private String title;
    @HtmlField(cssPath = "body > div.body-wrapper > div.content-wrapper > div > div.main-content > div.lemma-summary")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String text) {
        this.content = text;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }
}

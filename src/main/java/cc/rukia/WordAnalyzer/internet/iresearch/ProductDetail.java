package cc.rukia.WordAnalyzer.internet.iresearch;

import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * Created by jackie on 18/1/15.
 */
@Gecco(matchUrl="http://news.iresearch.cn/content/{date}/{code}.shtml", pipelines={"consolePipeline", "to_DB_Pipeline"})
public class ProductDetail extends AbstractArticle implements HtmlBean {

    private static final long serialVersionUID = -377053120283382723L;

    /**
     * 文本内容
     */
    @Request
    private HttpRequest request;

    @HtmlField(cssPath="body > div.g-content > div.g-bd.f-mt-auto > div > div.g-mn > div > div.g-article > div.m-article p")
    private List<String> content;

    @RequestParameter
    private String code;

    @RequestParameter
    private String date;

    /**
     * 标题
     */
    @Text
    @HtmlField(cssPath="body > div.g-content > div.g-main.f-mt-auto > div > div > div.title > h1")
    private String title;

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

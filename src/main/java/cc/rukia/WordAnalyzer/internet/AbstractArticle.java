package cc.rukia.WordAnalyzer.internet;

import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

public abstract class AbstractArticle implements HtmlBean {
    protected String title;
    protected List<String> content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}

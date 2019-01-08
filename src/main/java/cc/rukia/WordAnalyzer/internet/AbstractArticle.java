package cc.rukia.WordAnalyzer.internet;

import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractArticle implements HtmlBean {
    protected String title;
    protected List<String> content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.replaceAll("&nbsp","");
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {

        this.content = new ArrayList<>();
        for (String para:content
             ) {
            if(!"".equals(para)){
                this.content.add(para.trim().replaceAll("&nbsp","").replaceAll("\t","").replaceAll("　　",""));
            }
        }
    }

    @Override
    public String toString() {
        return "AbstractArticle{" +
                "title='" + title + '\'' +
                ", content=" + content +
                '}';
    }
}

package cc.rukia.WordAnalyzer.util.explUtil;

import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;
@PipelineName(value = "wordExplaination")
public class ExplainUtil implements Pipeline<AbstractArticle> {
    String expl = "等待爬取";
    private static final long serialVersionUID = 111213765435676532L;
    @Override
    public void process(AbstractArticle abstractArticle) {
        System.out.println("开始进行process");
        this.expl = abstractArticle.getContent().toString();
        System.out.println(this.expl);
    }
}

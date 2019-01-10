package cc.rukia.WordAnalyzer.ansj;

import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import cc.rukia.WordAnalyzer.util.GetArticle;
import cc.rukia.WordAnalyzer.util.explUtil.ExplainUtil;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AnsjProcess {
@Test
    public void process(){
//        String top1 = ((List<Keyword>) keywords).get(0).getName();
//        HttpRequest httpRequest = productDetail.getRequest();
//        httpRequest.setCharset("UTF-8");
//        SchedulerContext.into(httpRequest.subRequest("https://baike.baidu.com/search/word?word="+top1));KeyWordComputer keyWordComputer = new KeyWordComputer(6);
//        Collection<Keyword> keywords = keyWordComputer.computeArticleTfidf(productDetail.getTitle(),productDetail.getContent());
//        System.out.println(keywords);
        File file = new File("0110result.txt");
        List<AbstractArticle> articles = GetArticle.getArticles("0110result.txt",'@');
    for (AbstractArticle a:articles
         ) {
        KeyWordComputer keyWordComputer = new KeyWordComputer(a.getContent().toString().length()/100);
        Collection<Keyword> keywords = keyWordComputer.computeArticleTfidf(a.getTitle(),a.getContent().toString());
        System.out.println(keywords);
        for (Keyword k:keywords
             ) {
            ExplainUtil.getExplain(k.getName());
        }
    }
    }
}

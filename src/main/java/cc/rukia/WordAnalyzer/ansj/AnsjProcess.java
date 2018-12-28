package cc.rukia.WordAnalyzer.ansj;

import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AnsjProcess {
    public void process(){
//        String top1 = ((List<Keyword>) keywords).get(0).getName();
//        HttpRequest httpRequest = productDetail.getRequest();
//        httpRequest.setCharset("UTF-8");
//        SchedulerContext.into(httpRequest.subRequest("https://baike.baidu.com/search/word?word="+top1));KeyWordComputer keyWordComputer = new KeyWordComputer(6);
//        Collection<Keyword> keywords = keyWordComputer.computeArticleTfidf(productDetail.getTitle(),productDetail.getContent());
//        System.out.println(keywords);
        File file = new File("result.txt");
        List<String> lines = new ArrayList<String>();
        try {
            lines = FileUtils.readLines(file,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        if (lines.size()!=0){
            Iterator iterator = lines.iterator();
            while (iterator.hasNext()){
                String title = (String) iterator.next();
                String content = (String) iterator.next();
                KeyWordComputer keyWordComputer = new KeyWordComputer(content.length()/100);
                Collection<Keyword> keywords = keyWordComputer.computeArticleTfidf(title,content);
                System.out.println(keywords);
            }
        }

    }
}

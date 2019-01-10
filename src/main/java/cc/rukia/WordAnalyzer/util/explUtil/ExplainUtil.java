package cc.rukia.WordAnalyzer.util.explUtil;

import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import cc.rukia.WordAnalyzer.util.RedisUtil;
import cc.rukia.WordAnalyzer.util.RegrexUtil;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import redis.clients.jedis.Jedis;

import java.util.List;
@PipelineName(value = "wordExplaination")
public class ExplainUtil implements Pipeline<AbstractArticle> {
    private static final long serialVersionUID = 134534324442234L;
    /*
    *  在这里进行数据库的操作，存到数据库中。然后再HanLP中调用这里的方式。
    *
    * */
    @Override
    public void process(AbstractArticle abstractArticle) {
        System.out.println("开始进行process");
        System.out.println(RegrexUtil.removeASup(abstractArticle.getContent()));
        //ToDo 数据库持久化
        Jedis jedis = RedisUtil.getJedis();
        jedis.set(abstractArticle.getTitle(),RegrexUtil.removeASup(abstractArticle.getContent()));

    }
    /**
     * @param wordName:传入的单词名称
     *
     * */
    public static void getExplain(String wordName){
        GeccoEngine.create()
                .start(new HttpGetRequest("https://baike.baidu.com/search/word?word="+wordName))
                .classpath("cc.rukia.WordAnalyzer.util.explUtil")
                .loop(false)
                .run();
    }
    public static void getExplain(List<String> wordList){
        for (String word:wordList
             ) {
            ExplainUtil.getExplain(word);
        }
    }
}

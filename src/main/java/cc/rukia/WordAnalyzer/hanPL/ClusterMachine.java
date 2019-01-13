package cc.rukia.WordAnalyzer.hanPL;

import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import cc.rukia.WordAnalyzer.util.GetArticle;
import cc.rukia.WordAnalyzer.util.RedisUtil;
import cc.rukia.WordAnalyzer.util.explUtil.ExplainUtil;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.mining.cluster.ClusterAnalyzer;
import com.hankcs.hanlp.mining.word.WordInfo;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ClusterMachine {
    /**
     * 对文章进行聚类，相似的文章在一个set中，然后针对每一类别的文章，提取关键字。
     *
     * */
    @Test
    public void process(){
        ClusterAnalyzer analyzer  = new ClusterAnalyzer();
        AbstractArticle article = new HanArticle();
        List lines = null;
        try {
            lines = FileUtils.readLines(new File("0110result.txt"),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<AbstractArticle> articles = GetArticle.getArticles("0110result.txt",'@');
        HashMap<String,List> articleMap = new HashMap<>();
        for (AbstractArticle a:articles
             ) {
            analyzer.addDocument(a.getTitle(),a.getTitle()+a.getContent());//暂时名称是id
            articleMap.put(a.getTitle(),a.getContent());
        }
        List<Set<String>> list = analyzer.repeatedBisection(2.0);//指定最小阀值
        for (Set<String> set:list
        ) {
            System.out.println("###类别###");
            System.out.println("主题词------->"+HanLP.extractKeyword(set.toString(),1));
            for (String a:set
                 ) {//HanLp分词，参数分别为 文章，大小，是否只要新词
                System.out.println(a);
                //发现新词，然后从百度百科爬取解释
                List<WordInfo> list1 = HanLP.extractWords(a+articleMap.get(a).toString(),5,true);
                System.out.println(list1);
                for (WordInfo w:list1
                     ) {
                    ExplainUtil.getExplain(w.toString());
                }

            }
        }
    }
}

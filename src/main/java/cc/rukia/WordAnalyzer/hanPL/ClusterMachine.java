package cc.rukia.WordAnalyzer.hanPL;

import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import cc.rukia.WordAnalyzer.util.GetArticle;
import cc.rukia.WordAnalyzer.util.RedisUtil;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.mining.cluster.ClusterAnalyzer;
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
        Jedis jedis = RedisUtil.getJedis();
        try {
            lines = FileUtils.readLines(new File("result.txt"),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<AbstractArticle> articles = GetArticle.getArticles("result.txt",'@');
        HashMap<String,List> articleMap = new HashMap<>();
        for (AbstractArticle a:articles
             ) {
            analyzer.addDocument(a.getTitle(),a.getTitle()+a.getContent());//暂时名称是id
            articleMap.put(a.getTitle(),a.getContent());
        }
        List<Set<String>> list = analyzer.repeatedBisection(3);
        for (Set<String> set:list
        ) {
            System.out.println("###类别###");
            for (String a:set
                 ) {
                List list1 = HanLP.extractWords(a+articleMap.get(a).toString(),3,true);
                //  ToDo 增加对数据库的写入
            }
        }
    }
}

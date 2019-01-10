import cc.rukia.WordAnalyzer.hanPL.HanArticle;
import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import cc.rukia.WordAnalyzer.util.GetArticle;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.document.sentence.Sentence;
import com.hankcs.hanlp.corpus.document.sentence.word.Word;
import com.hankcs.hanlp.mining.cluster.ClusterAnalyzer;
import com.hankcs.hanlp.mining.word.WordInfo;
import com.hankcs.hanlp.model.perceptron.CWSTrainer;
import com.hankcs.hanlp.model.perceptron.PerceptronLexicalAnalyzer;
import com.hankcs.hanlp.model.perceptron.PerceptronTrainer;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.nlpcn.commons.lang.tire.domain.Forest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HanLpTest {
    @Test
    public void HanLPTest() throws IOException {
        String content = "据国外媒体报道，Facebook 的 20 亿用户中，绝大多数人不清楚 Facebook 有多少服务在多大程度上依靠人工智能来运作。更没多少人知道，在庞大的 Facebook 帝国，机器学习占有多大的分量。今天，我们翻译了 Hazelwood 等人撰写的文章，从数据中心基础设施的角度，来窥视在 Facebook 内部的机器学习应用的情况。希望这篇文章能够起到管中窥豹、抛砖引玉的作用。";
        PerceptronLexicalAnalyzer analyzer = new PerceptronLexicalAnalyzer("data/model/perceptron/pku199801/cws.bin",
                "data/model/perceptron/pku199801/pos.bin",
                "data/model/perceptron/pku199801/ner.bin");
//        System.out.println("[==普通分词==]"+HanLP.segment(content));
//        System.out.println("[==感知机分词==]"+analyzer.analyze(content));
//        System.out.println("【ansj NLP分词】"+NlpAnalysis.parse(content));
        System.out.println(HanLP.extractWords(content,3,true));

    }
    @Test
    public void trainTest() throws IOException {
        PerceptronTrainer trainer = new CWSTrainer();
        PerceptronTrainer.Result result = trainer.train("/Users/jasc/Documents/GitHub/WordAnalyzer/src/main/resources/dict.txt", HanLP.Config.PerceptronCWSModelPath);
        System.out.printf("准确率F1:%.2f\n", result.getAccuracy());


    }
    @Test
    public void extractWordsTest() throws Exception{
        List<AbstractArticle> articles = GetArticle.getArticles("0110result.txt",'@');
        Segment segment = HanLP.newSegment("crf");
        List<WordInfo> words = new ArrayList<>();
        HashMap hashMap = new HashMap();
        for (AbstractArticle article:articles
             ) {
            words = HanLP.extractWords(article.getTitle()+article.getContent(),1,true);
            System.out.println("新词----"+words);
            System.out.println("总结-----"+HanLP.extractSummary(article.getTitle()+article.getContent(),1));
            System.out.println("关键词----"+HanLP.extractKeyword(article.getTitle()+article.getContent(),1));
            System.out.println("#######################");
            //统计词频来区分的方式不可取
//            for (WordInfo w:words
//            ) {
//                if(!hashMap.containsKey(w.text)){
//                    hashMap.put(w.text,1);
//                }else {
//                    hashMap.put(w.text,(Integer)hashMap.get(w.text)+1);
//                }
//            }
        }
//        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(hashMap.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return (o2.getValue() - o1.getValue());
//            }
//        });
//        for(Map.Entry<String, Integer> t:list){
//            System.out.println(t.getKey()+":"+t.getValue());
//        }

    }
    @Test
    public void clusterAnalyzerTest() throws IOException {//聚类
        ClusterAnalyzer<String> analyzer = new ClusterAnalyzer<>();
        AbstractArticle article = new HanArticle();
        List<AbstractArticle> articles = GetArticle.getArticles("0110result.txt",'@');
        for (AbstractArticle a :
                articles) {
            analyzer.addDocument(a.getTitle(),a.getContent());
        }
        List<Set<String>> middleResult = analyzer.repeatedBisection(2);
        for (Set<String> set:middleResult
             ) {
             //此时每个set是一类文章。
            System.out.println("####类别####");
            for (String s:
                 set) {
                System.out.println(s);
            }

        }

    }
}

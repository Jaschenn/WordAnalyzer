import cc.rukia.WordAnalyzer.ansj.Word;
import cc.rukia.WordAnalyzer.util.SortUtil;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.dic.LearnTool;
import org.ansj.domain.Nature;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.recognition.Recognition;
import org.ansj.recognition.impl.StopRecognition;
import org.ansj.splitWord.analysis.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.nlpcn.commons.lang.tire.domain.Forest;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AnsjTest {
    @Test
    public void WordTest() {
        File file = new File("0108result.txt");
        List<String> lines = new ArrayList<String>();
        try {
            lines = FileUtils.readLines(file, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        if (lines.size() != 0) {
            Iterator iterator = lines.iterator();
            while (iterator.hasNext()) {
                String title = (String) iterator.next();
                String content = (String) iterator.next();
                KeyWordComputer keyWordComputer = new KeyWordComputer(content.length() / 100);
                Collection<Keyword> keywords = keyWordComputer.computeArticleTfidf(title, content);
                for (Keyword k : keywords
                ) {
                    System.out.println(k);
                    Word word = new Word(k.getName());
                    if(hashMap.containsKey(word.getName())){
                        int fre = (Integer) (hashMap.get(word.getName()));
                        hashMap.put(word.getName(),fre+1);
                    }else {
                        hashMap.put(word.getName(),1);
                    }

                }

            }
            StopRecognition filter = new StopRecognition();

        HashMap hashMap1 = (HashMap) SortUtil.sortByValue(hashMap);
        System.out.println(hashMap1);
        }
    }//测试添加了dic没有stopLibrary时候的准确度
    @Test
    public void LearnToolTest() throws IOException {
        // 构建一个新词学习的工具类。这个对象。保存了所有分词中出现的新词。出现次数越多。相对权重越大。
        LearnTool learnTool = new LearnTool();

        NlpAnalysis nlpAnalysis = new NlpAnalysis().setLearnTool(learnTool) ;

        // 进行词语分词。也就是nlp方式分词，这里可以分多篇文章
        StopRecognition stopRecognition = new StopRecognition();
        stopRecognition.insertStopNatures("nr");
        stopRecognition.insertStopNatures("nt");
        List<String> lines = FileUtils.readLines(new File("0108result.txt"),"utf-8");

        System.out.println(nlpAnalysis.parseStr("大数据是一门新技术，和云计算一样，还有区块链。这三种新技术对于数字经济和智慧城市来说都非常重要。").recognition(stopRecognition));


        // 取得学习到的topn新词,返回前10个。这里如果设置为0则返回全部
        System.out.println(learnTool.getTopTree(5));

        // 只取得词性为Nature.NR的新词
        System.out.println(learnTool.getTopTree(0, Nature.NW));//效果比较好
    }//学习新词的测试

    @Test
    public void dicTest() throws Exception {
        //DicLibrary.insert(DicLibrary.DEFAULT, "半监督学习", "n", 1000);
        StopRecognition filter = new StopRecognition();
        List<String> lines = FileUtils.readLines(new File("stopLibrary.dic"),"utf-8");
        filter.insertStopWords(lines);
        String text = "半监督学习是一种智能的学习方案，不然是什么呢？";
        Result result = NlpAnalysis.parse(text).recognition(filter);
        System.out.println(result);

    }//停用词插入测试

    @Test
    public void insertTest() {
        DicLibrary.insert(DicLibrary.DEFAULT, "增加新词", "我是词性", 1000);
        Result parse = DicAnalysis.parse("这是用户自定义词典增加新词的例子");
        System.out.println(parse);
        boolean flag = false;
        for (Term term : parse) {
            flag = flag || "增加新词".equals(term.getName());
        }
        Assert.assertTrue(flag);
    }//dic插入测试

    @Test
    public void StopLibraryTest() throws IOException {
        List<String> lines = FileUtils.readLines(new File("src/main/resources/stopLibrary.dic"),"utf-8");
        StopRecognition stopRecognition = new StopRecognition();
        stopRecognition.insertStopWords(lines);//加载停用词
        stopRecognition.insertStopNatures("m");
        stopRecognition.insertStopNatures("v");
        stopRecognition.insertStopNatures("d");
        List<String> file = FileUtils.readLines(new File("0108result.txt"),"utf-8");
        for (String s:file
             ) {
            Result result = NlpAnalysis.parse(s).recognition(stopRecognition);
            FileUtils.write(new File("wordResult.txt"),result.toStringWithOutNature(" "),"utf-8",true);
            FileUtils.write(new File("wordResult.txt"),"\n","utf-8",true);

        }
    }


}
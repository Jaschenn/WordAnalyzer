import cc.rukia.WordAnalyzer.ansj.Word;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.dic.LearnTool;
import org.ansj.domain.Nature;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.nlpcn.commons.lang.tire.domain.Forest;

import java.io.File;
import java.util.*;

public class AnsjTest {
    @Test
    public void WordTest() {
        File file = new File("result.txt");
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
        System.out.println(hashMap);
        }
    }
    @Test
    public void LearnToolTest(){
        LearnTool learnTool = new LearnTool();
        Forest forest = new Forest();
        NlpAnalysis nlpAnalysis = new NlpAnalysis().setLearnTool(learnTool);
        nlpAnalysis.parseStr("说过，社交软件也是打着沟通的平台，让无数寂寞男女有了肉体与精神的寄托。");
        nlpAnalysis.parseStr("其实可以打着这个需求点去运作的互联网公司不应只是社交类软件与可穿戴设备，还有携程网，去哪儿网等等，订房订酒店多好的寓意");
        nlpAnalysis.parseStr("张艺谋的卡宴，马明哲的戏");
        System.out.println(learnTool.getTopTree(10));
        //只取得词性为Nature.NR的新词
        System.out.println(learnTool.getTopTree(10, Nature.NR));
    }
}
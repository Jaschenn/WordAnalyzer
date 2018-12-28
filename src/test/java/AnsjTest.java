import cc.rukia.WordAnalyzer.ansj.Word;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

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
}
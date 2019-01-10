import cc.rukia.WordAnalyzer.hanPL.HanArticle;
import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import cc.rukia.WordAnalyzer.util.GetArticle;
import cc.rukia.WordAnalyzer.util.explUtil.ExplainUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {
    String wordName;
    List<String> wordList = new ArrayList<>();
    @Test
    public void getArticle(){
        List<AbstractArticle> list = GetArticle.getArticles("0110result.txt",'@');
        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());
        System.out.println(list.get(2).toString());
        System.out.println(list.get(3).toString());
        System.out.println(list.get(4).toString());
    }
    @Before
    public void setWordName(){
         wordName = "人工智能";
         wordList.add("人工智能");
         wordList.add("大数据");
         wordList.add("区块链");
         wordList.add("数字经济");
    }

    @Test
    public void getExplainTest(){
        ExplainUtil.getExplain(wordName);
        ExplainUtil.getExplain(wordList);
    }
}

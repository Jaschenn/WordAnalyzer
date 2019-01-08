import cc.rukia.WordAnalyzer.hanPL.HanArticle;
import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import cc.rukia.WordAnalyzer.util.GetArticle;
import org.junit.Test;

import java.util.List;

public class UtilTest {
    @Test
    public void getArticle(){
        List<AbstractArticle> list = GetArticle.getArticles("result.txt",'@');
        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());
        System.out.println(list.get(2).toString());
        System.out.println(list.get(3).toString());
        System.out.println(list.get(4).toString());
    }
}

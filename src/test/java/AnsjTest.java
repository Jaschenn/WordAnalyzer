import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Test;

public class AnsjTest {
    @Test
    public void WordTest(){
        String str = "马云 数字经济的创新者" ;
        System.out.println(NlpAnalysis.parse(str));
        //Nlp分词发可以发现新的单词，并且分词较准确。速度在40w/s
    }
}

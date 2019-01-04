import cc.rukia.WordAnalyzer.util.explUtil.ExplainUtil;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.request.HttpGetRequest;
import org.junit.Test;

public class ExplainToolTest {
    @Test
    public void getExplanationFromBaidu() {
        HttpGetRequest httpRequest = new HttpGetRequest("https://baike.baidu.com/search/word?word="+"算法");
        httpRequest.setCharset("utf-8");
        GeccoEngine.create()
                .classpath("cc.rukia.WordAnalyzer.util.explUtil")
                .debug(true)
                .start(httpRequest)
                .thread(1)
                .interval(100)
                .loop(false)
                .run();
    }
}

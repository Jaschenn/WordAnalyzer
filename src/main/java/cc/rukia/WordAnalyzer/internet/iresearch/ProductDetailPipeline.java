package cc.rukia.WordAnalyzer.internet.iresearch;

import cc.rukia.WordAnalyzer.util.RegrexUtil;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.NlpAnalysis;

import java.util.Collection;
import java.util.List;

/**
 * Created by jackie on 18/1/15.
 */
@PipelineName("productDetailPipeline")
public class ProductDetailPipeline  implements Pipeline<ProductDetail> {

    public void process(ProductDetail productDetail) {
//        System.out.println("~~~~~~~~~productDetailPipeline~~~~~~~~~~~");
//        File resultFile = new File("result.txt");
//        if (!resultFile.exists()) {
//            try {
//                resultFile.createNewFile();
//            } catch (IOException e) {
//                System.out.println("create result file failed: " + e);
//            }
//        }
//
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter("result.txt", true);
//        } catch (IOException e) {
//            System.out.println("IOException");
//        }
//
//        try {
//            fileWriter.write(RegrexUtil.match(productDetail.getContent()));
//            fileWriter.flush();
//        } catch (IOException e) {
//            System.out.println("fileWriter.write failed: " + e);
//        } finally {
//            try {
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println("fileWriter.close failed");
//            }
//        }
        System.out.println("======================");
        System.out.println(productDetail.getTitle());
        System.out.println("----------------------");
        System.out.println("统计结果：");
        Result result = NlpAnalysis.parse(RegrexUtil.match(productDetail.getContent()));
        KeyWordComputer keyWordComputer = new KeyWordComputer(6);
        Collection<Keyword> keywords = keyWordComputer.computeArticleTfidf(productDetail.getTitle(),productDetail.getContent());
        System.out.println(keywords);
    }
}

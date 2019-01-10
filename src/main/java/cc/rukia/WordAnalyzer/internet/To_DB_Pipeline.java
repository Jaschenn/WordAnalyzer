package cc.rukia.WordAnalyzer.internet;

import cc.rukia.WordAnalyzer.util.RegrexUtil;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@PipelineName("to_DB_Pipeline")
public class To_DB_Pipeline implements Pipeline<AbstractArticle> {
    public void process(AbstractArticle abstractArticle) {
        /*
        * 暂时写到的文件中，分词的时候只需要读取文件的内容就可以，减少数据库中数据的冗余量。
        * 采取xml格式的？还是采取txt？ 暂时txt
        * */
        File file = new File("0110result.txt");

        /**
         * 文档格式：@[标题]
         *          内容
         *
         * */
        try {
            FileUtils.writeStringToFile(file,"@["+abstractArticle.getTitle()+"]"+"\n","utf-8",true);
            FileUtils.writeLines(file,abstractArticle.getContent(),true);
            FileUtils.writeStringToFile(file,"\n",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

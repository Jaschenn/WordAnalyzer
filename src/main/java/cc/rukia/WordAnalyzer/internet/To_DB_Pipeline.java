package cc.rukia.WordAnalyzer.internet;

import cc.rukia.WordAnalyzer.util.RegrexUtil;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

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
        File resultFile = new File("result.txt");
        if (!resultFile.exists()) {
            try {
                resultFile.createNewFile();
            } catch (IOException e) {
                System.out.println("create result file failed: " + e);
            }
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("result.txt", true);
        } catch (IOException e) {
            System.out.println("IOException");
        }

        try {
            fileWriter.write(abstractArticle.getTitle());
            fileWriter.write("\r\n");
            fileWriter.write((abstractArticle.getContent()).toString());
            fileWriter.write("\r\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("fileWriter.write failed: " + e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("fileWriter.close failed");
            }
        }
    }
}

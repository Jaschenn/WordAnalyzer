package cc.rukia.WordAnalyzer.util;

import cc.rukia.WordAnalyzer.hanPL.HanArticle;
import cc.rukia.WordAnalyzer.internet.AbstractArticle;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetArticle {
    /*
     * DO NOT TOUCH THIS CODE!
     *
     * */
    public static List<AbstractArticle> getArticles(String filepath,char c){
        List<AbstractArticle> articles = new ArrayList<>();
        List<String> paras = new ArrayList<>();
        AbstractArticle article = new HanArticle();
        boolean flag = false;
        try {
            List<String> lines = FileUtils.readLines(new File(filepath),"utf-8");
            for (String line:lines
                 ) {
                if(!"".equals(line)) {
                    if (line.charAt(0) == c) {
                        if(flag == true){
                            article.setContent(paras);
                            articles.add(article);
                            article = new HanArticle();
                            paras = new ArrayList<>();
                            flag = false;
                        }
                        article.setTitle(line.replaceAll("\\[","").replaceAll("\\]","").replaceAll("@",""));
                        flag = true;
                    } else {
                        paras.add(line.trim());
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articles;
    }
}

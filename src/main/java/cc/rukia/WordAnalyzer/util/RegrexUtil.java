package cc.rukia.WordAnalyzer.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jackie on 18/1/16.
 */
public class RegrexUtil {
    static StringBuilder stringBuilder = new StringBuilder();
    static Pattern pattern;
    static String a1 = "<a[^>]*>";//去除a标签
    static String a2 = "</a>";
    static String sup = "<sup[^>]+>([^<]+)</sup>";//去除sup标签
    public static String match(String content) {//只保留中文
        pattern= Pattern.compile("([\\u4e00-\\u9fa5]+)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            stringBuilder.append(matcher.group(0));
        }
        return stringBuilder.toString();
    }
    public static String removeASup(String content){

        content = content.replaceAll(a1,"").replaceAll(a2,"");
        content = content.replaceAll(sup,"").replaceAll("&nbsp|&nbsp;\r|\n|\\s","");
        return content;
    }
    public static String removeASup(List<String> contents){
        String content="";
        for (String line:contents
             ) {
            content = content + line.replaceAll(a1,"").replaceAll(a2,"").replaceAll(sup,"").replaceAll("&nbsp|&nbsp;|\r|\n|\\s","");
        }
        return content;
    }
}

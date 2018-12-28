import cc.rukia.WordAnalyzer.util.ToWordUtil;
import org.junit.Test;
import word.api.interfaces.IDocument;
import word.w2004.Document2004;
import word.w2004.elements.BreakLine;
import word.w2004.elements.Heading1;
import word.w2004.elements.Paragraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Java2WordTest {
    @Test
    public void Java2WordTest(){
        IDocument myDoc = new Document2004();
        myDoc.addEle(Heading1.with("标题").create());
        myDoc.addEle(BreakLine.times(2).create());
        myDoc.addEle(Paragraph.with("Powered by jas").create());
        myDoc.addEle(Paragraph.with("陈佳傲").create());
        File file = new File("Java2Word.doc");
        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        String myWord = myDoc.getContent();
        printWriter.println(myWord);
        printWriter.close();
    }
    @Test
    public void ToWordUtilTest(){
        ToWordUtil.setFile("ToWordUtil.doc");
        ToWordUtil.addHeading("标题1",1);
        ToWordUtil.addHeading("标题2",2);
        ToWordUtil.addHeading("标题3",3);
        ToWordUtil.addPara("这是一个段落，这个段落是由ToWordUtil生成的");
        ToWordUtil.addBreakLine(4);
        ToWordUtil.addPara("这是一个新的段落");
        ToWordUtil.flush();
    }
}

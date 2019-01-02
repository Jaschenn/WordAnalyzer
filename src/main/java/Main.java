import cc.rukia.WordAnalyzer.ansj.AnsjProcess;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;

import java.util.Map;

public class Main {
//    private static final SessionFactory ourSessionFactory;
//
//    static {
//        try {
//            ourSessionFactory = new Configuration().
//                    configure("hibernate.cfg.xml").
//                    buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }
//
//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
//            for (Object key : metadataMap.keySet()) {
//                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
//                final String entityName = classMetadata.getEntityName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
//    }
public static void main(String[] args) {
    HttpGetRequest peopleUrl = new HttpGetRequest("http://it.people.com.cn/index2.html");
    HttpGetRequest iresearchUrl = new HttpGetRequest("http://news.iresearch.cn/");
    HttpGetRequest elecfansUrl = new HttpGetRequest("http://www.elecfans.com/rengongzhineng/1064_2.html");
    HttpGetRequest cbdioUrl = new HttpGetRequest("http://www.cbdio.com/index.html");
    peopleUrl.setCharset("GBK");
    iresearchUrl.setCharset("GBK");
//    GeccoEngine.create()
//            //Gecco搜索的包路径
//            .classpath("cc.rukia.WordAnalyzer.internet")
//            //开始抓取的页面地址
//            .start(iresearchUrl)
//            //开启几个爬虫线程
//            .thread(5)
//            //单个爬虫每次抓取完一个请求后的间隔时间
//            .interval(500)
//            .run();
//    GeccoEngine.create()
//            .classpath("cc.rukia.WordAnalyzer.internet")
//            .start(peopleUrl)
//            .thread(1)
//            .interval(500)
//            .loop(false)
//            .mobile(false)
//            .run();

//    GeccoEngine.create()
//            .classpath("cc.rukia.WordAnalyzer.internet")
//            .start(elecfansUrl)
//            .thread(1)
//            .interval(500)
//            .loop(false)
//            .mobile(false)
//            .debug(true)
//            .run();
//
//    GeccoEngine.create()
//            .classpath("cc.rukia.WordAnalyzer.internet")
//            .start(cbdioUrl)
//            .thread(1)
//            .interval(500)
//            .loop(false)
//            .mobile(false)
//            .start();
    AnsjProcess a = new AnsjProcess();
    a.process();

}
}

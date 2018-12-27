import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

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
    HttpGetRequest startUrl = new HttpGetRequest("http://it.people.com.cn/index2.html");
    startUrl.setCharset("GBK");
    GeccoEngine.create()
            .classpath("cc.rukia.WordAnalyzer.People")
            .start(startUrl)
            .thread(1)
            .interval(2000)
            .loop(false)
            .mobile(false)
            .start();
}
}

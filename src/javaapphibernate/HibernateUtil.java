package javaapphibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Avk
 */
public class HibernateUtil {
    private static Configuration configuration=new Configuration().configure();
    private static SessionFactory sessionFactory=null;
    private static Session session=null;
    
    public static void loadResource(String file){
        closeSession();
        configuration=configuration.addResource(file);
    }
    
    public static void loadResource(Class file){
        closeSession();
        configuration=configuration.addAnnotatedClass(file);
    }
    
    public static Session getOpenSession(){
        if (sessionFactory==null || sessionFactory.isClosed()) {
            sessionFactory = configuration.buildSessionFactory();
        } 
        if (session==null || !session.isOpen()) {
            session=sessionFactory.openSession();
        }
        return session;
    }
    
    public static void closeSession(){
        if (session!=null) {
            session.close();
        }
        if (sessionFactory!=null) {
            sessionFactory.close();
        }
    }
}

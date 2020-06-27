package DbUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBconn {

    private static SessionFactory sessionFactory;
    //    public static Session getSession()
//    {
//        return getSessionFactory().openSession();
//    }


    public static SessionFactory getSessionFactory()
    {
        if (sessionFactory ==null || sessionFactory.isClosed())
        {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession()
    {
        return getSessionFactory().getCurrentSession();
    }


//    private static String url;
//    private static String user;
//    private static String password;
//    static Connection conn = null;
//    static Statement stmt = null;
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getConnection() throws SQLException {
//        url = "jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf-8";
//        user = "root";
//        password ="123456";
//        if (conn == null)
//            conn = DriverManager.getConnection(url,user,password);
//        return conn;
//    }

}



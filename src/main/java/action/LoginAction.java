package action;

import DbUtils.DBconn;
import com.opensymphony.xwork2.ActionSupport;
import model.UserEntity;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware
{
    UserEntity user; //模型驱动
    private Connection conn;
    private Statement stmt;
    public Session toolSession = DBconn.getSession();



    private ResultSet rs;

    public static Map<String, Object> session;

    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setSession(Map<String, Object> session) {
        this.session=session ;
    }

    public String execute() throws SQLException {


        toolSession.beginTransaction();
        String hql = "from UserEntity where username=?1 and password=?2";
        UserEntity user1 = (UserEntity) toolSession.createQuery(hql)
                .setParameter(1, user.getUsername())
                .setParameter(2, user.getPassword())
                .uniqueResult();
        session.put("user",user1);

        toolSession.getTransaction().commit();
        if(!user1.getPower().equals("0"))
            return user1.getPower();
        else
            return "error";








//        String x = "0";
//        String hql = "select * from user";
//        conn = DBconn.getConnection();
//        stmt=conn.createStatement();
//        rs = stmt.executeQuery(sql);
//        System.out.println("conn ok");
//        while (rs.next())
//        {
//            if (user.getUsername().equals(rs.getString("username")) && user.getPassword().equals(rs.getString("password")))
//            {
//                user.setPower(rs.getString("power"));
//                user.setMoney(rs.getFloat("money"));
//                x=rs.getString("power");
//            }
//            session.put("user",user);
//        }
//
//        if(!x.equals("0"))
//            return x;
//        else
//            return "error";
    }

}

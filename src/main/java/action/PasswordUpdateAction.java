package action;

import DbUtils.DBconn;
import model.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class PasswordUpdateAction
{
    private UserEntity user; //模型驱动
    private Connection conn;
    private Statement stmt;
    private int rs=0;
    public Session toolSession = DBconn.getSession();
    Transaction t = toolSession.beginTransaction();
    private String password2;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public PasswordUpdateAction() throws ParseException {
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public String execute() throws SQLException {


//        conn = DBconn.getConnection();
//        stmt=conn.createStatement();
        String username = user.getUsername();


        if (user.getPassword().equals(password2) && !user.getPassword().equals(""))
        {
            String hql = "update UserEntity set password=?1 where username=?2";
            Query q = toolSession.createQuery(hql).setParameter(1,user.getPassword()).setParameter(2,user.getUsername());
            q.executeUpdate();
            toolSession.getTransaction().commit();

//            String sql = "update user set password = '"+user.getPassword()+"' where username = '"+user.getUsername()+"'";
//            rs = stmt.executeUpdate(sql);
//            System.out.println("2@2@2@2\t"+rs);
            System.out.println("conn ok");
        }
        if (rs==1) {
            return "success";
        }
        else
            return "error";
    }
}

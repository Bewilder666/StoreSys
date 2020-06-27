package action;

import DbUtils.DBconn;
import model.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class RegisterAction
{
    public Session toolSession = DBconn.getSession();
    Transaction t = toolSession.beginTransaction();

    private UserEntity user; //模型驱动
    private Connection conn;
    private Statement stmt;
    private int rs=0;

    private String password2;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public RegisterAction() throws ParseException {
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


        String hql = "from UserEntity where username=?1";
        UserEntity u = (UserEntity) toolSession.createQuery(hql).setParameter(1,user.getUsername()).uniqueResult();

//        String sql1 = "select * from user";
//        ResultSet rs1 = stmt.executeQuery(sql1);

        int flag=1;


//        while (rs1.next())  //用户名查重
//        {
//            if (rs1.getString("username").equals(user.getUsername()))
//                flag=0;
//        }

        if (user.getPassword().equals(password2) && !user.getPassword().equals("") && !user.getUsername().equals("") && u!=null)
        {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(user.getUsername());
            userEntity.setPassword(user.getPassword());
            userEntity.setPower("3");
            toolSession.save(userEntity);
            t.commit();

//            String sql = "insert into user(username,password,power) values('"+user.getUsername()+"','"+user.getPassword()+"','3')";
//            //
//            rs = stmt.executeUpdate(sql);
            System.out.println("conn ok");

        }
        if (flag==1)
            return "success";
        else
            return "error";
    }
}

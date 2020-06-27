package action;

import DbUtils.DBconn;
import model.BuyHistoryEntity;
import model.UserEntity;
import model.item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TuihuoAction
{
    public Session toolSession = DBconn.getSession();
    Transaction t = toolSession.beginTransaction();
    private static final long serialVersionUID = 1L;
    private BuyHistoryEntity buyhistory;
    private UserEntity user;
    private ArrayList<BuyHistoryEntity> buyhistories = new ArrayList<BuyHistoryEntity>();
    private ArrayList<item> items = new ArrayList<item>();
    public BuyHistoryEntity getBuyhistory() {
        return buyhistory;
    }
    public void setBuyhistory(BuyHistoryEntity buyhistory) {
        this.buyhistory = buyhistory;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    private Connection conn;
    private Statement stmt;

    public String execute() throws SQLException {
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();

        toolSession.beginTransaction();

        String hql = "delete from BuyHistoryEntity  where username=?1 and item=?2 and date=?3";
        Query q = toolSession.createQuery(hql)
                .setParameter(1,user.getUsername())
                .setParameter(2,buyhistory.getItem())
                .setParameter(3,buyhistory.getDate());
        q.executeUpdate();
        toolSession.getTransaction().commit();

//        String sql = "delete from buy_history " +
//                "where username='"+user.getUsername()+"' and item='"+buyhistory.getItem()+"' " +
//                "and count='"+buyhistory.getCount()+"' and date='"+buyhistory.getDate()+"' " +
//                "and store='"+buyhistory.getStore()+"'";
//        int rs = stmt.executeUpdate(sql);


//        if (rs==1)
//        {
            System.out.println("删除记录成功");
            hql = "update UserEntity set money=money+?1 where username=?2";
            q = toolSession.createQuery(hql).setParameter(1,buyhistory.getPay()).setParameter(2,user.getUsername());
            q.executeUpdate();
            toolSession.getTransaction().commit();

//            sql="update user set money=money+"+buyhistory.getPay()+" where username='"+user.getUsername()+"'";
//            rs=stmt.executeUpdate(sql);


//            if (rs==1)
//                System.out.println("用户退款成功");

            UserEntity u = (UserEntity) LoginAction.session.get("user");
            u.setMoney(u.getMoney()+buyhistory.getPay());

            buyhistories = (ArrayList<BuyHistoryEntity>) LoginAction.session.get("history");
            for (int i=buyhistories.size()-1;i>=0;i--)
            {
                if (buyhistories.get(i).getItem().equals(buyhistory.getItem()) && buyhistories.get(i).getStore().equals(buyhistory.getStore()) &&
                        buyhistories.get(i).getCount()==buyhistory.getCount() && buyhistories.get(i).getDate().equals(buyhistory.getDate()))
                {
                    buyhistories.remove(i);
                }
            }
            LoginAction.session.replace("history",buyhistories);

            buyhistories = (ArrayList<BuyHistoryEntity>) LoginAction.session.get("history");


            hql="update UserEntity set money=money-?1 where username=?2";
            q = toolSession.createQuery(hql).setParameter(1,buyhistory.getPay()).setParameter(2,buyhistory.getUsername());
            q.executeUpdate();
            toolSession.getTransaction().commit();
//            sql="update  user,store set money=money-"+buyhistory.getPay()+
//                    " where user.username=store.storeManager and storeName='"+buyhistory.getStore()+"'";
//
//            rs=stmt.executeUpdate(sql);
//
//
//            if (rs==1)
//                System.out.println("商家退款成功");


            hql = "update StoreEntity set number=number+?1 where storeName=?2 and item=?3";
            q = toolSession.createQuery(hql).setParameter(1,buyhistory.getCount()).setParameter(2,buyhistory.getStore()).setParameter(3,buyhistory.getItem());
            q.executeUpdate();
            toolSession.getTransaction().commit();

//            sql = "update store set number=number+"+buyhistory.getCount()+" where storeName='"+buyhistory.getStore()+"' and item='"+buyhistory.getItem()+"'";
//            rs=stmt.executeUpdate(sql);

//            if (rs==1)
//                System.out.println("退货成功");
            items = (ArrayList<item>) LoginAction.session.get("items");
            for (int i=items.size()-1;i>=0;i--)
            {
                if (items.get(i).getItem().equals(buyhistory.getItem()) && items.get(i).getStoreName().equals(buyhistory.getStore()))
                {
                    items.get(i).setNumber((Integer.parseInt(items.get(i).getNumber())+buyhistory.getCount())+"");
                }
            }
            LoginAction.session.replace("items",items);
            items = (ArrayList<item>) LoginAction.session.get("items");

//        }

        return "success";
    }

}

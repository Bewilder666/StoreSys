package action;

import DbUtils.DBconn;
import model.BuyHistoryEntity;
import model.StoreEntity;
import model.UserEntity;
import model.item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BuyAction
{
    private static final long serialVersionUID = 1L;
    private int n;          //购买数量
    UserEntity user;
    ArrayList<UserEntity> managers = new ArrayList<UserEntity>();
    ArrayList<BuyHistoryEntity> histories = new ArrayList<BuyHistoryEntity>();
    UserEntity root;             //最高权限
    int flag=1;
    int yn;
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    model.item item;


    public Session toolSession = DBconn.getSession();
    Transaction t = toolSession.beginTransaction();

    ResultSet rs1;
    private int rs;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public model.item getItem() {
        return item;
    }
    public void setItem(model.item item) {
        this.item = item;
    }
    public String execute() throws SQLException {


        toolSession.beginTransaction();

//        conn = DBconn.getConnection();
//        stmt=conn.createStatement();

        user = (UserEntity) LoginAction.session.get("user");


        if (n<=Integer.parseInt(item.getNumber())) {             //数量小于库存
            yn=1;
            System.out.println("数量小于库存");
            int re = Integer.parseInt(item.getNumber()) - n;


            String hql = "update StoreEntity s set s.number='"+re+"' where itemId=?1 and storeName=?2";

            Query q = toolSession.createSQLQuery(hql)
                    .setParameter(1,item.getItemId())
                    .setParameter(2,item.getStoreName());
            q.executeUpdate();
            toolSession.getTransaction().commit();


//            String sql = "update store set number='" + re + "' where itemId = '" + item.getItemId() + "' and storeName = '" + item.getStoreName() + "'";
//            System.out.println(sql);
//            rs = stmt.executeUpdate(sql);
//            System.out.println("conn ok");



            item.setNumber(re + "");
                ArrayList<item> f = (ArrayList<item>) LoginAction.session.get("items");

                for (int i = 0; i < f.size(); i++) {
                    if (f.get(i).getItemId().equals(item.getItemId()) && f.get(i).getStoreName().equals(item.getStoreName())) {
                        f.remove(i);
                        f.add(item);
                    }
                }


                LoginAction.session.replace("items", f);
                //manager赚钱



                String x1 = item.getOutPrice();
                String x2=item.getBasePrice();
                float money = n*Float.parseFloat(item.getOutPrice());
                float true_money = n*(Float.parseFloat(x1)-Float.parseFloat(x2));

                BuyHistoryEntity bh = new BuyHistoryEntity();
                bh.setUsername(user.getUsername());
                bh.setPay(money);
                bh.setStore(item.getStoreName());
                bh.setItem(item.getItem());
                bh.setCount(n);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                bh.setDate(df.format(new Date()).toString());

//                Transaction t = toolSession.beginTransaction();
                toolSession.save(bh);
                t.commit();

                    System.out.println("历史记录插入成功");
                histories = (ArrayList<BuyHistoryEntity>) LoginAction.session.get("history");

                histories.add(bh);
                LoginAction.session.replace("history",histories);

                String in_money = "update UserEntity set money=?1,inMoney=?2,trueInMoney=?3 where username=?4";
            Query q_money = toolSession.createQuery(in_money);
            q_money.executeUpdate();
            toolSession.getTransaction().commit();
            System.out.println("交易成功");
//                String in_money = "update user,store set money=money+"+money+"," +
//                        "in_money=in_money+"+money+",true_in_money=true_in_money+"
//                        +true_money+" where user.username=store.storeManager and storeName='"
//                        +item.getStoreName()+"'";


        }

        else
        {                       //数量大于当前仓库库存    去其他仓库取
            yn=0;
            System.out.println("数量大于当前仓库库存    去其他仓库取");
            ArrayList<item> iii = new ArrayList<item>();
            int count=0;

            String hql = "from StoreEntity store ,PriceEntity price where price.itemId = store.itemId and store.itemId=?1";
            rs1= (ResultSet) toolSession.createQuery(hql).setParameter(1,item.getItemId()).list();

//            String sql = "select * from store,price where price.itemId = store.itemId and store.itemId = '"+item.getItemId()+"'";
//            rs1 = stmt.executeQuery(sql);
            while (rs1.next())
            {
                item i = new item();
                i.setItemId(rs1.getString("itemId"));
                i.setNumber(rs1.getString("number"));
                i.setStoreName(rs1.getString("storeName"));
                i.setItem(rs1.getString("item"));
                i.setOutPrice(rs1.getString("outPrice"));
                i.setBasePrice(rs1.getString("basePrice"));
                iii.add((item) i);
                count+=Integer.parseInt(i.getNumber());
            }
            if (n<count)
            {                                          //如果数量小于总库存
                System.out.println("如果数量小于总库存");

                histories = (ArrayList<BuyHistoryEntity>) LoginAction.session.get("history");
                for (int i = 0; i < iii.size(); i++) {
                    if (Integer.parseInt(iii.get(i).getNumber()) < n)     //其中一个仓库库存不够
                    {
                        System.out.println("其中一个仓库库存不够");
                        n  -= Integer.parseInt(iii.get(i).getNumber());

                        float money = Float.parseFloat(iii.get(i).getNumber())*Float.parseFloat(iii.get(i).getOutPrice());

                        float true_money = Float.parseFloat(iii.get(i).getNumber())*(Float.parseFloat(iii.get(i).getOutPrice())-Float.parseFloat(iii.get(i).getBasePrice()));

                        String hql_in_money = "update UserEntity set money=money+?1,inMoney=inMoney+?2,trueInMoney=trueInMoney+?3 where username=?4";

                        Query q = toolSession.createQuery(hql_in_money)
                                .setParameter(1,money)
                                .setParameter(2,money)
                                .setParameter(3,true_money)
                                .setParameter(4,iii.get(i).getStoreManager());
                        q.executeUpdate();
                        toolSession.getTransaction().commit();
                        System.out.println("仓库1交易成功");

//                        String in_money1 = "update user,store set money=money+"+money+"," +
//                                "in_money=in_money+"+money+",true_in_money=true_in_money+"+true_money+"" +
//                                " where user.username=store.storeManager and " +
//                                "store.storeName='"+iii.get(i).getStoreName()+"' ";
//                        int rs_in = stmt.executeUpdate(in_money1);
//                        if (rs_in==1)
//                        {
//                            System.out.println("仓库1交易成功");
//                        }
                        BuyHistoryEntity bh2 = new BuyHistoryEntity();
                        bh2.setPay(money);
                        bh2.setStore(iii.get(i).getStoreName());
                        bh2.setUsername(user.getUsername());
                        bh2.setItem(iii.get(i).getItem());
                        bh2.setCount(Integer.parseInt(iii.get(i).getNumber())); //error
                        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        bh2.setDate(df1.format(new Date()).toString());


                        if (bh2.getCount()!=0) {
                            histories.add(bh2);


                            toolSession.save(bh2);
                            t.commit();
                                System.out.println("历史记录插入成功");
                            iii.get(i).setNumber("0");

                        }

                    } else {                                    //此时仓库库存数量大于n
                        System.out.println("此时仓库库存数量大于n");
                        iii.get(i).setNumber(String.valueOf(Integer.parseInt(iii.get(i).getNumber())-n));


                        float money = n*Float.parseFloat(iii.get(i).getOutPrice());
                        String x1 = iii.get(i).getOutPrice();
                        String x2=iii.get(i).getBasePrice();

                        float true_money = n*(Float.parseFloat(x1)-Float.parseFloat(x2));
                        String hql_in_money = "update UserEntity set money=money+?1,inMoney=inMoney+?2,trueInMoney=trueInMoney+?3 where username=?4";
                        Query q = toolSession.createQuery(hql_in_money)
                                .setParameter(1,money)
                                .setParameter(2,money)
                                .setParameter(3,true_money)
                                .setParameter(4,iii.get(i).getStoreManager());
                        q.executeUpdate();
                        toolSession.getTransaction().commit();
                        System.out.println("仓库N交易完成");

//                        String in_money2 = "update user,store set money=money+"+money+"," +
//                                "in_money=in_money+"+money+",true_in_money=true_in_money+"+true_money+"" +
//                                " where user.username=store.storeManager and store.storeName='"+iii.get(i).getStoreName()+"'";
//
//                        int rs_in2 = stmt.executeUpdate(in_money2);
//                        if (rs_in2==1)
//                        {
//                            System.out.println("仓库n交易成功");
//                        }

                        BuyHistoryEntity bh1 = new BuyHistoryEntity();
                        bh1.setPay(money);
                        bh1.setStore(iii.get(i).getStoreName());
                        bh1.setUsername(user.getUsername());
                        bh1.setItem(iii.get(i).getItem());
                        bh1.setCount(n);
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        bh1.setDate(df.format(new Date()).toString());
                        histories.add(bh1);

                        toolSession.save(bh1);
                        t.commit();

//                        String history = "insert into buy_history(username,item,count,date,store,pay) values('"+bh1.getUsername()+"','"+bh1.getItem()+"',"+bh1.getCount()+",'"+bh1.getDate()+"','"+bh1.getStore()+"',"+bh1.getPay()+")";
//                        rs = stmt.executeUpdate(history);
//                        if (rs==1)
                            System.out.println("历史记录插入成功");

                    }
                }
                for (int i=0;i<iii.size();i++)      //修改session
                {
                    ArrayList<item> f = (ArrayList<item>) LoginAction.session.get("items");
                    for (int j=0;j<f.size();j++)
                    {
                        if (iii.get(i).getItemId().equals(f.get(j).getItemId()) && iii.get(i).getStoreName().equals(f.get(j).getStoreName()))
                        {
                            f.remove(j);
                            f.add(iii.get(i));
                        }
                    }
                    String hql2 = "update StoreEntity set number=?1 where itemId=?2 and storeName=?3";
                    Query q = toolSession.createQuery(hql2)
                            .setParameter(1,iii.get(i).getNumber())
                            .setParameter(2,iii.get(i).getItemId())
                            .setParameter(3,iii.get(i).getStoreName());
                    q.executeUpdate();
                    toolSession.getTransaction().commit();
//
//                    String sql2 = "update store set number='"+iii.get(i).getNumber()+
//                            "' where itemId='"+iii.get(i).getItemId()+"' and storeName = '"+iii.get(i).getStoreName()+"'";
//                    int rs2=0;
//                    rs2 = stmt.executeUpdate(sql2);
//                    if (rs2==0)
//                    {
//                        System.out.println("修改错误！！");
//                    }

                }
                LoginAction.session.replace("history",histories);
            }
            else                             //数量大于总库存
            {
                flag=0;
            }
        }

        if (yn==0&&flag==1||yn==1&&rs!=0) {
            user = (UserEntity) LoginAction.session.get("user");
            user.setMoney(user.getMoney()-n*Float.parseFloat(item.getOutPrice()));
            LoginAction.session.replace("user",user);

            user = (UserEntity) LoginAction.session.get("user");
            float money = (float) (user.getMoney()-n*Integer.parseInt(item.getOutPrice()));
            float true_money = (float) (user.getMoney()-n*(Integer.parseInt(item.getOutPrice())-Integer.parseInt(item.getBasePrice())));

            String hql_money = "update UserEntity set money=?1,trueInMoney=?2 where username=?3";
            Query q = toolSession.createQuery(hql_money)
                    .setParameter(1,money)
                    .setParameter(2,true_money)
                    .setParameter(3,user.getUsername());
            q.executeUpdate();
            toolSession.getTransaction().commit();

//            String sql_money = "update user set money = "+money+",true_in_money = "+true_money+" where username = '"+user.getUsername()+"'";
//
//            int rss = stmt.executeUpdate(sql_money);
//            if (rss==1)
//            {
//                System.out.println("success");
//            }
            return "success";
        }
        else
            return "error";
    }

}

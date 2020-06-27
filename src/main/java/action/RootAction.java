package action;

import DbUtils.DBconn;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.lang.*;

//public class RootAction extends ActionSupport implements SessionAware {
//    private Store store ;
//    private User user;
//    private model.item item;
//    private Connection conn;
//    private Statement stmt;
//    private ResultSet rs;
//    private int rs2;
//    private  int  rs3;
//    private int rs4;
//    private Map<String, Object> session;
//    private ArrayList<model.item> itemList = new ArrayList<model.item>();
//    private ArrayList<Store> storeList =new ArrayList<Store>();
//    private ArrayList<User> userList = new ArrayList<User>();
//    private ArrayList<User> usermoneyList = new ArrayList<User>();
//    private String name;
//    private String itemid;
//    private String manager;
//    private String username;
//    private BuyHistory bh;
//    private ArrayList<BuyHistory> history = new ArrayList<BuyHistory>();
//
//    @Override
//    public void setSession(Map<String, Object> session) {
//        this.session=session;
//    }
//
//    public String selectstore() throws Exception {
//        String sql = "select distinct storeName,storeManager from store";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs=stmt.executeQuery(sql);
//        while (rs.next()) {
//            Store store =new Store();
//            store.setStoreManager(rs.getString(2));
//            store.setStoreName(rs.getString(1));
//            storeList.add(store);
//        }
//        session.put("storeList",storeList);
//        return "success";
//    }
//    public String select() throws Exception {
//        if(!(name ==null)) {
//            session.put("storename",name);
//        }
//        String sql = "select * from store,price where storename='"+session.get("storename")+"' and price.item = store.item";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs = stmt.executeQuery(sql);
//        while (rs.next()) {
//            //get value from db to book propety
//            model.item item = new item();
//            item.setItem(rs.getString("item"));
//            item.setItemId(rs.getString("itemId"));
//            item.setNumber(rs.getString("number"));
//            item.setBasePrice(rs.getString("basePrice"));
//            item.setOutPrice(rs.getString("outPrice"));
//            item.setStoreManager(rs.getString("storeManager"));
//            item.setStoreName(rs.getString("storeName"));
//            itemList.add(item);
//        }
//        session.put("itemlist",itemList);
//        return "success";
//    }
//    public String selectbuy() throws Exception {
//        String sql = "select * from buy_history";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs = stmt.executeQuery(sql);
//        while (rs.next())
//        {
//            BuyHistory bh = new BuyHistory();
//            bh.setStore(rs.getString("store"));
//            bh.setPay(rs.getFloat("pay"));
//            bh.setUsername(rs.getString("username"));
//            bh.setItem(rs.getString("item"));
//            bh.setCount(rs.getInt("count"));
//            bh.setDate(rs.getString("date"));
//            history.add(bh);
//        }
//        session.put("buyhistory",history);
//
//        return "success";
//    }
//    public String delete() throws Exception {
//        String sql = "DELETE from store where storeName='"+name+"'";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs2= stmt.executeUpdate(sql);
//        selectstore();
//        return "success";
//    }
//    public String insert() throws Exception {
//        String sql = "insert into store(storeName,storeManager) values('"+store.getStoreName()+"','"+store.getStoreManager()+"')";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs2= stmt.executeUpdate(sql);
//        selectstore();
//        return "success";
//    }
//    public String selectuser() throws Exception {
//        String sql = "select username,password,money from user where username!='root' or username!='manager1' or username!='manager2'";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs=stmt.executeQuery(sql);
//        while (rs.next()) {
//            User user =new User();
//            user.setUsername(rs.getString(1));
//            user.setPassword(rs.getString(2));
//            user.setMoney(rs.getFloat(3));
//            userList.add(user);
//        }
//        session.put("userlist",userList);
//        return "success";
//    }
//    public String updateitem() throws Exception {
//        String sql = "update price set item='"+item.getItem()+"',basePrice ='"+item.getBasePrice()+"',outPrice ='"+item.getOutPrice()+"' where itemId='"+item.getItemId()+"'";
//        String sql2 = "update store set  item='"+item.getItem()+"', number='"+item.getNumber()+"' where itemId='"+item.getItemId()+"' ";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs2= stmt.executeUpdate(sql);
//        rs3=stmt.executeUpdate(sql2);
//        select();
//        return "success";
//    }
//    public String deleteitem() throws Exception {
//        String sql = "DELETE from store where itemId='"+itemid+"'";
//        String sql2 = "DELETE from price where itemId='"+itemid+"'";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs2= stmt.executeUpdate(sql);
//        rs3= stmt.executeUpdate(sql2);
//        select();
//        return "success";
//    }
//    public String insertitem() throws Exception {
//        String sql = "select  distinct storeManager from store where storeName='"+session.get("storename")+"' ";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs=stmt.executeQuery(sql);
//        while (rs.next()){
//            manager=rs.getString("storeManager");
//        }
//        String sql1 = "delete from store where storeName='"+session.get("storename")+"' and  itemId is  null ";
//        rs2= stmt.executeUpdate(sql1);
//        String sql2 = "insert into store values('"+session.get("storename")+"','"+item.getItem()+"','"+item.getNumber()+"','"+item.getItemId()+"','"+manager+"')";
//        rs3=stmt.executeUpdate(sql2);
//        String sql3 = "insert into price values('"+item.getItem()+"','"+item.getBasePrice()+"','"+item.getItemId()+"','"+item.getOutPrice()+"' )";
//        rs4=stmt.executeUpdate(sql3);
//        select();
//        return "success";
//    }
//    public String deleteuser() throws Exception {
//        String sql = "DELETE from user where username='"+username+"'";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs2= stmt.executeUpdate(sql);
//        selectuser();
//        return "success";
//    }
//    public String selectmoney() throws Exception {
//        String sql = "select username,in_money,true_in_money from user where username ='manager1' or username='manager2'";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs=stmt.executeQuery(sql);
//        while (rs.next()) {
//            User user =new User();
//            user.setUsername(rs.getString(1));
//            user.setIn_money(rs.getFloat(2));
//            user.setTrue_in_money(rs.getFloat(3));
//            System.out.println(rs.getFloat(3));
//            usermoneyList.add(user);
//        }
//        session.put("usermoneylist",usermoneyList);
//        return "success";
//    }
//    public String updatestore() throws Exception {
//        String sql = "update store set  storeManager='"+store.getStoreManager()+"' where storeName='"+store.getStoreName()+"'";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs2= stmt.executeUpdate(sql);
//        selectstore();
//        return "success";
//    }
//    public Store getStore() {
//        return store;
//    }
//
//    public void setStore(Store store) {
//        this.store = store;
//    }
//
//    public ArrayList<model.item> getItemList() {
//        return itemList;
//    }
//
//    public void setItemList(ArrayList<model.item> itemList) {
//        this.itemList = itemList;
//    }
//
//    public Map<String, Object> getSession() {
//        return session;
//    }
//
//    public ArrayList<Store> getStoreList() {
//        return storeList;
//    }
//
//    public void setStoreList(ArrayList<Store> storeList) {
//        this.storeList = storeList;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public model.item getItem() {
//        return item;
//    }
//
//    public void setItem(model.item item) {
//        this.item = item;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public ArrayList<User> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(ArrayList<User> userList) {
//        this.userList = userList;
//    }
//
//    public String getItemid() {
//        return itemid;
//    }
//
//    public void setItemid(String itemid) {
//        this.itemid = itemid;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public BuyHistory getBh() {
//        return bh;
//    }
//
//    public void setBh(BuyHistory bh) {
//        this.bh = bh;
//    }
//
//    public ArrayList<BuyHistory> getHistory() {
//        return history;
//    }
//
//    public void setHistory(ArrayList<BuyHistory> history) {
//        this.history = history;
//    }
//}

package action;

import DbUtils.DBconn;
import com.opensymphony.xwork2.ActionSupport;
import model.item;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class manager extends ActionSupport implements SessionAware {
//    private item items;
//    private newItem newitem;
//    private Connection conn;
//    private Statement stmt;
//    private ResultSet rs;
    private Map<String, Object> session;
//    private ArrayList<item> magList1 = new ArrayList<item>();
//    private ArrayList<item> magList2 = new ArrayList<item>();
//    private ArrayList<item> s = new ArrayList<item>();
//
//
//    public String execute1() throws Exception {
//        //查询仓库信息
//        String sql1 = "select * from store,price where storeManager='manager1' and price.item = store.item order by store.item";
//        String sql2 = "select * from store,price where storeManager='manager2' and price.item = store.item order by store.item";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        rs = stmt.executeQuery(sql1);
//
//        while (rs.next()) {
//            //get value from db to book propety
//            item items = new item();
//            items.setItem(rs.getString("item"));
//            items.setItemId(rs.getString("itemId"));
//            items.setNumber(rs.getString("number"));
//            items.setBasePrice(rs.getString("basePrice"));
//            items.setOutPrice(rs.getString("outPrice"));
//            items.setStoreManager(rs.getString("storeManager"));
//            items.setStoreName(rs.getString("storeName"));
//            magList1.add(items);
//        }
//        LoginAction.session.put("magList1",magList1);
//        rs = stmt.executeQuery(sql2);
//        while (rs.next()) {
//            //get value from db to book propety
//            item items = new item();
//            items.setItem(rs.getString("item"));
//            items.setItemId(rs.getString("itemId"));
//            items.setNumber(rs.getString("number"));
//            items.setBasePrice(rs.getString("basePrice"));
//            items.setOutPrice(rs.getString("outPrice"));
//            items.setStoreManager(rs.getString("storeManager"));
//            items.setStoreName(rs.getString("storeName"));
//            magList2.add(items);
//        }
//        LoginAction.session.put("magList2",magList2);
//        System.out.println(magList1);
//        System.out.println(magList2);
//        return super.execute();
//    }
//
//    public String execute2() throws Exception{
//        String aimItem = "";
//        String aimStore = "";
//        int newNumber = 0;
//        aimItem = newitem.getAimItem();
//        aimStore = newitem.getAimStore();
//        newNumber = newitem.getAddNumber();
//        System.out.println(aimItem);
//        System.out.println(aimStore);
//        System.out.println(newNumber);
//        String sql="UPDATE store set number=number + '"+newNumber+"' where storeName = '"+aimStore+"' and store.item = '"+aimItem+"'";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        stmt.executeUpdate(sql);
//        String arr = "";
//        sql = "select number from store where store.item='"+aimItem+"' and storeName = '"+aimStore+"'";
//        rs = stmt.executeQuery(sql);
//        s = (ArrayList<item>) LoginAction.session.get("magList1");
//        while (rs.next()){
//            arr = rs.getString("number")+"";
//        }
//        for(int i=0;i<s.size();i++){
//            //System.out.println(i);
//            if(s.get(i).getItem().equals(aimItem)&&s.get(i).getStoreName().equals(aimStore)){
//                s.get(i).setNumber(arr);
//            }
//        }
//        LoginAction.session.replace("magList1",s);
//
//        s = (ArrayList<item>) LoginAction.session.get("magList2");
//        for(int i=0;i<s.size();i++){
//            //System.out.println(i);
//            if(s.get(i).getItem().equals(aimItem)&&s.get(i).getStoreName().equals(aimStore)){
//                s.get(i).setNumber(arr);
//            }
//        }
//        LoginAction.session.replace("magList2",s);
//        return "success";
//    }
//
//    public String execute3() throws Exception{
//        String aimItem = "";
//        String aimStore = "";
//        int newNumber = 0;
//        aimItem = newitem.getAimItem();
//        aimStore = newitem.getAimStore();
//        newNumber = newitem.getDisNumber();
//        System.out.println(aimItem);
//        System.out.println(aimStore);
//        System.out.println(newNumber);
//        String sql="UPDATE store set number=number - '"+newNumber+"' where storeName = '"+aimStore+"' and item = '"+aimItem+"'";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//        stmt.executeUpdate(sql);
//        String arr = "";
//        sql = "select number from store where item='"+aimItem+"' and storeName = '"+aimStore+"'";
//        rs = stmt.executeQuery(sql);
//        s = (ArrayList<item>) LoginAction.session.get("magList1");
//        while(rs.next()){
//            arr = rs.getFloat("number")+"";
//        }
//        for(int i=0;i<s.size();i++){
//            //System.out.println(i);
//            if(s.get(i).getItem().equals(aimItem)&&s.get(i).getStoreName().equals(aimStore)){
//                s.get(i).setNumber(arr);
//            }
//        }
//        LoginAction.session.replace("magList1",s);
//
//        s = (ArrayList<item>) LoginAction.session.get("magList2");
//        for(int i=0;i<s.size();i++){
//            //System.out.println(i);
//            if(s.get(i).getItem().equals(aimItem)&&s.get(i).getStoreName().equals(aimStore)){
//                s.get(i).setNumber(arr);
//            }
//        }
//        LoginAction.session.replace("magList2",s);
//
//        return "success";
//    }
//
//    public String execute4() throws Exception{
//        String aimItem = "";
//        //String aimStore = "";
//        float newBasePrice = 0;
//        float newOutPrice = 0;
//        //aimStore = newitem.getAimStore();
//        aimItem = newitem.getAimItem();
//        newBasePrice = newitem.getNewBasePrice();
//        newOutPrice = newitem.getNewOutPrice();
//        System.out.println(aimItem);
//        System.out.println(newBasePrice);
//        System.out.println(newOutPrice);
//        String sql="";
//        conn = DBconn.getConnection();
//        stmt = conn.createStatement();
//
//        sql="UPDATE price set baseprice = '"+newBasePrice+"', outprice = '"+newOutPrice+"' where item = '"+aimItem+"'";
//        stmt.executeUpdate(sql);
//        String arr1 = newBasePrice+"";
//        String arr2 = newOutPrice+"";
//        s = (ArrayList<item>) LoginAction.session.get("magList1");
//        for(int i=0;i<s.size();i++){
//            //System.out.println(i);
//            if(s.get(i).getItem().equals(aimItem)){
//                s.get(i).setBasePrice(arr1);
//                s.get(i).setOutPrice(arr2);
//            }
//        }
//        LoginAction.session.replace("magList1",s);
//        s = (ArrayList<item>) LoginAction.session.get("magList2");
//        for(int i=0;i<s.size();i++){
//            if(s.get(i).getItem().equals(aimItem)){
//                s.get(i).setBasePrice(arr1);
//                s.get(i).setOutPrice(arr2);
//            }
//        }
//        LoginAction.session.replace("magList2",s);
//        return "success";
//    }
//
//    public item getItems() {
//        return items;
//    }
//
//    public void setItems(item items) {
//        this.items = items;
//    }
//
//    public ArrayList<item> getMagList1() {
//        return magList1;
//    }
//
//    public void setMagList1(ArrayList<item> magList1) {
//        this.magList1 = magList1;
//    }
//
//    public ArrayList<item> getMagList2() {
//        return magList2;
//    }
//
//    public void setMagList2(ArrayList<item> magList2) {
//        this.magList2 = magList2;
//    }
//
//    public newItem getNewitem() {
//        return newitem;
//    }
//
//    public void setNewitem(newItem newitem) {
//        this.newitem = newitem;
//    }
    @Override
    public void setSession(Map<String, Object> map) {
    }
}

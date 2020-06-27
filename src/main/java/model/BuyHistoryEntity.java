package model;

import javax.persistence.*;

@Entity
@Table(name = "buy_history", schema = "hibernate")
public class BuyHistoryEntity {
    private String username;
    private String item;
    private int count;
    private String date;
    private String store;
    private double pay;
    private int id;



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自动递增

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "item")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Basic
    @Column(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "store")
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Basic
    @Column(name = "pay")
    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuyHistoryEntity that = (BuyHistoryEntity) o;

        if (count != that.count) return false;
        if (Double.compare(that.pay, pay) != 0) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (store != null ? !store.equals(that.store) : that.store != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = username != null ? username.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + count;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (store != null ? store.hashCode() : 0);
        temp = Double.doubleToLongBits(pay);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

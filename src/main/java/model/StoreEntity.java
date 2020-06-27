package model;

import javax.persistence.*;

@Entity
@Table(name = "store", schema = "hibernate", catalog = "")
public class StoreEntity {
    private int id;
    private String storeName;
    private String item;
    private String number;
    private String itemId;
    private String storeManager;

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
    @Column(name = "storeName")
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "itemId")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "storeManager")
    public String getStoreManager() {
        return storeManager;
    }

    public void setStoreManager(String storeManager) {
        this.storeManager = storeManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreEntity that = (StoreEntity) o;

        if (storeName != null ? !storeName.equals(that.storeName) : that.storeName != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (storeManager != null ? !storeManager.equals(that.storeManager) : that.storeManager != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeName != null ? storeName.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (storeManager != null ? storeManager.hashCode() : 0);
        return result;
    }
}

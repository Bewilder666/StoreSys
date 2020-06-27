package model;

import javax.persistence.*;

@Entity
@Table(name = "price", schema = "hibernate", catalog = "")
public class PriceEntity {
    private String item;
    private String baseprice;
    private String itemId;
    private String outprice;

    @Id
    @Column(name = "item")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Basic
    @Column(name = "baseprice")
    public String getBaseprice() {
        return baseprice;
    }

    public void setBaseprice(String baseprice) {
        this.baseprice = baseprice;
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
    @Column(name = "outprice")
    public String getOutprice() {
        return outprice;
    }

    public void setOutprice(String outprice) {
        this.outprice = outprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceEntity that = (PriceEntity) o;

        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (baseprice != null ? !baseprice.equals(that.baseprice) : that.baseprice != null) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (outprice != null ? !outprice.equals(that.outprice) : that.outprice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (baseprice != null ? baseprice.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (outprice != null ? outprice.hashCode() : 0);
        return result;
    }
}

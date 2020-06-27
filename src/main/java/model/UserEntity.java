package model;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "hibernate", catalog = "")
public class UserEntity {
    private String username;
    private String password;
    private String power;
    private Double money;
    private double inMoney;
    private double trueInMoney;

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "power")
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Basic
    @Column(name = "money")
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Basic
    @Column(name = "in_money")
    public double getInMoney() {
        return inMoney;
    }

    public void setInMoney(double inMoney) {
        this.inMoney = inMoney;
    }

    @Basic
    @Column(name = "true_in_money")
    public double getTrueInMoney() {
        return trueInMoney;
    }

    public void setTrueInMoney(double trueInMoney) {
        this.trueInMoney = trueInMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (Double.compare(that.inMoney, inMoney) != 0) return false;
        if (Double.compare(that.trueInMoney, trueInMoney) != 0) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (power != null ? !power.equals(that.power) : that.power != null) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (power != null ? power.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        temp = Double.doubleToLongBits(inMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(trueInMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

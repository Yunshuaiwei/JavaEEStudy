package ysw.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/26 16:25
 * @Version
 **/
public class Account implements Serializable {
    private Integer id;
    private Integer uID;
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuID() {
        return uID;
    }

    public void setuID(Integer uID) {
        this.uID = uID;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uID=" + uID +
                ", money=" + money +
                '}';
    }
}

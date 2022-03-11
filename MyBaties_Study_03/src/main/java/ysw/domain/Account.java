package ysw.domain;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/28 9:52
 * @Version
 **/
public class Account {
    private Integer id;
    private Integer uID;
    private String money;
    private User user;

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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uID=" + uID +
                ", money='" + money + '\'' +
                '}';
    }
}

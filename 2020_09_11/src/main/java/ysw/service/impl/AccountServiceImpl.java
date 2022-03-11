package ysw.service.impl;

import ysw.service.IAccountService;

import java.util.Date;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/13 9:07
 * @Version
 **/
public class AccountServiceImpl implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;
    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name=name;
        this.age=age;
        this.birthday=birthday;
    }
    @Override
    public void saveAccount() {
        System.out.println("saveAccount方法执行了; name="+name+" ,age="+age+" ,birthday="+birthday);
    }
}

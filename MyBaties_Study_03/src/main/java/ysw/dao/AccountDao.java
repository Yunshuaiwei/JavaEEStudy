package ysw.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import ysw.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户，并且获取每个账户所属的用于信息
     * @Param []
     * @return java.util.List<ysw.domain.Account>
     **/
    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "id",property = "id"),
            @Result(column = "uID",property = "uID"),
            @Result(column = "money",property = "money"),
            @Result(column = "uID",property = "user",one = @One(select="ysw.dao.UserDao.findById",fetchType= FetchType.EAGER))
    })
    List<Account> findAll();
}

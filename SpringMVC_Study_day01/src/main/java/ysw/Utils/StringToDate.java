package ysw.Utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/7/1 11:17
 * @Version
 **/
public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (s == null) {
            throw new RuntimeException("传入参数错误！!");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("格式转换错误！！");
        }
    }
}

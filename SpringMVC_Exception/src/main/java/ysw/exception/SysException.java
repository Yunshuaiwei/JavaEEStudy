package ysw.exception;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/4 9:43
 * @Version
 **/
public class SysException extends Exception{

    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

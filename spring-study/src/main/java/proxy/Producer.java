package proxy;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/27 12:45
 * @Version
 **/
public class Producer implements IProducer{
    @Override
    public void saleProduct(float f) {
        System.out.println("销售产品："+f);
    }

    @Override
    public void afterService(float money) {
        System.out.println("售后服务："+money);
    }
}

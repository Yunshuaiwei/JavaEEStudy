package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/27 12:46
 * @Version
 **/
public class Client {
    public static void main(String[] args) {
        Producer p = new Producer();
        IProducer producer = (IProducer) Proxy.newProxyInstance(p.getClass().getClassLoader(),
                p.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Float money = (Float) args[0];
                        Object returnValue = null;
                        String methodName = "saleProduct";
                        if (methodName.equals(method.getName())) {
                            returnValue = method.invoke(p, money * 0.8f);
                        }
                        return returnValue;
                    }
                });

        producer.saleProduct(10000f);

    }

}

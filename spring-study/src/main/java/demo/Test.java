package demo;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/8 21:55
 * @Version
 **/
public class Test {
    public String id;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}

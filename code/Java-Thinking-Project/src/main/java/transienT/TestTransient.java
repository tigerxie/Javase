package transienT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestTransient {

    public static void main(String[] args) throws Exception {

        TestBean tBean = new TestBean("aaa", "18");
        System.out.println(tBean);
        ObjectOutputStream oOutputStream = new ObjectOutputStream(
                new FileOutputStream("/workspace/xxiaxie/eclipse_javaBase/Java-Thinking-Project/src/main/java/transienT/Serializable"));
        oOutputStream.writeObject(tBean);
        oOutputStream.close();
        ObjectInputStream oInputStream = new ObjectInputStream(
                new FileInputStream("/workspace/xxiaxie/eclipse_javaBase/Java-Thinking-Project/src/main/java/transienT/Serializable"));
        Object object = oInputStream.readObject();
        System.out.println(object);
        oInputStream.close();
    }
}

@SuppressWarnings("serial")
class TestBean implements Serializable {
    private String name;
    transient private String age;

    @Override
    public String toString() {
        return "TestBean [name=" + name + ", age=" + age + "]";
    }

    public TestBean(String name, String age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
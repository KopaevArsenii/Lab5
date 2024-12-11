import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("src/properties");
        properties.load(input);

        Injector injector = new Injector(properties);
        MyClass myClass = new MyClass();
        injector.inject(myClass);

        myClass.doSomething();  // Ожидаемый вывод: "Service executed!"
    }
}

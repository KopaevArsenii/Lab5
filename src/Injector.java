import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    private Properties properties;

    public Injector(Properties properties) {
        this.properties = properties;
    }

    public <T> void inject(T object) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, java.lang.reflect.InvocationTargetException {
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {

                Class<?> fieldType = field.getType();
                String interfaceImpl = properties.getProperty(fieldType.getName());

                if (interfaceImpl != null) {
                    Object implementation = Class.forName(interfaceImpl).getDeclaredConstructor().newInstance();
                    field.setAccessible(true);
                    field.set(object, implementation);
                }
            }
        }
    }
}

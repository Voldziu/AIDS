import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;

public class KomparatorStudencki<T> implements Comparator<T> {



    @Override
    public int compare(T o1,T o2) {
        String o1value = executeMethod(o1);
        String o2value = executeMethod(o2);
        int o1int = Integer.parseInt(o1value);
        int o2int = Integer.parseInt(o2value);

        return Integer.compare(o1int, o2int);


    }
    public String executeMethod(T value) {
        try {
            Method method = value.getClass().getMethod("getID");
            return method.invoke(value).toString();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);

        }


    }


}

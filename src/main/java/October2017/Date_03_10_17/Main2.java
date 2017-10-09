package October2017.Date_03_10_17;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        MyCustomLoader loader = new MyCustomLoader(Printer.class.getClassLoader());
        Class myClass = loader.loadClass("October2017.Date_03_10_17.Printer");
        Method printMethod = myClass.getMethod("print", null);
        printMethod.invoke(myClass.newInstance(), null);
    }
}

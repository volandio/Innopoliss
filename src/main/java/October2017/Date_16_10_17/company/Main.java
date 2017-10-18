package October2017.Date_16_10_17.company;

import java.io.Externalizable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Object proxy =
                Proxy.newProxyInstance(
                        SomeClass.class.getClassLoader(),
                        new Class[]{Cloneable.class,
                                    Externalizable.class},
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                return null;
                            }
        });

        Iterable s = (Iterable) proxy;

    }
}

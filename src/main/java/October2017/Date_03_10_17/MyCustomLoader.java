package October2017.Date_03_10_17;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MyCustomLoader extends ClassLoader {
    protected MyCustomLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.contains("October2017.Date_03_10_17")) {
            String fileName = name.replace('.', File.separatorChar) + ".class";
            InputStream stream = getClass().getClassLoader().getResourceAsStream(name + ".class");
            try {
                int size = stream.available();
                byte[] buffer = new byte[size];

                DataInputStream inputStream = new DataInputStream(stream);
                inputStream.readFully(buffer);
                inputStream.close();

                Class cl = defineClass(name, buffer, 0, buffer.length);
                resolveClass(cl);

                return cl;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.loadClass(name);
    }
}

package utils;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtils {

    public static void close(Closeable closeable) {
        if(null != closeable){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

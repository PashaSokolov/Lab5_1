import java.io.*;
import java.util.*;

public class FileReader {

    public static String toText( String args ){
        String file = new String();
        try {
            InputStream is = new FileInputStream(args);
            Reader isr = new InputStreamReader(is);
            int data = isr.read();

            while(data != -1){
                data = isr.read();
                char chr = (char) data;
                file = file + chr;
            }
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}

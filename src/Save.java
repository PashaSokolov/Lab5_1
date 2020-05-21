import com.google.gson.Gson;

import java.io.*;
/**
 * реализация команды save
 */

public class Save implements Command {
    Gson gson = new Gson();


    @Override
    public void execute(MovieList movieList) {
        FileOutputStream fos = null;
        String path = System.getenv("jsonEnv");
        String strCollection = new String();

        while(!path.endsWith("/")){
            path = path.replaceAll(".$","");
        }
        path = path + "SavedCollection.json";

        try{
            strCollection = gson.toJson(movieList);

            File file = new File(path);
            if(!file.exists()){
                file.createNewFile();
                fos = new FileOutputStream(file);
                fos.write(strCollection.getBytes());
                System.out.println("Collection saved successfully");
            }else if(!file.canRead() || !file.canWrite()){
                System.out.println("File is unreachable");
            }else{
                fos = new FileOutputStream(file);
                fos.write(strCollection.getBytes());
                System.out.println("Collection saved successfully");
            }
        }catch (IOException e){
            System.out.println("Error occurred");
        }catch (OutOfMemoryError e){
            System.out.println("Collection is too big, out of memory");
        }catch (SecurityException e){
            System.out.println("Impossible to create file in this directory");
        }finally {
            try{
                if(fos != null){
                    fos.close();
                }
            }catch (IOException e){
                System.out.println("Error while closing");
            }
        }

    }
}

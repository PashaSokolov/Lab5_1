import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
/**
 * класс, конвертирующий файл в коллекцию
 */
public class Convertator {
    private MovieList collection = new MovieList();
    private Gson gson = new Gson();

    /**
     * @param jsonPath путь до файла
     * @return коллекцию объектов класса Movie
     */
    public MovieList toCollection(String jsonPath) {
        File jsonFile = new File(jsonPath);

        if (!jsonFile.exists()) {
            System.out.println("File does not exist");
            System.exit(0);
        }

        if (!jsonFile.isFile()) {
            System.out.println("This is not a file");
            System.exit(0);
        }

        if (!jsonFile.canRead()) {
            System.out.println("File is unreachable");
            System.exit(0);
        }

        if (!jsonPath.endsWith(".json")) {
            System.out.println("This is not a json-file");
            System.exit(0);
        }
        System.out.println("файл успешно обнаружен");
        NullPointerChecker np = new NullPointerChecker();
        WrongFieldChecker wf = new WrongFieldChecker();
        int counter = 0;

        String data = new String();

        Type collectionType = new TypeToken<MovieList>() {
        }.getType();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(jsonPath), StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                data = data + line;
            }

            MovieList newMovie = gson.fromJson(data.toString(), collectionType);

            for (Movie m : newMovie) {
                if (!collection.contains(m)) {
                    np.checkEverything(m);
                    wf.checkEverything(m);
                    collection.add(m);
                }
            }
        } catch (JsonSyntaxException e) {
            System.out.println("JSON syntax error. Program will stop automatically");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while reading this file");
            System.exit(0);
        }catch (NullPointerException e){
            System.out.println("Null");
            System.exit(0);
        }

        collection.setAuthDateTime(LocalDateTime.now());
        counter = collection.size();
        System.out.println("JSON loaded successfully. " + counter + " new Movies were added to the List");

        return collection;


    }
}

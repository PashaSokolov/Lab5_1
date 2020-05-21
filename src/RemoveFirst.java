import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
/**
 * реализация команды remove_first
 */

public class RemoveFirst implements Command {

    @Override
    public void execute(MovieList movieList) {
        if(!movieList.isEmpty()){
            try{
                movieList.remove(0);
                System.out.println("Movie was successfully removed");
            }catch (JsonSyntaxException e){
                System.out.println("JSON syntax error");
            }
        }else{
            System.out.println("Collection is empty");
        }
    }
}

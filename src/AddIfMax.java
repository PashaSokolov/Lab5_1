import java.util.Collections;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class AddIfMax implements BigCommand {
    private  Gson gson = new Gson();

    @Override
    public void execute(MovieList movieList, String s) {
        NullPointerChecker np = new NullPointerChecker();
        WrongFieldChecker wf = new WrongFieldChecker();

        if(!movieList.isEmpty()){
            try{
                Movie m = gson.fromJson(s,Movie.class);
                np.checkEverything(m);
                wf.checkEverything(m);
                if(m.compareTo(Collections.max(movieList))> 0){
                    movieList.add(m);
                    System.out.println("City was successfully added to the collection");
                }else{
                    System.out.println("City wasn't added to the collection");
                }
            }catch (JsonSyntaxException e){
                System.out.println("JSON syntax error");
            }
        }else{
            try{
                Movie m = gson.fromJson(s,Movie.class);
                np.checkEverything(m);
                wf.checkEverything(m);
                movieList.add(m);
                System.out.println("Collection is empty. Your city was added to the collection");
            }catch (JsonSyntaxException e){
                System.out.println("JSON syntax error");
            }
        }
    }
}

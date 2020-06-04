import com.google.gson.Gson;

import com.google.gson.JsonSyntaxException;

import com.google.gson.reflect.TypeToken;
/**
 * реализация команды add
 */
public class Add implements BigCommand {
    private Gson gson = new Gson();
    private NullPointerChecker np = new NullPointerChecker();
    private WrongFieldChecker wf = new WrongFieldChecker();

    @Override
    public void execute(MovieList movieList, String s) {
        
        try{
            int prevSize = movieList.size();
            Movie m = gson.fromJson(s,Movie.class);
            np.checkEverything(m);
            wf.checkEverything(m);
            if(!movieList.contains(m)){
                movieList.add(m);
                System.out.println(movieList.indexOf(m));
            }
            if(prevSize != movieList.size()){
                System.out.println("Element was successfully added to the collection.");
            }else{
                System.out.println("Collection already contains such element");
            }
        }catch (JsonSyntaxException e){
            System.out.println("JSON Syntax error. Element won't be added to the collection.");
        }
    }
}

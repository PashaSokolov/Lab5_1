import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class RemoveFirst implements BigCommand {
    private Gson gson = new Gson();
    private NullPointerChecker np = new NullPointerChecker();
    private WrongFieldChecker wf = new WrongFieldChecker();

    @Override
    public void execute(MovieList movieList, String s) {
        if(!movieList.isEmpty()){
            try{
                Movie m = gson.fromJson(s,Movie.class);
                np.checkEverything(m);
                wf.checkEverything(m);

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

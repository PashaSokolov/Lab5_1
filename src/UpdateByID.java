import com.google.gson.Gson;

import com.google.gson.JsonSyntaxException;

public class UpdateByID implements BigCommand {
    private Gson gson = new Gson();
    private NullPointerChecker np = new NullPointerChecker();
    private WrongFieldChecker wf = new WrongFieldChecker();

    @Override
    public void execute(MovieList movieList, String s) {
       boolean b = false;
       boolean ex = false;

       if(!movieList.isEmpty()){
           String[] params = s.split(" ",2);
           if(params.length == 2){
               try{
                   long neededID = Long.valueOf(params[0]);
                   for(Movie m : movieList){
                       if(m.getId() == neededID){
                           movieList.remove(m);
                           try{
                               Movie newM = gson.fromJson(params[1].trim(),Movie.class);
                               b = true;
                               newM.setId(neededID);
                               np.checkEverything(newM);
                               wf.checkEverything(newM);
                               movieList.add(newM);
                               System.out.println("Movie with ID " + neededID + " was updated successfully");
                           }catch (JsonSyntaxException e){
                               System.out.println("JSON syntax error");
                               ex = true;
                           }
                       }
                   }
               }catch (NumberFormatException e){
                   System.out.println("ID should be a number from 0 to " + Long.MAX_VALUE);
               }
               if(!b && !ex){
                   System.out.println("Nothing was changed");
               }
           }else{
               System.out.println("Inappropriate amount of parameters");
           }
       }else {
           System.out.println("Collection is empty");
       }
    }
}
